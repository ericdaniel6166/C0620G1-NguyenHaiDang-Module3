INSERT INTO `furuma`.`employees` (`employee_name`) VALUES ('Hoa');
INSERT INTO `furuma`.`employees` (`employee_name`) VALUES ('Hoa Hoa Hoa Hoa Hoa');
INSERT INTO `furuma`.`employees` (`employee_name`) VALUES ('Kim');
INSERT INTO `furuma`.`employees` (`employee_name`) VALUES ('Tuan');
INSERT INTO `furuma`.`employees` (`employee_name`) VALUES ('Trung');
INSERT INTO `furuma`.`employees` (`employee_name`) VALUES ('Quan');
INSERT INTO `furuma`.`employees` (`employee_name`) VALUES ('Linh');

INSERT INTO `furuma`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('An', '1990-01-01', 'Da Nang');
INSERT INTO `furuma`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Tuan', '1990-01-01', 'Hue');
INSERT INTO `furuma`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Minh', '1940-01-01', 'Da Nang');
INSERT INTO `furuma`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Tu', '1990-01-01', 'HCM');
INSERT INTO `furuma`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Chau', '2005-01-28', 'Quang Tri');
INSERT INTO `furuma`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Giang', '1990-01-01', 'Quang Tri');
INSERT INTO `furuma`.`customers` (`customer_name`, `date_of_birth`, `address`) VALUES ('Binh', '1990-01-01', 'Ha Noi');

INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('7');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('1');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('2');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('3');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('4');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('5');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('6');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('7');

INSERT INTO `furuma`.`types_of_customer` (`type_name`) VALUES ('Member');
INSERT INTO `furuma`.`types_of_customer` (`type_name`) VALUES ('Silver');
INSERT INTO `furuma`.`types_of_customer` (`type_name`) VALUES ('Gold');
INSERT INTO `furuma`.`types_of_customer` (`type_name`) VALUES ('Platinium');
INSERT INTO `furuma`.`types_of_customer` (`type_name`) VALUES ('Diamond');

UPDATE `furuma`.`customers` SET `type_of_customer_id` = '1' WHERE (`customer_id` = '1');
UPDATE `furuma`.`customers` SET `type_of_customer_id` = '2' WHERE (`customer_id` = '2');
UPDATE `furuma`.`customers` SET `type_of_customer_id` = '3' WHERE (`customer_id` = '3');
UPDATE `furuma`.`customers` SET `type_of_customer_id` = '4' WHERE (`customer_id` = '4');
UPDATE `furuma`.`customers` SET `type_of_customer_id` = '5' WHERE (`customer_id` = '5');
UPDATE `furuma`.`customers` SET `type_of_customer_id` = '1' WHERE (`customer_id` = '6');
UPDATE `furuma`.`customers` SET `type_of_customer_id` = '2' WHERE (`customer_id` = '7');

INSERT INTO `furuma`.`customers` (`type_of_customer_id`, `customer_name`, `date_of_birth`, `address`) VALUES ('3', 'Tra', '1990-01-01', 'Hai Phong');
INSERT INTO `furuma`.`customers` (`type_of_customer_id`, `customer_name`, `date_of_birth`, `address`) VALUES ('4', 'Quan', '1990-01-01', 'Bac Giang');
INSERT INTO `furuma`.`customers` (`type_of_customer_id`, `customer_name`, `date_of_birth`, `address`) VALUES ('5', 'Minh', '1990-01-01', 'Vinh Phuc');

INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('10');
INSERT INTO `furuma`.`contracts` (`customer_id`) VALUES ('10');

SELECT * FROM furuma.customers;
SELECT * FROM furuma.types_of_customer;
SELECT * FROM furuma.contracts;
-- Diamond, Platinium, Gold, Silver, Member