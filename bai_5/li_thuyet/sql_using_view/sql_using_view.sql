use classicmodels;

-- CREATE VIEW view_name AS

-- SELECT column1, column2.....

-- FROM table_name

-- WHERE [condition]

select * from customers;

drop view if exists customer_view;

create view customer_view as
select customerNumber, customerName, creditLimit from customers;

select * from customer_view;

-- WITH CHECK OPTION là một tùy chọn của lệnh CREATE VIEW. 
-- Mục đích của WITH CHECK OPTION là bảo đảm rằng 
-- tất cả UPDATE và INSERT thỏa mãn các điều kiện trong định nghĩa VIEW.
-- Nếu chúng không thỏa mãn các điều kiện, 
-- UPDATE và INSERT sẽ trả về một lỗi.

drop view if exists customer_view;

create view customer_view as
select customerNumber, customerName, creditLimit from customers
with check option;

select * from customer_view;

-- insert update, delete row của view
-- View có thể được update, insert 
-- với các điều kiện nhất định được đưa ra dưới đây:
-- Mệnh đề SELECT không được chứa từ khoá DISTINCT.
-- Mệnh đề SELECT không được chứa các hàm tổng.
-- Mệnh đề SELECT có thể không chứa các hàm tập hợp.
-- Mệnh đề SELECT không được chứa các toán tử tập hợp.
-- Mệnh đề SELECT không được chứa mệnh đề ORDER BY.
-- Mệnh đề FROM không được chứa nhiều bảng.
-- Mệnh đề WHERE không được chứa các truy vấn con.
-- Truy vấn không chứa GROUP BY hoặc HAVING.
-- Các cột được ứng lượng không thể được update.
-- Tất cả các cột NOT NULL từ bảng cơ sở 
-- phải được select trong view để truy vấn INSERT hoạt động.
-- Lỗi



update customer_view 
set creditLimit = 'da_sua'
where customerNumber = 103;

-- Không lỗi

update customer_view 
set creditLimit = 10.1
where customerNumber = 103;

update customer_view 
set creditLimit = 21000.00
where customerNumber = 103;




