DROP DATABASE IF EXISTS my_database;

CREATE DATABASE my_database;

USE my_database;

create table students (
student_id int,
student_name varchar(50) not null,
age int not null,
department varchar(50) not null,
amount double not null
);

INSERT INTO `my_database`.`students` (`student_id`, `student_name`, `age`, `department`, `amount`) VALUES ('1', 'Hoang', '21', 'CNTT', '400000');
INSERT INTO `my_database`.`students` (`student_id`, `student_name`, `age`, `department`, `amount`) VALUES ('2', 'Viet', '19', 'DTVT', '320000');
INSERT INTO `my_database`.`students` (`student_id`, `student_name`, `age`, `department`, `amount`) VALUES ('3', 'Thanh', '18', 'KTDN', '400000');
INSERT INTO `my_database`.`students` (`student_id`, `student_name`, `age`, `department`, `amount`) VALUES ('4', 'Nhan', '19', 'CK', '450000');
INSERT INTO `my_database`.`students` (`student_id`, `student_name`, `age`, `department`, `amount`) VALUES ('5', 'Huong', '20', 'TCNH', '500000');
INSERT INTO `my_database`.`students` (`student_id`, `student_name`, `age`, `department`, `amount`) VALUES ('5', 'Huong', '20', 'TCNH', '200000');


-- - Viết câu lệnh hiện thị tất cả các dòng có tên là Huong

select * from students
where student_name = 'Huong';

-- - Viết câu lệnh lấy ra tổng số tiền của Huong

select student_id, student_name, age, sum(amount) from students
where student_name = 'Huong'
group by student_name;

-- - Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp

select student_id, student_name, age, sum(amount) from students
group by student_name;


