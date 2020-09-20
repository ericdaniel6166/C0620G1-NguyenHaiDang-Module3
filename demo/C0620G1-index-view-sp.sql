-- ~~~~~~~~~~~~~~~~~~~~~~ INDEX
select *
from student
where id = 3;

select *
from student
where `name` = 'Toan';

-- unique
create index idx_student_name
on student (`name`);


-- ~~~~~~~~~~~~~~~~~~~~~~ VIEW

create view view_student
as
select id, `name`, date_of_birth
from student;

select *
from view_student;

insert into view_student
values (10, 'Hung', '2020-09-17');

-- ~~~~~~~~~~~~~~~~~~~~~~ SP
-- ~~~~~~~~~~~~~~~~~~~~~~ IN
delimiter //
create procedure find_by_name_student (keyword varchar(50))
begin
	select *
    from student
    where `name` like concat('%', keyword, '%');
end; //
delimiter ;

call find_by_name_student('o');

-- ~~~~~~~~~~~~~~~~~~~~~~ OUT
delimiter //
create procedure find_by_name_student_out (keyword varchar(50), out result int)
begin
	set result = (
		select count(*)
		from student
		where `name` like concat('%', keyword, '%')
	);
    
    select result;
end; //
delimiter ;

call find_by_name_student_out('o', @abc);

select @abc;

-- ~~~~~~~~~~~~~~~~~~~~~~ INOUT
delimiter //
create procedure find_by_name_student_inout (inout keyword_and_result varchar(50))
begin
	set keyword_and_result = (
		select count(*)
		from student
		where `name` like concat('%', keyword_and_result, '%')
	);
    
end; //
delimiter ;

set @bcd = 'o';
call find_by_name_student_inout(@bcd);
select @bcd;
