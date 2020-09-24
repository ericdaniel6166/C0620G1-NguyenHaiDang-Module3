-- Thực hiện truy vấn theo yêu cầu sau:
-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL 
-- để có thể thõa mãn các yêu cầu bên dưới.
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống 
-- có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

SELECT * FROM employees 
WHERE employee_name REGEXP '^[HKT][a-zA-Z]+$' and length(employee_name) <= 15;

SELECT * FROM employees 
WHERE employee_name REGEXP '^([a-zA-Z]+[ ])+[HKT][a-zA-Z]+$' 
and length(employee_name) <= 15;


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
--  date2 - date1 

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
left join types_of_customer on customers.type_of_customer_id = types_of_customer.type_of_customer_id
left join contracts on contracts.customer_id = customers.customer_id
where types_of_customer.type_name = 'Diamond'
group by customers.customer_id
order by count(contracts.contract_id);

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu,
--  NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
-- Chú ý 
-- number + null = null

select customers.customer_id,
customers.customer_name, 
types_of_customer.type_name, 
contracts.contract_id, services.service_name,
contracts.contract_creation_date, contracts.contract_end_date,
sum(services.rent_price + contract_details.quantity * accompanied_services.price) as total_amount
from customers
left join types_of_customer on types_of_customer.type_of_customer_id = customers.type_of_customer_id
left join contracts on contracts.customer_id = customers.customer_id
left join services on services.service_id = contracts.service_id
left join contract_details on contract_details.contract_id = contracts.contract_id
left join accompanied_services on accompanied_services.accompanied_service_id = contract_details.accompanied_service_id
group by customers.customer_id;

-- draft
-- chưa group by 

select customers.customer_id,
services.rent_price + contract_details.quantity * accompanied_services.price as amount,
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

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ 
-- quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select services.service_id, services.service_name, services.area,
services.rent_price, types_of_service.type_of_service_name, contracts.contract_creation_date,
datediff(contracts.contract_creation_date, '2019-01-01') 
from services
left join types_of_service on types_of_service.type_of_service_id = services.type_of_service_id
left join contracts on contracts.service_id = services.service_id
where services.service_id not in
(select services.service_id
from services
left join contracts on contracts.service_id = services.service_id
where datediff(contract_creation_date, '2019-01-01') > 0
)
group by services.service_id
order by services.service_id;

-- chưa group by

select services.service_id, services.service_name, services.area,
services.rent_price, types_of_service.type_of_service_name, contracts.contract_creation_date,
datediff(contracts.contract_creation_date, '2019-01-01') from services
left join types_of_service on types_of_service.type_of_service_id = services.type_of_service_id
left join contracts on contracts.service_id = services.service_id
where services.service_id not in
(select services.service_id
from services
left join contracts on contracts.service_id = services.service_id
where datediff(contract_creation_date, '2019-01-01') > 0
);

-- Dịch vụ đã từng được đặt từ 
-- quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3)

select services.service_id, services.service_name, services.area,
services.rent_price, types_of_service.type_of_service_name, contracts.contract_creation_date,
datediff(contracts.contract_creation_date, '2019-01-01') from services
left join types_of_service on types_of_service.type_of_service_id = services.type_of_service_id
left join contracts on contracts.service_id = services.service_id
where datediff(contract_creation_date, '2019-01-01') > 0
group by service_id;

-- chưa group by

select services.service_id, services.service_name, services.area,
services.rent_price, types_of_service.type_of_service_name, contracts.contract_creation_date,
datediff(contracts.contract_creation_date, '2019-01-01') from services
left join types_of_service on types_of_service.type_of_service_id = services.type_of_service_id
left join contracts on contracts.service_id = services.service_id
where datediff(contract_creation_date, '2019-01-01') > 0
order by services.service_id;

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select services.service_id, services.service_name, services.area, services.maximum_number_of_customers,
services.rent_price, types_of_service.type_of_service_name, contracts.contract_creation_date from services
left join types_of_service on types_of_service.type_of_service_id = services.service_id
left join contracts on contracts.service_id = services.service_id
where year(contracts.contract_creation_date) = 2018 
and services.service_id not in 
(select services.service_id from services
left join contracts on contracts.service_id = services.service_id
where year(contracts.contract_creation_date) = 2019 );

-- draft
-- Dịch vụ dùng trong năm 2018 

select services.service_id, services.service_name, contracts.contract_creation_date from services
left join contracts on contracts.service_id = services.service_id
where year(contracts.contract_creation_date) = 2018;

-- Dịch vụ dùng trong năm 2019

select services.service_id, services.service_name, contracts.contract_creation_date from services
left join contracts on contracts.service_id = services.service_id
where year(contracts.contract_creation_date) = 2019;


-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- Cách 1 

select distinct customer_name from customers;

-- Cách 2

select customer_name from customers
group by customer_name;

-- Cách 3

select customer_name from customers
union
select customer_name from customers;

-- draft
-- số lượng khách hàng cùng tên 

select customer_name, count(customer_id) from customers
group by customer_name;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(contract_creation_date), year(contract_creation_date), sum(amount) from contracts
where year(contract_creation_date) = 2019
group by month(contract_creation_date)
order by month(contract_creation_date);

select month(contract_creation_date), year(contract_creation_date), amount from contracts
where year(contract_creation_date) = 2019
order by month(contract_creation_date);

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).

select contracts.contract_id, contracts.contract_creation_date, contracts.contract_end_date,
contracts.deposit, count(contract_details.contract_details_id) from contracts
left join contract_details on contract_details.contract_id = contracts.contract_id
group by contracts.contract_id;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng 
-- có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select customers.customer_id,customers.customer_name,customers.date_of_birth,customers.id_number,
customers.phone, customers.email, customers.address, types_of_customer.type_name from customers
left join types_of_customer on types_of_customer.type_of_customer_id = customers.type_of_customer_id
where types_of_customer.type_name = 'Diamond'
and customers.address in ('Vinh', 'Quang Ngai');

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, 
-- TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select services.service_id, contracts.contract_creation_date, contracts.contract_id, employees.employee_name, 
customers.customer_name, customers.phone, services.service_name, 
contract_details.contract_details_id  from contracts 
left join employees on employees.employee_id = contracts.employee_id
left join customers on customers.customer_id = contracts.customer_id
left join services on services.service_id = contracts.service_id
left join contract_details on contract_details.contract_id = contracts.contract_id
where year(contracts.contract_creation_date) = 2019 and month(contracts.contract_creation_date) between 10 and 12
and services.service_id not in 
(select services.service_id  from services
left join contracts on services.service_id = contracts.service_id
where year(contracts.contract_creation_date) = 2019 
and month(contracts.contract_creation_date) between 1 and 6
);

-- đặt 3 tháng 10,11,12 năm 2019

select services.service_id, contracts.contract_creation_date, contracts.contract_id, employees.employee_name, 
customers.customer_name, customers.phone, services.service_name, 
contract_details.contract_details_id  from contracts 
left join employees on employees.employee_id = contracts.employee_id
left join customers on customers.customer_id = contracts.customer_id
left join services on services.service_id = contracts.service_id
left join contract_details on contract_details.contract_id = contracts.contract_id
where year(contracts.contract_creation_date) = 2019 
and month(contracts.contract_creation_date) between 10 and 12;

-- đặt 6 tháng từ 1 đến 6 năm 2019

select services.service_id, contracts.contract_creation_date, contracts.contract_id, employees.employee_name, 
customers.customer_name, customers.phone, services.service_name, 
contract_details.contract_details_id  from contracts 
left join employees on employees.employee_id = contracts.employee_id
left join customers on customers.customer_id = contracts.customer_id
left join services on services.service_id = contracts.service_id
left join contract_details on contract_details.contract_id = contracts.contract_id
where year(contracts.contract_creation_date) = 2019 
and month(contracts.contract_creation_date) between 1 and 6;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

drop view if exists number_of_uses_accompanied_services;

create view number_of_uses_accompanied_services as 
select accompanied_services.accompanied_service_id, accompanied_services.accompanied_service_name,
count(contract_details_id) as number_of_uses from accompanied_services
left join contract_details on contract_details.accompanied_service_id = accompanied_services.accompanied_service_id
group by accompanied_services.accompanied_service_id
order by count(contract_details_id) desc;

select accompanied_services.accompanied_service_id, accompanied_services.accompanied_service_name,
count(contract_details_id) as number_of_uses from accompanied_services
left join contract_details on contract_details.accompanied_service_id = accompanied_services.accompanied_service_id
group by accompanied_services.accompanied_service_id
order by count(contract_details_id) desc;

select * from
number_of_uses_accompanied_services;

select accompanied_service_id, accompanied_service_name, number_of_uses 
from number_of_uses_accompanied_services
where number_of_uses in 
(select max(number_of_uses) 
from number_of_uses_accompanied_services
);

-- đếm từng dịch vụ đi kèm

select accompanied_services.accompanied_service_id, accompanied_services.accompanied_service_name,
count(contract_details_id) as number_of_uses from accompanied_services
left join contract_details on contract_details.accompanied_service_id = accompanied_services.accompanied_service_id
group by accompanied_services.accompanied_service_id
order by count(contract_details_id) desc;


-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select accompanied_services.accompanied_service_id, accompanied_services.accompanied_service_name,
count(contract_details_id) as number_of_uses,
contracts.contract_id, types_of_service.type_of_service_name from accompanied_services
left join contract_details on contract_details.accompanied_service_id = accompanied_services.accompanied_service_id
left join contracts on contracts.contract_id = contract_details.contract_id
left join services on services.service_id = contracts.service_id
left join types_of_service on types_of_service.type_of_service_id = services.type_of_service_id
group by accompanied_services.accompanied_service_id
having count(contract_details_id) =1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, 
-- TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select employees.employee_id, 
year(contracts.contract_creation_date), count(contracts.contract_id),
employees.employee_name from employees
left join contracts on contracts.employee_id = employees.employee_id
where year(contracts.contract_creation_date) between 2018 and 2019
group by employees.employee_id
having count(contracts.contract_id) >=3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
-- Cách alter foreign key on delete cascade
-- 1. tìm constraint foreign key trong table rồi drop foreign key + tên constraint
-- alter table services
-- drop foreign key services_ibfk_2;
-- 2. alter add foreign key thêm on delete cascade
-- alter table services
-- add foreign key (type_of_service_id)
-- references types_of_service (type_of_service_id) on DELETE CASCADE;

-- Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019

select employee_id, employee_name, id_number
from employees
where employee_id not in 
(select employees.employee_id from employees
left join contracts on contracts.employee_id = employees.employee_id
where year(contracts.contract_creation_date) between 2017 and 2019
);

-- Nhân viên từng lập được hợp đồng nào từ năm 2017 đến năm 2019

select employees.employee_id, 
year(contracts.contract_creation_date), count(contracts.contract_id),
employees.employee_name from employees
left join contracts on contracts.employee_id = employees.employee_id
where year(contracts.contract_creation_date) between 2017 and 2019
group by employees.employee_id;

-- Xoá 

alter table contracts
drop foreign key contracts_ibfk_1;

alter table contracts
add foreign key (employee_id) 
references employees (employee_id) on delete cascade;

delete from employees 
where employee_id in (
select * from (
select employee_id
from employees
where employee_id not in 
(select employees.employee_id from employees
left join contracts on contracts.employee_id = employees.employee_id
where year(contracts.contract_creation_date) between 2017 and 2019
)) as temp);

-- Sau xoá, khách hàng thoả mãn điều kiện

select employee_id, employee_name, id_number
from employees
where employee_id not in 
(select employees.employee_id from employees
left join contracts on contracts.employee_id = employees.employee_id
where year(contracts.contract_creation_date) between 2017 and 2019
);


-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
-- Trước Update, Khách hàng thoả mãn điều kiện 

select customers.customer_id, customer_name, types_of_customer.type_name, sum(contracts.amount) from customers 
left join types_of_customer on types_of_customer.type_of_customer_id = customers.type_of_customer_id
left join contracts on contracts.customer_id = customers.customer_id
where year(contracts.contract_creation_date) = 2019 and types_of_customer.type_name = 'Platinium'
group by customers.customer_id
having sum(contracts.amount) > 10000000;

-- Trước Update, Khách hàng Diamond

select customers.customer_id, customer_name, types_of_customer.type_name from customers 
left join types_of_customer on types_of_customer.type_of_customer_id = customers.type_of_customer_id
where types_of_customer.type_name = 'Diamond';

-- Update 

update customers 
set customers.type_of_customer_id = (
select types_of_customer.type_of_customer_id 
from types_of_customer 
where types_of_customer.type_name = 'Diamond')
where customers.customer_id in (
select * from (
select customers.customer_id from customers 
left join types_of_customer on types_of_customer.type_of_customer_id = customers.type_of_customer_id
left join contracts on contracts.customer_id = customers.customer_id
where year(contracts.contract_creation_date) = 2019 and types_of_customer.type_name = 'Platinium'
group by customers.customer_id
having sum(contracts.amount) > 10000000
) as temp);

-- Sau update, khách hàng Diamond

select customers.customer_id, customer_name, types_of_customer.type_name 
from customers 
left join types_of_customer on types_of_customer.type_of_customer_id = customers.type_of_customer_id
where types_of_customer.type_name = 'Diamond';


-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
-- Trước xoá, khách hàng thoả mãn điều kiện
select customers.customer_id, customers.customer_name, contracts.contract_creation_date 
from customers 
left join contracts on contracts.customer_id = customers.customer_id
where year(contracts.contract_creation_date) < 2016;

-- Xoá

alter table contracts
drop foreign key contracts_ibfk_2;

alter table contracts
add foreign key (customer_id) 
references customers (customer_id) on delete cascade;

delete from customers
where customers.customer_id in (
select * from (
select customers.customer_id
from customers 
left join contracts on contracts.customer_id = customers.customer_id
where year(contracts.contract_creation_date) < 2016
) as temp);

-- Sau xoá, khách hàng thoat mãn điều kiện

select customers.customer_id, customers.customer_name, contracts.contract_creation_date 
from customers 
left join contracts on contracts.customer_id = customers.customer_id
where year(contracts.contract_creation_date) < 2016;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
-- Trước update
select accompanied_service_id, accompanied_service_name, price 
from accompanied_services;
-- Update
update accompanied_services
set accompanied_services.price = accompanied_services.price * 2
where accompanied_services.accompanied_service_id in 
(select * from 
(select accompanied_services.accompanied_service_id
from accompanied_services
left join contract_details on contract_details.accompanied_service_id = accompanied_services.accompanied_service_id
left join contracts on contracts.contract_id = contract_details.contract_id
group by accompanied_services.accompanied_service_id
having count(contracts.contract_id) > 10) as temp)
;

-- Sau Update 

select accompanied_service_id, accompanied_service_name, price 
from accompanied_services;

-- draft

select accompanied_services.accompanied_service_id, accompanied_services.accompanied_service_name, count(contracts.contract_id)
from accompanied_services
left join contract_details on contract_details.accompanied_service_id = accompanied_services.accompanied_service_id
left join contracts on contracts.contract_id = contract_details.contract_id
group by accompanied_services.accompanied_service_id;

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select employee_id as id, employee_name as `name`, email, phone, date_of_birth, address, 'employee' as `employee/customer`  
from employees
union
select customer_id as id, customer_name as `name`, email, phone, date_of_birth, address, 'customer' as `employee/customer` 
from customers
order by `employee/customer`, id;

-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin 
-- của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view v_employee as
select employees.employee_id, employees.employee_name, employees.address, contracts.contract_creation_date,
positions.position_name, levels.level_name, departments.department_name,
employees.date_of_birth, employees.id_number, employees.salary, employees.phone,
employees.email
from employees
left join contracts on contracts.employee_id = employees.employee_id
left join positions on positions.position_id = employees.position_id
left join departments on departments.department_id = employees.department_id
left join levels on levels.level_id = employees.employee_id 
where employees.address like '%Hai Chau%' and contracts.contract_creation_date = '2019-12-12';

select * from v_employee;

drop view v_employee;

-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
create view v_employee as
select employees.employee_id, employees.employee_name, employees.address, contracts.contract_creation_date,
positions.position_name, levels.level_name, departments.department_name,
employees.date_of_birth, employees.id_number, employees.salary, employees.phone,
employees.email
from employees
left join contracts on contracts.employee_id = employees.employee_id
left join positions on positions.position_id = employees.position_id
left join departments on departments.department_id = employees.department_id
left join levels on levels.level_id = employees.employee_id 
where employees.address like '%Da Nang%' and contracts.contract_creation_date = '2019-10-13';

select * from v_employee;

update employees
set address = 'Lien Chieu, Da Nang'
where employees.employee_id in 
(select * from (
select employee_id from v_employee ) as temp);

select * from v_employee;


-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó 
-- với Id Khách hàng được truyền vào như là 1 tham số của Sp_1

delete from customers 
where customer_id = 16;

drop procedure if exists sp_1;

delimiter //
create procedure sp_1 
(in id int)
begin
delete from customers 
where customer_id = id;
end // 
delimiter ;

INSERT INTO customers (customer_id, type_of_customer_id, customer_name) VALUES (16, 2, 'Minh Tuan');

call sp_1 (16);

SELECT * FROM customers;

-- 24.	Tạp Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khó chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

INSERT INTO contracts 
(contract_id, employee_id, customer_id, service_id, contract_creation_date, contract_end_date, deposit, amount) 
VALUES (47, 10, 7, 9, '2019-03-01', '2019-03-20', 5000000, 14500000);

INSERT INTO contracts 
(employee_id, customer_id, service_id, contract_creation_date, contract_end_date, deposit, amount) 
VALUES (id_employee, id_customer, id_service, creation_date, end_date, contract_deposit, contract_amount);

delete from contracts
where contract_id = 47;

SELECT * FROM contracts;


drop procedure if exists sp_2;

delimiter //
create procedure sp_2 
(in id_employee int,
in id_customer int,
in id_service int,
in creation_date date,
in end_date date,
in contract_deposit double,
in contract_amount double)
begin
set @result = false;

INSERT INTO contracts 
(employee_id, customer_id, service_id, contract_creation_date, contract_end_date, deposit, amount) 
VALUES (id_employee, id_customer, id_service, creation_date, end_date, contract_deposit, contract_amount);
set @result = true;
select @result;
end // 
delimiter ;

SELECT * FROM contracts;

delete from contracts
where contract_id = 47;

delete from contracts
where contract_id = 48;

call sp_2 (10, 7, 9, '2019-03-01', '2019-03-20', 5000000, 14500000);

SELECT * FROM contracts;

-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong 
-- thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database

-- 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, 
-- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ 
-- thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” 
-- trên console của database

-- 27.	Tạo user function thực hiện yêu cầu sau:
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
delimiter //
CREATE FUNCTION func_1 ()
RETURNS INTEGER
BEGIN
set @a= 
(select count(*) 
from (select services.service_id, services.service_name, sum(contracts.amount) from services
left join contracts on contracts.service_id = services.service_id
group by services.service_id
having sum(contracts.amount) > 2000000) as temp);
RETURN @a;
END //
delimiter ;



select count(*) 
from (select services.service_id, services.service_name, sum(contracts.amount) from services
left join contracts on contracts.service_id = services.service_id
group by services.service_id
having sum(contracts.amount) > 2000000) as temp;

select services.service_id, services.service_name, sum(contracts.amount) from services
left join contracts on contracts.service_id = services.service_id
group by services.service_id
having sum(contracts.amount) > 2000000
;

select services.service_id, services.service_name, contracts.amount from services
left join contracts on contracts.service_id = services.service_id
;

-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được truyền vào như là 1 tham số của function này.
-- 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.



