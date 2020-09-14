DROP DATABASE IF EXISTS my_database;

CREATE DATABASE my_database;

USE my_database;

create table customers (
customer_number int not null,
customer_name varchar(50) not null,
contact_last_name varchar(50) not null,
contact_first_name varchar(50) not null,
phone varchar(50) not null,
address_line_1 varchar(50) not null,
address_line_2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postal_code varchar(15) not null,
country varchar(50) not null,
credit_limit int,
primary key (customer_number)
);

create table orders (
order_number int not null,
customer_number int not null,
order_date date not null,
required_date date not null,
shipped_date date,
order_status varchar(15) not null,
comments varchar(45),
quantity_ordered int not null,
price_each double not null,
primary key (order_number)
);

create table payments (
payment_id int not null,
customer_number int not null,
check_number varchar(50) not null,
payment_date date not null,
amount double not null,
primary key (payment_id)
);

create table products (
product_code varchar(15) not null,
product_name varchar(70) not null,
product_scale varchar(10) not null,
product_description varchar(50) not null,
quantity_in_stock int not null,
buy_price double not null,
msrp double not null,
primary key (product_code)
);

create table productlines (
prodductline_id varchar(50) not null,
text_description varchar(50),
image varchar(50),
primary key (prodductline_id)
);

create table employees (
employee_number int not null,
last_name varchar(50) not null,
first_name varchar(50) not null,
email varchar(100) not null,
job_title varchar(50) not null,
primary key (employee_number)
);

create table offices (
office_code varchar(10) not null,
city varchar(50) not null,
phone varchar(50) not null,
address_line_1 varchar(50) not null,
address_line_2 varchar(50),
state varchar(50),
country varchar(50) not null,
postal_code varchar(15) not null,
primary key (office_code)
);

alter table orders 
add foreign key (customer_number) 
references customers (customer_number);

alter table payments
add foreign key (customer_number) 
references customers (customer_number); 


