SELECT * FROM codegym_management.account_james;
SELECT * FROM codegym_management.class;
SELECT * FROM codegym_management.instructor;
SELECT * FROM codegym_management.instructor_teach_class;
SELECT * FROM codegym_management.student;
SELECT * FROM codegym_management.type_of_class;

INSERT INTO `codegym_management`.`type_of_class` (`id`, `name`) VALUES ('1', 'Fulltime');
INSERT INTO `codegym_management`.`type_of_class` (`id`, `name`) VALUES ('2', 'Parttime');

INSERT INTO `codegym_management`.`class` (`id`, `name`, `type_of_class_id`) VALUES ('1', 'C0420G1', '1');
INSERT INTO `codegym_management`.`class` (`id`, `name`, `type_of_class_id`) VALUES ('2', 'C0520G1', '1');
INSERT INTO `codegym_management`.`class` (`id`, `name`, `type_of_class_id`) VALUES ('3', 'C0620G1', '1');
INSERT INTO `codegym_management`.`class` (`id`, `name`, `type_of_class_id`) VALUES ('4', 'C0720G1', '1');
INSERT INTO `codegym_management`.`class` (`id`, `name`, `type_of_class_id`) VALUES ('5', 'C0420H1', '2');
INSERT INTO `codegym_management`.`class` (`id`, `name`, `type_of_class_id`) VALUES ('6', 'C0520H1', '2');


INSERT INTO `codegym_management`.`account_james` (`account`, `password`) VALUES ('1', 'abc123');
INSERT INTO `codegym_management`.`account_james` (`account`, `password`) VALUES ('2', '123456');
INSERT INTO `codegym_management`.`account_james` (`account`, `password`) VALUES ('3', '222222');
INSERT INTO `codegym_management`.`account_james` (`account`, `password`) VALUES ('4', '333333');
INSERT INTO `codegym_management`.`account_james` (`account`, `password`) VALUES ('5', '444444');
INSERT INTO `codegym_management`.`account_james` (`account`, `password`) VALUES ('6', '555666');

INSERT INTO `codegym_management`.`instructor` (`id`, `name`, `date_of_birth`) VALUES ('1', 'Tien', '1992-01-01');
INSERT INTO `codegym_management`.`instructor` (`id`, `name`, `date_of_birth`) VALUES ('2', 'Toan', '1990-01-01');
INSERT INTO `codegym_management`.`instructor` (`id`, `name`, `date_of_birth`) VALUES ('3', 'Tien', '1984-02-02');
INSERT INTO `codegym_management`.`instructor` (`id`, `name`, `date_of_birth`) VALUES ('4', 'Chuong', '1990-12-20');

INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`, `account_james`, `class_id`) VALUES ('1', 'Tien', '1990-01-03', '1', '1');
INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`, `account_james`, `class_id`) VALUES ('2', 'Huy', '1980-03-03', '2', '1');
INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`, `account_james`, `class_id`) VALUES ('3', 'Trung', '1997-04-04', '3', '2');
INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`, `account_james`, `class_id`) VALUES ('4', 'Quan', '1990-01-03', '4', '2');
INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`, `account_james`, `class_id`) VALUES ('5', 'Minh', '1980-03-03', '5', '3');
INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`, `account_james`, `class_id`) VALUES ('6', 'Hoang', '1997-04-04', '6', '5');
INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`) VALUES ('7', 'Lam', '1990-01-03');
INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`) VALUES ('8', 'Duc', '1997-04-04');

INSERT INTO `codegym_management`.`instructor_teach_class` (`instructor_id`, `class_id`) VALUES ('1', '1');
INSERT INTO `codegym_management`.`instructor_teach_class` (`instructor_id`, `class_id`) VALUES ('1', '2');
INSERT INTO `codegym_management`.`instructor_teach_class` (`instructor_id`, `class_id`) VALUES ('2', '3');
INSERT INTO `codegym_management`.`instructor_teach_class` (`instructor_id`, `class_id`) VALUES ('3', '5');

INSERT INTO `codegym_management`.`student` (`id`, `name`, `date_of_birth`) VALUES ('9', 'Toan', '1999-12-20');




