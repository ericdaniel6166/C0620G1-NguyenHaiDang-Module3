-- DROP DATABASE IF EXISTS my_database;

-- CREATE DATABASE my_database;

-- USE my_database;

-- -- 2.Chỉ SELECT những trường mà bạn cần

-- -- SELECT name FROM USER;
-- -- Thay vì
-- -- SELECT * FROM USER;

-- -- 4. Cách sử dụng index

-- CREATE TABLE customers (
--     customer_number INT NOT NULL AUTO_INCREMENT,
--     customer_name VARCHAR(50) NOT NULL,
--     phone VARCHAR(50) NOT NULL,
--     address_line_1 VARCHAR(50) NOT NULL,
--     PRIMARY KEY (customer_number)
-- );

-- INSERT INTO `my_database`.`customers` (`customer_name`, `phone`, `address_line_1`) VALUES ('An', '0123456789', 'Da Nang');
-- INSERT INTO `my_database`.`customers` (`customer_name`, `phone`, `address_line_1`) VALUES ('Binh', '0111444777', 'Ha Noi');
-- INSERT INTO `my_database`.`customers` (`customer_name`, `phone`, `address_line_1`) VALUES ('Tuan', '0333666999', 'HCM');
-- INSERT INTO `my_database`.`customers` (`customer_name`, `phone`, `address_line_1`) VALUES ('Duc', '0765387654', 'Da Lat');

-- explain select * from customers
-- where phone = 0333666999;

USE classicmodels;

select * from customers;

explain select * from customers
where phone = 2155554695;

CREATE INDEX phone_idx
ON customers (phone);

explain select * from customers
where phone = 2155554695;

drop index phone_idx
on customers;

explain select * from customers
where phone = 2155554695;

