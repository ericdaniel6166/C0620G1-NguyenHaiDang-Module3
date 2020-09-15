DROP DATABASE IF EXISTS my_database;

CREATE DATABASE my_database;

USE my_database;

CREATE TABLE students (
    student_id VARCHAR(15) NOT NULL,
    student_name VARCHAR(50) NOT NULL,
    address_id INT NOT NULL,
    email VARCHAR(50) NOT NULL,
    image VARCHAR(50) NOT NULL,
    PRIMARY KEY (student_id)
);

CREATE TABLE addresses (
    address_id INT AUTO_INCREMENT,
    student_id VARCHAR(15) NOT NULL,
    address VARCHAR(500) NOT NULL,
    PRIMARY KEY (address_id)
);

CREATE TABLE books (
    book_id INT AUTO_INCREMENT,
    book_name VARCHAR(50) NOT NULL,
    category_id INT NOT NULL,
    publisher VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    published_year YEAR NOT NULL,
    book_edition INT NOT NULL,
    price DOUBLE NOT NULL,
    image VARCHAR(50) NOT NULL,
    PRIMARY KEY (book_id)
);

CREATE TABLE categories (
    category_id INT AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE borrow_orders (
    borrow_order_id INT AUTO_INCREMENT,
    book_id INT NOT NULL,
    student_id VARCHAR(15) NOT NULL,
    borrow_date DATE NOT NULL,
    return_date DATE NOT NULL,
    PRIMARY KEY (borrow_order_id)
);

ALTER TABLE borrow_orders 
ADD FOREIGN KEY (book_id) 
REFERENCES books (book_id);

ALTER TABLE borrow_orders 
ADD FOREIGN KEY (student_id) 
REFERENCES students (student_id);

ALTER TABLE addresses 
ADD FOREIGN KEY (student_id) 
REFERENCES students (student_id);

ALTER TABLE books
ADD FOREIGN KEY (category_id)
REFERENCES categories (category_id);