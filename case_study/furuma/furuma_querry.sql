-- Thực hiện truy vấn theo yêu cầu sau:
-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL 
-- để có thể thõa mãn các yêu cầu bên dưới.
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống 
-- có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

SELECT * FROM employees 
WHERE employee_name REGEXP '^[HKT].{0,14}$';

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *, timestampdiff(year, date_of_birth, now()) as age
from customers
where 
timestampdiff(year, date_of_birth, now()) between 18 and 50
and
address in ('Da Nang', 'Quang Tri');

-- simple check

select customer_id, customer_name, timestampdiff(year, date_of_birth, now()) as age, address
from customers
where 
timestampdiff(year, date_of_birth, now()) between 18 and 50
and
address in ('Da Nang', 'Quang Tri');

-- Tuổi
-- Cách 1: 
-- between là bao gồm 2 đầu, lớn hơn ( nhỏ hơn) hoặc bằng
-- SELECT year(date1) - year(date2) AS difference FROM table;

select customer_name, year(now()) - year(date_of_birth) as age 
from customers
where 
(year(now()) - year(date_of_birth)) between 18 and 50;

-- Cách 2: 
-- SELECT TIMESTAMPDIFF(YEAR, date1, date2) AS difference FROM table;

select customer_name, timestampdiff(year, date_of_birth, now()) as age 
from customers
where 
timestampdiff(year, date_of_birth, now()) >= 18 
and 
timestampdiff(year, date_of_birth, now()) <= 50;

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select customers.customer_id, customers.customer_name, types_of_customer.type_name, 
count(contracts.contract_id) as number_of_contracts
from customers 
join types_of_customer on customers.type_of_customer_id = types_of_customer.type_of_customer_id
join contracts on contracts.customer_id = customers.customer_id
where types_of_customer.type_name = 'Diamond'
group by customers.customer_id
order by count(contracts.contract_id);

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu,
--  NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select customers.customer_id,
customers.customer_name, 
types_of_customer.type_name, 
contracts.contract_id, services.service_name,
contracts.contract_creation_date, contracts.contract_end_date,
sum(services.rent_price + contract_details.quantity * accompanied_services.price) as amount
from customers
left join types_of_customer on types_of_customer.type_of_customer_id = customers.type_of_customer_id
left join contracts on contracts.customer_id = customers.customer_id
left join services on services.service_id = contracts.service_id
left join contract_details on contract_details.contract_id = contracts.contract_id
left join accompanied_services on accompanied_services.accompanied_service_id = contract_details.accompanied_service_id
group by customers.customer_id;

-- draft

select customers.customer_id,
services.rent_price + contract_details.quantity * accompanied_services.price,
services.rent_price, contract_details.quantity, accompanied_services.price,
customers.customer_name, 
types_of_customer.type_name, 
contracts.contract_id, services.service_name,
contracts.contract_creation_date, contracts.contract_end_date
from customers
left join types_of_customer on types_of_customer.type_of_customer_id = customers.type_of_customer_id
left join contracts on contracts.customer_id = customers.customer_id
left join services on services.service_id = contracts.service_id
left join contract_details on contract_details.contract_id = contracts.contract_id
left join accompanied_services on accompanied_services.accompanied_service_id = contract_details.accompanied_service_id;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).


-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
 




