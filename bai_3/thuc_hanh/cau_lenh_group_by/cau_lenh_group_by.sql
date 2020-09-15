USE classicmodels;

select status from orders 
group by status;

-- COUNT(*) đếm số dòng 

select status, COUNT(*) as 'So luong status'
from orders
group by status;

-- group by
-- sum  

-- tính tổng số tiền, nhóm theo trường status 

select status, sum(quantityOrdered * priceEach) as amount
from orders 
inner join orderdetails on orders.ordernumber = orderdetails.ordernumber
group by status;

-- tính tổng tiền của từng đơn hàng

select orderNumber, sum(quantityOrdered * priceEach) as total
from orderdetails
group by orderNumber;

-- GROUP BY với mệnh đề HAVING
-- Các hàm tập hợp (SUM, MAX, MIN, COUNT, AVG)
-- hàm gộp 

select year(orderDate) as year, sum(quantityOrdered * priceEach) as total
from orders 
inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
where status = 'shipped'
group by year
having year > 2003;

-- Lưu ý thứ tự thực hiện các lệnh.

-- select columnname(s) from tablename 
-- where conditional
-- group by ... having ...