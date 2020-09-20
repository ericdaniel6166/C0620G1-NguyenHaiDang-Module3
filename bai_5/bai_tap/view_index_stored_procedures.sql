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
-- Tiến hành sửa đổi view
-- Tiến hành xoá view

SELECT * FROM products;

create view products_view as
select product_code, product_name, 
product_price, product_status 
from products;

SELECT * FROM products_view;

create or replace products_view as
select

-- Bước 5:

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id