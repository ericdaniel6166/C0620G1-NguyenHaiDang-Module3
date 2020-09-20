select c.id, c.`name`, count(s.id) as num_std
from student s
	right join class c on s.class_id = c.id
group by s.class_id
having num_std = 0;

select *
from student s
	right join class c on s.class_id = c.id
where s.class_id is not null;


select `name`, avg(id)
from student
group by `name`;

select `name`, max(id)
from student;

SELECT ROUND(DATEDIFF(NOW(), "2017-06-15") / 365)
from student;

SELECT NOW(), curdate()
from student;

select year(now())
from student;

select id, name, date_of_birth
from student
union all
select id, name, date_of_birth
from instructor;

select id, name, date_of_birth
from student
union all
select  name, id, date_of_birth
from instructor;

select *
from student
order by date_of_birth desc
limit 3;

select *
from student
limit 2, 5;

-- sql server -> limit 3 ~ select top 3

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