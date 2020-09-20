drop procedure if exists select_all_customers;

delimiter //
create procedure select_all_customers ()
begin
select * from customers;
end // 
delimiter ;

call select_all_customers;

-- in

drop procedure if exists select_column_table;

delimiter $
create procedure customers_creadit_limit (
in customer_id decimal(10,2),
out total double,
out average double
)
begin
DECLARE count int default 0;	-- Khai báo biến count kiểu integer mặc định = 0

SET count = (c);
end $ 
delimiter ;

SELECT COUNT(customerNumber) FROM customers WHERE customerNumber = 103;

select * from customers;

call select_column_table ('customerNumber', 'customers');