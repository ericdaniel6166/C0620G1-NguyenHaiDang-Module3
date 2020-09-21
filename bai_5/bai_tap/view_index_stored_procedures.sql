drop database if exists demo;

create database demo;

use demo;

create table products (
id int auto_increment,
product_code varchar(15),
product_name varchar(45),
product_price double,
product_amount double,
product_description text,
product_status varchar(45),
primary key (id)
);

INSERT INTO `demo`.`products` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) VALUES ('SVRO-1111', 'ring', '12000000', '15', '1111 abc abc', 'shipped');
INSERT INTO `demo`.`products` (`product_code`, `product_name`, `product_amount`, `product_description`, `product_status`) VALUES ('SVHO-2345', 'hoodie', '120', '2345 qwe qwe', 'making');
INSERT INTO `demo`.`products` (`product_code`, `product_name`, `product_amount`, `product_description`, `product_status`) VALUES ('SVVL-9876', 'volley ball', '74', '9876 jjj kkk lll', 'shipped');
INSERT INTO `demo`.`products` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) VALUES ('SVRO-7654', 'ring', '21000000', '8', '7654 rtyu rtyu', 'making');
UPDATE `demo`.`products` SET `product_price` = '1200000' WHERE (`id` = '2');
UPDATE `demo`.`products` SET `product_price` = '150000' WHERE (`id` = '3');
INSERT INTO `demo`.`products` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) VALUES ('SVRO-6464', 'rose', '50000', '8', '6464 bnbnmn', 'shipped');


-- Bước 3:

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
drop index idx_product_code on products;

explain SELECT * FROM products 
where product_code = 'SVRO-1111';

create unique index idx_product_code 
on products (product_code);

explain SELECT * FROM products 
where product_code = 'SVRO-1111';

-- alter table products
-- add unique index idx_product_code (product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index

drop index idx_product_name on products;
drop index idx_product_price on products;

explain select * from products 
where product_name = 'ring' and product_price = 21000000;

alter table products
add index idx_product_name (product_name),
add index idx_product_price (product_price);

explain select * from products 
where product_name = 'ring' and product_price = 21000000;

-- Bước 4:

-- Tạo view lấy về các thông tin: productCode, productName, 
-- productPrice, productStatus từ bảng products.

SELECT * FROM products;

create view products_view as
select product_code, product_name, 
product_price, product_status 
from products;

SELECT * FROM products_view;

-- Tiến hành sửa đổi view

create or replace view products_view as
select product_code, product_name, 
product_price 
from products;

SELECT * FROM products_view;

-- Tiến hành xoá view

drop view products_view;

-- Bước 5:

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
drop procedure if exists select_all_products;

delimiter //
create procedure select_all_products ()
begin
select * from products;
end //
delimiter ;

call select_all_products ();

-- Tạo store procedure thêm một sản phẩm mới

drop procedure if exists insert_product;

delimiter //
create procedure insert_product 
(in insert_code varchar(15),
in insert_name varchar(45),
in insert_price double,
in insert_amount double,
in insert_description text,
in insert_status varchar(45))
begin
INSERT INTO products 
(product_code, product_name, product_price, 
product_amount, product_description, product_status) 
VALUES 
(insert_code, insert_name, insert_price, 
insert_amount, insert_description, insert_status);
end //
delimiter ;

call insert_product 
('SVRO-9999', 'insert_product', '99000000', 
'99', '999 zzz zzz', 'shipped');

SELECT * FROM products;

-- Tạo store procedure sửa thông tin sản phẩm theo id

drop procedure if exists edit_product;

delimiter //
create procedure edit_product 
(in edit_id int,
in edit_code varchar(15),
in edit_name varchar(45),
in edit_price double,
in edit_amount double,
in edit_description text,
in edit_status varchar(45))
begin
UPDATE products 
SET 
product_code = edit_code, 
product_name = edit_name, 
product_price = edit_price, 
product_amount = edit_amount, 
product_description = edit_description, 
product_status = edit_status
WHERE (id = edit_id);
end //

call edit_product 
(6, 'SVRO-8888', 'edit_product', '88000000', 
'88', '888 zzz zzz', 'making');

SELECT * FROM products;

-- Tạo store procedure xoá sản phẩm theo id

drop procedure if exists delete_product;

delimiter //
create procedure delete_product 
(in delete_id int)
begin
delete from products where id = delete_id;
end //
delimiter ;



call delete_product (6);

SELECT * FROM products;