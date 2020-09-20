drop database if exists codegym_management;

create database codegym_management;

use codegym_management;

CREATE TABLE type_of_class (
    id INT PRIMARY KEY,
    `name` VARCHAR(50)
);

CREATE TABLE account_james (
    `account` VARCHAR(50),
    `password` VARCHAR(20),
    PRIMARY KEY (`account`)
);

CREATE TABLE instructor (
    id INT PRIMARY KEY,
    `name` VARCHAR(50),
    date_of_birth DATE
);

CREATE TABLE class (
    id INT,
    `name` CHAR(7),
    type_of_class_id INT,
    CONSTRAINT pk_class PRIMARY KEY (id),
    CONSTRAINT fk_class_type_of_class FOREIGN KEY (type_of_class_id)
        REFERENCES type_of_class (id)
);

CREATE TABLE student (
    id INT PRIMARY KEY,
    `name` VARCHAR(50),
    date_of_birth DATE,
    account_james VARCHAR(50),
    class_id INT,
    FOREIGN KEY (account_james)
        REFERENCES account_james (`account`),
    FOREIGN KEY (class_id)
        REFERENCES class (id)
);
/* 1: Full time, 2: Half time */

CREATE TABLE instructor_teach_class (
    instructor_id INT,
    class_id INT,
    PRIMARY KEY (instructor_id , class_id),
    FOREIGN KEY (instructor_id)
        REFERENCES instructor (id),
    FOREIGN KEY (class_id)
        REFERENCES class (id)
);