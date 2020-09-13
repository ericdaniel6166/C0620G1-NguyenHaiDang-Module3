create database codegym_management;
-- snake_case
-- ctrl + / = comment

use codegym_management;

create table student (
	id int primary key,
    `name` varchar(50),
    date_of_birth date
);

alter table student
modify id int auto_increment;

insert into student (`name`, date_of_birth)
values
('Tien2', '2020-09-11'),
('Hung1', '2007-07-07'),
('Hung2', '2007-07-07'),
('Hung3', '2007-07-07');

insert into student (`name`, date_of_birth)
values ('Hung4', '2007-07-07');

delete from student
where id = 3;

update student
set `name` = 'Thanh Tien', date_of_birth = '2020-09-12'
where id = 1;

select `name` -- print
from student -- for
where id = 3; -- if

select `name` -- print
from student -- for
where id = 2; -- if

drop table student;

drop database codegym_management;

-- drop database furama;