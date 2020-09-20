-- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào
select *
from student
	inner join class on student.class_id = class.id;
    
select *
from student s
	inner join class c on s.class_id = c.id;
    -- alias

-- 2. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào, lớp đó thuộc loại lớp nào
select s.id, s.name 'name_student', c.name 'class_name', t.name 'type_class'
from student s
	inner join class c on s.class_id = c.id
    inner join type_of_class t on t.id = c.type_of_class_id;
    
select *
from student s
	inner join class c on s.class_id = c.id
    inner join type_of_class t on t.id = c.type_of_class_id;

-- 3. Lấy ra thông tin các học viên kể cả các học viên không theo học lớp nào
select *
from student s
	left join student c on s.class_id = c.id;

select *
from student s
	right join class c on s.class_id = c.id;

select *
from student s
	left join class c on s.class_id = c.id
where s.class_id is null;

select *
from student
	full join class;
    
-- 4. Lấy thông tin của các học viên tên 'Tien' và 'Toan'    
select *
from student
where `name` = 'Tien' OR `name` = 'Toan';

-- 5. Lấy ra số lượng học viên của từng lớp.

select c.id, c.name, count(class_id)
from student s
	right join class c on s.class_id = c.id
group by c.id;

select c.id, c.name, count(class_id)
from class c
	left join student s on s.class_id = c.id
group by c.id;

-- 6. Lấy ra danh sách học viên và sắp xếp tên theo alphabet.
select *
from student
order by `name`, date_of_birth desc;
