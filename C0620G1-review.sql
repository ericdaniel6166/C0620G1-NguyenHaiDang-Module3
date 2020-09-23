-- ~~~~~~~~~~~~~~~~~~~~~~ EXIST, IN
select *
from class
where id not in (
	select class_id
    from student
    where class_id is not null
);

select *
from class c
where not exists (
	select *
    from student s
    where c.id = s.class_id
);

-- ~~~~~~~~~~~~~~~~~~~~~~ Step ERD -> Tables

-- ~~~~~~~~~~~~~~~~~~~~~~ Step JOIN
-- INNER JOIN: lấy ra thông tin học viên và tên lớp mà học viên đang học
-- LEFT JOIN/RIGHT JOIN: lấy ra thông tin học viên và tên lớp, kể cả học viên đang không theo học lớp nào
-- FULL JOIN

-- ~~~~~~~~~~~~~~~~~~~~~~ FUNCTION
delimiter //
create function sum2num (num1 int, num2 int)
returns int
deterministic
begin
	declare total int;
    set total = num1 + num2;
	return total;
end; //
delimiter ;

select sum2num(2, 3)
from student;

-- ~~~~~~~~~~~~~~~~~~~~~~ TRIGGER
delimiter //
create trigger save_account_james
before insert
-- update, delete
on student for each row
begin
	insert into account_james
    values (concat(lcase(new.name), '.codegym'), '12345678');
    
    update student
    set account_james = concat(lcase(new.name), '.codegym')
    where id = new.id;
end; //
delimiter ;