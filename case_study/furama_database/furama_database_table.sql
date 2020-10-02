DROP DATABASE IF EXISTS furama;

CREATE DATABASE furama;

USE furama;

create table positions (
position_id int auto_increment,
position_name varchar(45),
primary key (position_id)
);

create table levels (
level_id int auto_increment,
level_name varchar(45),
primary key (level_id)
);

create table departments (
department_id int auto_increment,
department_name varchar(45),
primary key (department_id)
);

create table employees (
employee_id int auto_increment,
employee_name varchar(45),
position_id int,
level_id int,
department_id int,
date_of_birth date,
id_number varchar(45),
salary double,
phone varchar(45),
email varchar(45),
address varchar(45),
primary key (employee_id)
);

create table customers (
customer_id int auto_increment,
type_of_customer_id int,
customer_name varchar(45),
date_of_birth date,
id_number varchar(45),
phone varchar(45),
email varchar(45),
address varchar(45),
primary key (customer_id)
);

create table types_of_customer (
type_of_customer_id int auto_increment,
type_name varchar(45),
primary key (type_of_customer_id)
);

create table accompanied_services (
accompanied_service_id int auto_increment,
accompanied_service_name varchar(45),
price double,
quantity int,
`status` varchar(45),
primary key (accompanied_service_id)
);

create table contract_details (
contract_details_id int auto_increment,
contract_id int,
accompanied_service_id int,
quantity int,
primary key (contract_details_id)
);

create table contracts (
contract_id int auto_increment,
employee_id int,
customer_id int,
service_id int,
contract_creation_date date,
contract_end_date date,
deposit double,
amount double,
primary key (contract_id)
);

create table services (
service_id int auto_increment,
service_name varchar(45),
area double,
number_of_floors int,
maximum_number_of_customers int,
rent_price double,
type_of_rent_id int,
type_of_service_id int,
`status` varchar(45),
primary key (service_id)
);

create table types_of_rent (
type_of_rent_id int auto_increment,
type_of_rent_name varchar(45),
price double,
primary key (type_of_rent_id)
);

create table types_of_service (
type_of_service_id int auto_increment,
type_of_service_name varchar(45),
primary key (type_of_service_id)
);

alter table employees
add foreign key (position_id)
references positions (position_id);

alter table employees
add foreign key (level_id)
references levels (level_id);

alter table employees
add foreign key (department_id)
references departments (department_id);

alter table customers
add foreign key (type_of_customer_id)
references types_of_customer (type_of_customer_id);

alter table contract_details
add foreign key (contract_id)
references contracts (contract_id);

alter table contract_details
add foreign key (accompanied_service_id)
references accompanied_services (accompanied_service_id);

alter table contracts
add foreign key (employee_id)
references employees (employee_id);

alter table contracts
add foreign key (customer_id)
references customers (customer_id);

alter table contracts
add foreign key (service_id)
references services (service_id);

alter table services
add foreign key (type_of_rent_id)
references types_of_rent (type_of_rent_id);

alter table services
add foreign key (type_of_service_id)
references types_of_service (type_of_service_id);

