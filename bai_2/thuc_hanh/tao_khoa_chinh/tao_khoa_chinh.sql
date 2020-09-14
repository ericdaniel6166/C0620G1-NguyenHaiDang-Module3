DROP DATABASE IF EXISTS my_database;

CREATE DATABASE my_database;

USE my_database;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(40),
    password VARCHAR(255),
    email VARCHAR(255)
);

-- khuyên dùng: khoá chính để cuối 

CREATE TABLE roles(
   role_id INT AUTO_INCREMENT,
   role_name VARCHAR(50),
   PRIMARY KEY(role_id)
);

-- khoá phụ 

CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id),
   FOREIGN KEY(role_id) REFERENCES roles(role_id)
);

-- Tạo khoá chính khi thay đổi bảng
-- ALTER TABLE table_name
--     ADD PRIMARY KEY(primary_key_column);

-- bảng không có primary key 
    
CREATE TABLE employees(
   employee_id INT,
   username VARCHAR(40),
   password VARCHAR(255),
   email VARCHAR(255)
);

ALTER TABLE employees
	ADD PRIMARY KEY(employee_id);
    
ALTER TABLE employees
MODIFY COLUMN employee_id INT AUTO_INCREMENT;

-- bảng có primary key

DROP TABLE employees;

CREATE TABLE employees(
   employee_id INT,
   username VARCHAR(40),
   password VARCHAR(255),
   email VARCHAR(255),
   PRIMARY KEY(username)
);

ALTER TABLE employees
DROP PRIMARY KEY,
	ADD PRIMARY KEY(employee_id);

ALTER TABLE employees
	ADD PRIMARY KEY(employee_id);
    
ALTER TABLE employees
MODIFY COLUMN employee_id INT AUTO_INCREMENT;
