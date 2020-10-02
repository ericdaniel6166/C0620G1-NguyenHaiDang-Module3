INSERT INTO `furama`.`employees` (`employee_name`) VALUES ('Hoa');
INSERT INTO `furama`.`employees` (`employee_name`) VALUES ('Hoa Hoa Hoa Hoa Hoa');
INSERT INTO `furama`.`employees` (`employee_name`) VALUES ('Kim');
INSERT INTO `furama`.`employees` (`employee_name`) VALUES ('Tuan');
INSERT INTO `furama`.`employees` (`employee_name`) VALUES ('Trung');
INSERT INTO `furama`.`employees` (`employee_name`) VALUES ('Quan');
INSERT INTO `furama`.`employees` (`employee_name`) VALUES ('Linh');

INSERT INTO `furama`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('An', '1990-01-01', 'Da Nang');
INSERT INTO `furama`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Tuan', '1990-01-01', 'Hue');
INSERT INTO `furama`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Minh', '1940-01-01', 'Da Nang');
INSERT INTO `furama`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Tu', '1990-01-01', 'HCM');
INSERT INTO `furama`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Chau', '2005-01-28', 'Quang Tri');
INSERT INTO `furama`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Giang', '1990-01-01', 'Quang Tri');
INSERT INTO `furama`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Binh', '1990-01-01', 'Ha Noi');

INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('7');

INSERT INTO `furama`.`types_of_customer` (`type_name`) VALUES ('Member');
INSERT INTO `furama`.`types_of_customer` (`type_name`) VALUES ('Silver');
INSERT INTO `furama`.`types_of_customer` (`type_name`) VALUES ('Gold');
INSERT INTO `furama`.`types_of_customer` (`type_name`) VALUES ('Platinium');
INSERT INTO `furama`.`types_of_customer` (`type_name`) VALUES ('Diamond');

UPDATE `furama`.`customers` SET `type_of_customer_id` = '1' WHERE (`customer_id` = '1');
UPDATE `furama`.`customers` SET `type_of_customer_id` = '2' WHERE (`customer_id` = '2');
UPDATE `furama`.`customers` SET `type_of_customer_id` = '3' WHERE (`customer_id` = '3');
UPDATE `furama`.`customers` SET `type_of_customer_id` = '4' WHERE (`customer_id` = '4');
UPDATE `furama`.`customers` SET `type_of_customer_id` = '5' WHERE (`customer_id` = '5');
UPDATE `furama`.`customers` SET `type_of_customer_id` = '1' WHERE (`customer_id` = '6');
UPDATE `furama`.`customers` SET `type_of_customer_id` = '2' WHERE (`customer_id` = '7');

INSERT INTO `furama`.`customers` (`type_of_customer_id`, `customer_name`, `date_of_birth`, `address`) VALUES ('3', 'Tra', '1990-01-01', 'Hai Phong');
INSERT INTO `furama`.`customers` (`type_of_customer_id`, `customer_name`, `date_of_birth`, `address`) VALUES ('4', 'Quan', '1990-01-01', 'Bac Giang');
INSERT INTO `furama`.`customers` (`type_of_customer_id`, `customer_name`, `date_of_birth`, `address`) VALUES ('5', 'Minh', '1990-01-01', 'Vinh Phuc');

INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('10');
INSERT INTO `furama`.`contracts` (`customer_id`) VALUES ('10');

INSERT INTO `furama`.`accompanied_services` (`accompanied_service_name`) VALUES ('massage');
INSERT INTO `furama`.`accompanied_services` (`accompanied_service_name`) VALUES ('karaoke');
INSERT INTO `furama`.`accompanied_services` (`accompanied_service_name`) VALUES ('food');
INSERT INTO `furama`.`accompanied_services` (`accompanied_service_name`) VALUES ('drink');
INSERT INTO `furama`.`accompanied_services` (`accompanied_service_name`) VALUES ('car rental');

UPDATE `furama`.`accompanied_services` SET `price` = '800000' WHERE (`accompanied_service_id` = '1');
UPDATE `furama`.`accompanied_services` SET `price` = '2000000' WHERE (`accompanied_service_id` = '5');
UPDATE `furama`.`accompanied_services` SET `price` = '1500000' WHERE (`accompanied_service_id` = '2');
UPDATE `furama`.`accompanied_services` SET `price` = '500000' WHERE (`accompanied_service_id` = '3');
UPDATE `furama`.`accompanied_services` SET `price` = '90000' WHERE (`accompanied_service_id` = '4');

INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('1', '1', '1');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('2', '2', '1');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('3', '3', '1');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('4', '4', '1');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('5', '5', '1');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('6', '5', '1');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('7', '1', '1');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('43', '3', '1');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('1', '2', '2');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('2', '1', '6');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('3', '5', '2');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('4', '3', '4');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('5', '2', '3');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('6', '1', '5');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('7', '3', '2');
INSERT INTO `furama`.`contract_details` (`contract_id`, `accompanied_service_id`, `quantity`) VALUES ('43', '2', '3');

INSERT INTO `furama`.`services` (`rent_price`) VALUES ('1000000');
INSERT INTO `furama`.`services` (`rent_price`) VALUES ('3000000');
INSERT INTO `furama`.`services` (`rent_price`) VALUES ('9000000');

UPDATE `furama`.`contracts` SET `service_id` = '1' WHERE (`contract_id` = '1');
UPDATE `furama`.`contracts` SET `service_id` = '2' WHERE (`contract_id` = '2');
UPDATE `furama`.`contracts` SET `service_id` = '3' WHERE (`contract_id` = '3');
UPDATE `furama`.`contracts` SET `service_id` = '2' WHERE (`contract_id` = '4');
UPDATE `furama`.`contracts` SET `service_id` = '3' WHERE (`contract_id` = '5');
UPDATE `furama`.`contracts` SET `service_id` = '1' WHERE (`contract_id` = '6');
UPDATE `furama`.`contracts` SET `service_id` = '1' WHERE (`contract_id` = '7');
UPDATE `furama`.`contracts` SET `service_id` = '2' WHERE (`contract_id` = '8');
UPDATE `furama`.`contracts` SET `service_id` = '3' WHERE (`contract_id` = '9');
UPDATE `furama`.`contracts` SET `service_id` = '3' WHERE (`contract_id` = '10');
UPDATE `furama`.`contracts` SET `service_id` = '2' WHERE (`contract_id` = '11');
UPDATE `furama`.`contracts` SET `service_id` = '2' WHERE (`contract_id` = '12');
UPDATE `furama`.`contracts` SET `service_id` = '3' WHERE (`contract_id` = '13');
UPDATE `furama`.`contracts` SET `service_id` = '1' WHERE (`contract_id` = '14');
UPDATE `furama`.`contracts` SET `service_id` = '1' WHERE (`contract_id` = '16');
UPDATE `furama`.`contracts` SET `service_id` = '2' WHERE (`contract_id` = '17');
UPDATE `furama`.`contracts` SET `service_id` = '3' WHERE (`contract_id` = '18');
UPDATE `furama`.`contracts` SET `service_id` = '3' WHERE (`contract_id` = '19');
UPDATE `furama`.`contracts` SET `service_id` = '2' WHERE (`contract_id` = '20');
UPDATE `furama`.`contracts` SET `service_id` = '1' WHERE (`contract_id` = '21');

INSERT INTO `furama`.`services` (`rent_price`) VALUES ('12000000');
INSERT INTO `furama`.`services` (`rent_price`) VALUES ('15000000');

UPDATE `furama`.`contracts` SET `service_id` = '4', `contract_creation_date` = '2018-01-20' WHERE (`contract_id` = '22');
UPDATE `furama`.`contracts` SET `service_id` = '4' WHERE (`contract_id` = '23');
UPDATE `furama`.`contracts` SET `service_id` = '4' WHERE (`contract_id` = '24');
UPDATE `furama`.`contracts` SET `service_id` = '5', `contract_creation_date` = '2020-09-20' WHERE (`contract_id` = '25');
UPDATE `furama`.`contracts` SET `service_id` = '5' WHERE (`contract_id` = '26');
UPDATE `furama`.`contracts` SET `contract_creation_date` = '2019-04-20' WHERE (`contract_id` = '20');

UPDATE `furama`.`contracts` SET `contract_creation_date` = '2018-01-01' WHERE (`contract_id` = '8');

UPDATE `furama`.`contracts` SET `contract_creation_date` = '2018-03-31' WHERE (`contract_id` = '26');

INSERT INTO `furama`.`customers` (`customer_name`) VALUES ('Minh');
INSERT INTO `furama`.`customers` (`customer_name`) VALUES ('Tu');
INSERT INTO `furama`.`customers` (`customer_name`) VALUES ('An');

UPDATE `furama`.`contracts` SET `contract_creation_date` = '2019-02-01', `amount` = '10000000' WHERE (`contract_id` = '1');
UPDATE `furama`.`contracts` SET `contract_creation_date` = '2019-03-20', `amount` = '15000000' WHERE (`contract_id` = '3');
UPDATE `furama`.`contracts` SET `contract_creation_date` = '2019-04-20', `amount` = '20000000' WHERE (`contract_id` = '5');
UPDATE `furama`.`contracts` SET `contract_creation_date` = '2019-05-20', `amount` = '30000000' WHERE (`contract_id` = '6');

UPDATE `furama`.`contracts` SET `contract_creation_date` = '2019-01-20', `amount` = '10500000' WHERE (`contract_id` = '10');
UPDATE `furama`.`contracts` SET `contract_creation_date` = '2019-02-20', `amount` = '11500000' WHERE (`contract_id` = '11');

UPDATE `furama`.`contracts` SET `amount` = '60000000' WHERE (`contract_id` = '20');

INSERT INTO `furama`.`employees` (`employee_name`, `address`) VALUES ('Van Hoa', 'Da Nang');
INSERT INTO `furama`.`employees` (`employee_name`, `address`) VALUES ('Minh Tuan', 'Quang Tri');
INSERT INTO `furama`.`employees` (`employee_name`, `address`) VALUES ('Tran Hoa Kha', 'Da Nang');
INSERT INTO `furama`.`employees` (`employee_name`, `address`) VALUES ('Tran Kha', 'Ha Noi');
INSERT INTO `furama`.`employees` (`employee_name`, `address`) VALUES ('Nguyen Nguyen Nguyen Nguyen Kha', 'Da Nang');

UPDATE `furama`.`customers` SET `type_of_customer_id` = '5', `address` = 'Vinh' WHERE (`customer_id` = '11');
UPDATE `furama`.`customers` SET `type_of_customer_id` = '5', `address` = 'Quang Ngai' WHERE (`customer_id` = '12');
UPDATE `furama`.`customers` SET `type_of_customer_id` = '5', `address` = 'Vinh' WHERE (`customer_id` = '13');
INSERT INTO `furama`.`customers` (`type_of_customer_id`, `customer_name`, `address`) VALUES ('4', 'Toan', 'Quang Ngai');
INSERT INTO `furama`.`customers` (`type_of_customer_id`, `customer_name`, `address`) VALUES ('3', 'Dinh', 'Vinh');

UPDATE `furama`.`contracts` SET `employee_id` = '1' WHERE (`contract_id` = '1');
UPDATE `furama`.`contracts` SET `employee_id` = '2' WHERE (`contract_id` = '2');
UPDATE `furama`.`contracts` SET `employee_id` = '3' WHERE (`contract_id` = '3');
UPDATE `furama`.`contracts` SET `employee_id` = '4' WHERE (`contract_id` = '4');
UPDATE `furama`.`contracts` SET `employee_id` = '5' WHERE (`contract_id` = '5');
UPDATE `furama`.`contracts` SET `employee_id` = '6' WHERE (`contract_id` = '6');
UPDATE `furama`.`contracts` SET `employee_id` = '7' WHERE (`contract_id` = '7');
UPDATE `furama`.`contracts` SET `employee_id` = '8' WHERE (`contract_id` = '8');
UPDATE `furama`.`contracts` SET `employee_id` = '9' WHERE (`contract_id` = '9');
UPDATE `furama`.`contracts` SET `employee_id` = '10' WHERE (`contract_id` = '10');
UPDATE `furama`.`contracts` SET `employee_id` = '11' WHERE (`contract_id` = '11');
UPDATE `furama`.`contracts` SET `employee_id` = '12' WHERE (`contract_id` = '12');
UPDATE `furama`.`contracts` SET `employee_id` = '1' WHERE (`contract_id` = '13');
UPDATE `furama`.`contracts` SET `employee_id` = '2' WHERE (`contract_id` = '14');
UPDATE `furama`.`contracts` SET `employee_id` = '3' WHERE (`contract_id` = '15');
UPDATE `furama`.`contracts` SET `employee_id` = '4' WHERE (`contract_id` = '16');
UPDATE `furama`.`contracts` SET `employee_id` = '5' WHERE (`contract_id` = '17');
UPDATE `furama`.`contracts` SET `employee_id` = '6' WHERE (`contract_id` = '18');
UPDATE `furama`.`contracts` SET `employee_id` = '7' WHERE (`contract_id` = '19');
UPDATE `furama`.`contracts` SET `employee_id` = '8' WHERE (`contract_id` = '20');
UPDATE `furama`.`contracts` SET `employee_id` = '9' WHERE (`contract_id` = '21');
UPDATE `furama`.`contracts` SET `employee_id` = '10' WHERE (`contract_id` = '22');
UPDATE `furama`.`contracts` SET `employee_id` = '11' WHERE (`contract_id` = '23');
UPDATE `furama`.`contracts` SET `employee_id` = '12' WHERE (`contract_id` = '24');
UPDATE `furama`.`contracts` SET `employee_id` = '1' WHERE (`contract_id` = '25');
UPDATE `furama`.`contracts` SET `employee_id` = '2' WHERE (`contract_id` = '26');
UPDATE `furama`.`contracts` SET `employee_id` = '3', `service_id` = '1', `contract_creation_date` = '2019-10-01' WHERE (`contract_id` = '27');
UPDATE `furama`.`contracts` SET `employee_id` = '4', `service_id` = '3', `contract_creation_date` = '2019-12-31' WHERE (`contract_id` = '28');
UPDATE `furama`.`contracts` SET `employee_id` = '5', `service_id` = '1', `contract_creation_date` = '2019-11-20' WHERE (`contract_id` = '29');
UPDATE `furama`.`contracts` SET `employee_id` = '6', `service_id` = '1' WHERE (`contract_id` = '30');
UPDATE `furama`.`contracts` SET `employee_id` = '7', `service_id` = '3' WHERE (`contract_id` = '31');
UPDATE `furama`.`contracts` SET `employee_id` = '8', `service_id` = '3' WHERE (`contract_id` = '32');
UPDATE `furama`.`contracts` SET `employee_id` = '9', `service_id` = '3' WHERE (`contract_id` = '33');
UPDATE `furama`.`contracts` SET `employee_id` = '10', `service_id` = '3' WHERE (`contract_id` = '34');
UPDATE `furama`.`contracts` SET `employee_id` = '11' WHERE (`contract_id` = '35');
UPDATE `furama`.`contracts` SET `employee_id` = '12' WHERE (`contract_id` = '36');
UPDATE `furama`.`contracts` SET `employee_id` = '1' WHERE (`contract_id` = '37');
UPDATE `furama`.`contracts` SET `employee_id` = '2' WHERE (`contract_id` = '38');
UPDATE `furama`.`contracts` SET `employee_id` = '3' WHERE (`contract_id` = '39');
UPDATE `furama`.`contracts` SET `employee_id` = '4' WHERE (`contract_id` = '40');
UPDATE `furama`.`contracts` SET `employee_id` = '5' WHERE (`contract_id` = '41');
UPDATE `furama`.`contracts` SET `employee_id` = '6' WHERE (`contract_id` = '42');
UPDATE `furama`.`contracts` SET `employee_id` = '7' WHERE (`contract_id` = '43');
UPDATE `furama`.`contracts` SET `employee_id` = '8' WHERE (`contract_id` = '44');

UPDATE `furama`.`services` SET `service_name` = 'SVRO-1111' WHERE (`service_id` = '1');
UPDATE `furama`.`services` SET `service_name` = 'SVRO-1234' WHERE (`service_id` = '2');
UPDATE `furama`.`services` SET `service_name` = 'SVHO-2222' WHERE (`service_id` = '3');
UPDATE `furama`.`services` SET `service_name` = 'SVHO-3456' WHERE (`service_id` = '4');
UPDATE `furama`.`services` SET `service_name` = 'SVVL-9999' WHERE (`service_id` = '5');

INSERT INTO `furama`.`services` (`service_name`) VALUES ('SVRO-3568');
INSERT INTO `furama`.`services` (`service_name`) VALUES ('SVRO-4567');
INSERT INTO `furama`.`services` (`service_name`) VALUES ('SVRO-9865');
INSERT INTO `furama`.`services` (`service_name`) VALUES ('SVHO-7654');
INSERT INTO `furama`.`services` (`service_name`) VALUES ('SVHO-6543');
INSERT INTO `furama`.`services` (`service_name`) VALUES ('SVVL-6543');
INSERT INTO `furama`.`services` (`service_name`) VALUES ('SVVL-7632');

UPDATE `furama`.`contracts` SET `amount` = '20000000' WHERE (`contract_id` = '22');
UPDATE `furama`.`contracts` SET `amount` = '30000000' WHERE (`contract_id` = '8');
UPDATE `furama`.`contracts` SET `amount` = '15000000' WHERE (`contract_id` = '25');
UPDATE `furama`.`contracts` SET `amount` = '17500000' WHERE (`contract_id` = '26');
UPDATE `furama`.`contracts` SET `amount` = '18000000' WHERE (`contract_id` = '27');
UPDATE `furama`.`contracts` SET `amount` = '21000000' WHERE (`contract_id` = '28');
UPDATE `furama`.`contracts` SET `amount` = '22500000' WHERE (`contract_id` = '29');
UPDATE `furama`.`contracts` SET `service_id` = '6', `contract_creation_date` = '2019-10-01', `amount` = '25000000' WHERE (`contract_id` = '35');
UPDATE `furama`.`contracts` SET `service_id` = '7', `contract_creation_date` = '2019-01-01', `amount` = '35000000' WHERE (`contract_id` = '36');
UPDATE `furama`.`contracts` SET `service_id` = '8' WHERE (`contract_id` = '37');
UPDATE `furama`.`contracts` SET `service_id` = '9' WHERE (`contract_id` = '38');
UPDATE `furama`.`contracts` SET `service_id` = '10' WHERE (`contract_id` = '39');
UPDATE `furama`.`contracts` SET `service_id` = '11' WHERE (`contract_id` = '40');
UPDATE `furama`.`contracts` SET `service_id` = '12' WHERE (`contract_id` = '41');
UPDATE `furama`.`contracts` SET `service_id` = '6', `contract_creation_date` = '2019-01-01', `amount` = '15000000' WHERE (`contract_id` = '42');
UPDATE `furama`.`contracts` SET `service_id` = '7', `contract_creation_date` = '2019-02-01', `amount` = '17500000' WHERE (`contract_id` = '43');
UPDATE `furama`.`contracts` SET `service_id` = '8' WHERE (`contract_id` = '44');

UPDATE `furama`.`contracts` SET `contract_creation_date` = '2019-10-13', `amount` = '23500000' WHERE (`contract_id` = '44');

INSERT INTO `furama`.`types_of_service` (`type_of_service_name`) VALUES ('room');
INSERT INTO `furama`.`types_of_service` (`type_of_service_name`) VALUES ('house');
INSERT INTO `furama`.`types_of_service` (`type_of_service_name`) VALUES ('villa');

UPDATE `furama`.`services` SET `type_of_service_id` = '1' WHERE (`service_id` = '1');
UPDATE `furama`.`services` SET `type_of_service_id` = '1' WHERE (`service_id` = '2');
UPDATE `furama`.`services` SET `type_of_service_id` = '2' WHERE (`service_id` = '3');
UPDATE `furama`.`services` SET `type_of_service_id` = '2' WHERE (`service_id` = '4');
UPDATE `furama`.`services` SET `type_of_service_id` = '3' WHERE (`service_id` = '5');
UPDATE `furama`.`services` SET `type_of_service_id` = '1' WHERE (`service_id` = '6');
UPDATE `furama`.`services` SET `type_of_service_id` = '1' WHERE (`service_id` = '7');
UPDATE `furama`.`services` SET `type_of_service_id` = '1' WHERE (`service_id` = '8');
UPDATE `furama`.`services` SET `type_of_service_id` = '2' WHERE (`service_id` = '9');
UPDATE `furama`.`services` SET `type_of_service_id` = '2' WHERE (`service_id` = '10');
UPDATE `furama`.`services` SET `type_of_service_id` = '3' WHERE (`service_id` = '11');
UPDATE `furama`.`services` SET `type_of_service_id` = '3' WHERE (`service_id` = '12');

UPDATE `furama`.`contracts` SET `contract_creation_date` = '2018-01-01' WHERE (`contract_id` = '38');
UPDATE `furama`.`contracts` SET `contract_creation_date` = '2018-01-20' WHERE (`contract_id` = '33');




-- SELECT * FROM furama.employees;
-- SELECT * FROM furama.customers;
-- SELECT * FROM furama.types_of_customer;
-- SELECT * FROM furama.contracts;
-- SELECT * FROM furama.contract_details;
-- SELECT * FROM furama.accompanied_services;
-- SELECT * FROM furama.services;
-- SELECT * FROM furama.types_of_service;


INSERT INTO `furama`.`employees` (`employee_id`, `employee_name`) VALUES ('13', 'Tran Minh Tri');
INSERT INTO `furama`.`employees` (`employee_id`, `employee_name`) VALUES ('14', 'Tuan Van');


INSERT INTO `furama`.`contracts` (`employee_id`, `customer_id`, `service_id`, `contract_creation_date`, `amount`) VALUES ('13', '5', '7', '2016-01-20', '20000000');
INSERT INTO `furama`.`contracts` (`employee_id`, `customer_id`, `service_id`, `contract_creation_date`, `amount`) VALUES ('14', '7', '8', '2020-01-20', '25000000');

INSERT INTO `furama`.`customers` (`customer_id`, `customer_name`) VALUES ('16', 'Toan');

INSERT INTO `furama`.`contracts` (`customer_id`, `contract_creation_date`, `amount`) VALUES ('16', '2015-01-01', '12500000');

INSERT INTO `furama`.`employees` (`employee_id`, `employee_name`) VALUES ('15', 'Minh Tuan');

INSERT INTO `furama`.`customers` (`customer_id`, `type_of_customer_id`, `customer_name`) VALUES ('17', '2', 'Minh Tuan');

INSERT INTO `furama`.`levels` (`level_id`, `level_name`) VALUES ('1', ' Intermediate');
INSERT INTO `furama`.`levels` (`level_id`, `level_name`) VALUES ('2', 'College');
INSERT INTO `furama`.`levels` (`level_id`, `level_name`) VALUES ('3', 'Undergraduate ');
INSERT INTO `furama`.`levels` (`level_id`, `level_name`) VALUES ('4', 'Post graduate');

INSERT INTO `furama`.`positions` (`position_name`) VALUES ('Receptionist');
INSERT INTO `furama`.`positions` (`position_name`) VALUES ('Waiter');
INSERT INTO `furama`.`positions` (`position_name`) VALUES ('Consultant');
INSERT INTO `furama`.`positions` (`position_name`) VALUES ('Supervisor');
INSERT INTO `furama`.`positions` (`position_name`) VALUES ('Manager');
INSERT INTO `furama`.`positions` (`position_name`) VALUES ('Director');




