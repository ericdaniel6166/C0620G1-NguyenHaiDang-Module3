DROP DATABASE IF EXISTS my_database;

CREATE DATABASE my_database;

USE my_database;

CREATE TABLE customers (
    customer_number INT NOT NULL,
    sales_rep_employee_number INT NOT NULL,
    customer_name VARCHAR(50) NOT NULL,
    contact_last_name VARCHAR(50) NOT NULL,
    contact_first_name VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    address_line_1 VARCHAR(50) NOT NULL,
    address_line_2 VARCHAR(50),
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postal_code VARCHAR(15) NOT NULL,
    country VARCHAR(50) NOT NULL,
    credit_limit INT,
    PRIMARY KEY (customer_number)
);

CREATE TABLE orders (
    order_number INT NOT NULL,
    customer_number INT NOT NULL,
    order_date DATE NOT NULL,
    required_date DATE NOT NULL,
    shipped_date DATE,
    order_status VARCHAR(15) NOT NULL,
    comments VARCHAR(45),
    quantity_ordered INT NOT NULL,
    price_each DOUBLE NOT NULL,
    PRIMARY KEY (order_number)
);

CREATE TABLE payments (
    payment_id INT NOT NULL,
    customer_number INT NOT NULL,
    check_number VARCHAR(50) NOT NULL,
    payment_date DATE NOT NULL,
    amount DOUBLE NOT NULL,
    PRIMARY KEY (payment_id)
);

CREATE TABLE products (
    product_code VARCHAR(15) NOT NULL,
    prodductline_id VARCHAR(50) NOT NULL,
    product_name VARCHAR(70) NOT NULL,
    product_scale VARCHAR(10) NOT NULL,
    product_description VARCHAR(50) NOT NULL,
    quantity_in_stock INT NOT NULL,
    buy_price DOUBLE NOT NULL,
    msrp DOUBLE NOT NULL,
    PRIMARY KEY (product_code)
);

CREATE TABLE order_details (
    order_number INT NOT NULL,
    product_code VARCHAR(15) NOT NULL,
    PRIMARY KEY (order_number , product_code)
);


CREATE TABLE productlines (
    prodductline_id VARCHAR(50) NOT NULL,
    text_description VARCHAR(50),
    image VARCHAR(50),
    PRIMARY KEY (prodductline_id)
);

CREATE TABLE employees (
    employee_number INT NOT NULL,
    report_to INT NOT NULL,
    office_code VARCHAR(10) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    PRIMARY KEY (employee_number)
);

CREATE TABLE offices (
    office_code VARCHAR(10) NOT NULL,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    address_line_1 VARCHAR(50) NOT NULL,
    address_line_2 VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    postal_code VARCHAR(15) NOT NULL,
    PRIMARY KEY (office_code)
);

ALTER TABLE orders 
ADD FOREIGN KEY (customer_number) 
REFERENCES customers (customer_number);

ALTER TABLE payments
ADD FOREIGN KEY (customer_number) 
REFERENCES customers (customer_number); 

ALTER TABLE order_details 
ADD FOREIGN KEY (order_number) 
REFERENCES orders (order_number),
ADD FOREIGN KEY (product_code) 
REFERENCES products (product_code);

ALTER TABLE products 
ADD FOREIGN KEY (prodductline_id) 
REFERENCES productlines (prodductline_id);

ALTER TABLE customers 
ADD FOREIGN KEY (sales_rep_employee_number) 
REFERENCES employees (employee_number);

ALTER TABLE employees 
ADD FOREIGN KEY (report_to) 
REFERENCES employees (employee_number);

ALTER TABLE employees 
ADD FOREIGN KEY (office_code) 
REFERENCES offices (office_code);