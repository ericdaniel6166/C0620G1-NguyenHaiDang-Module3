-- 12. JDBC & CRUD 
-- [Thực hành] Quản lý User sử dụng JSP-Servlet-JDBC-MySQLAssignment
-- [Bài tập] Cập nhật ứng dụng quản lý UserAssignment

drop database if exists demo;

CREATE DATABASE demo;
USE demo;

create table users (
 id  int NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

-- 13. JDBC Querying & Transaction [Thực hành] Gọi MySql Stored Procedures từ JDBCAssignment
-- Bước 1: Định nghĩa Stored Procedures get_user_by_id và insert_user trong MySql cho cơ sở dữ liệu demo:

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

--  13. JDBC Querying & Transaction [Thực hành] MySql JDBC Transaction 
create table permision(
id int primary key auto_increment,
name varchar(50)
);

create table user_permision(
permision_id int,
user_id int
);

insert into Permision(name) values('add');
insert into Permision(name) values('edit');
insert into Permision(name) values('delete');
insert into Permision(name) values('view');

DELIMITER $$
CREATE PROCEDURE select_all_users(

)
BEGIN
	select * from users;
    END$$
DELIMITER ;

call select_all_users();

-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user

DELIMITER $$
CREATE PROCEDURE delete_users(
in input_id int
)
BEGIN
	delete from users where id = input_id;
    END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE delete_users(
in input_id int,
in input_name varchar(100),
in input_email varchar(100),
in input_country varchar(100)
)
BEGIN
	update users set name = ?,email= ?, country =? where id = ?;
    END$$
DELIMITER ;
