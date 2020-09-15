USE classicmodels;

-- Hàm AVG() trả về giá trị trung bình 
-- của một cột kiểu số.

select avg(buyPrice) from products;

-- Hàm COUNT() trả về số lượng bản ghi 
-- thoả mãn điền kiện đưa ra.

 select count(productcode) from products;
 
-- Hàm MAX() trả về giá trị lớn nhất 
-- trong một cột và thoả mãn điều kiện đưa ra.

select max(buyprice) from products;

 -- Hàm MIN() trả về giá trị nhỏ nhất 
 -- trong một cột và thoả mãn điều kiện đưa ra. 
 
 select min(buyprice) from products;
 
 -- Hàm SUM() trả về tổng giá trị 
 -- của một cột kiểu số.
 
 select sum(quantityInStock) from products;
 
 select sum(quantityInStock) 
 from products 
 where productline = 'Motorcycles';
 
 -- Hàm UCASE() chuyển giá trị của một trường sang chữ viết hoa.
 
 select ucase(productName) from products;
 
 -- Hàm LCASE() chuyển giá trị của một trường sang chữ viết thường.
 
 select lcase(productName) from products;
 
 -- Hàm LEN() trả về độ dài của chuỗi (số lượng ký tự) 
 -- của một giá trị trong cột kiểu chuỗi. 
 
 select length(productName) 
 from products
 where productCode = 'S10_1678';
 
 -- Hàm NOW() trả về ngày tháng và thời gian hiện tại.

SELECT NOW();

-- Mệnh đề GROUP BY thường được sử dụng cùng với các hàm như 
-- COUNT(), MAX(), MIN(), SUM(), AVG() 
-- để tách thành các nhóm con theo một cột (hoặc nhiều cột).

select productVendor, count(productcode) 
from products
where productline = 'Motorcycles'
group by productVendor
order by productVendor;

-- Mệnh đề HAVING có chức năng lọc dữ liệu như mệnh đề WHERE 
-- nhưng sử dụng cùng với các hàm SQL.
 
 select productVendor, count(productcode) from products
where productline = 'Motorcycles'
group by productVendor
having count(productCode) > 1
order by productVendor;

-- ROUND() làm tròn 

SELECT productVendor, 
   ROUND(AVG(buyPrice), 2) 
FROM products 
group by productVendor;
 

 
 
