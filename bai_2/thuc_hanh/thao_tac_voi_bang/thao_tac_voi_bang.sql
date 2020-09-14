DROP DATABASE IF EXISTS my_database;

CREATE DATABASE my_database;

USE my_database;

-- thêm bảng 

CREATE TABLE contacts (
    contact_id INT NOT NULL AUTO_INCREMENT,
    last_name VARCHAR(30) NOT NULL,
    first_name VARCHAR(25),
    birthday DATE,
    CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

-- CREATE TABLE if not exists contacts
-- ( contact_id INT NOT NULL AUTO_INCREMENT,
--   last_name VARCHAR(30) NOT NULL,
--   first_name VARCHAR(25),
--   birthday DATE,
--   CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
-- );

DROP TABLE IF EXISTS suppliers;

CREATE TABLE suppliers (
    supplier_id INT NOT NULL AUTO_INCREMENT,
    supplier_name VARCHAR(50) NOT NULL,
    account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
    CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

-- xoá bảng

DROP TABLE contacts, suppliers;

-- DROP TABLE contacts;

-- thêm cột 

ALTER TABLE contacts
  ADD after_contacts_id VARCHAR(40) NOT NULL
    AFTER contact_id,
  ADD after_last_name VARCHAR(35) NULL
    AFTER last_name;
    
-- ALTER TABLE contacts
--   ADD after_contacts_id varchar(40) NOT NULL
--     AFTER contact_id;

-- sửa cột 

ALTER TABLE contacts
  ADD modify_contacts VARCHAR(40) NOT NULL;

ALTER TABLE contacts
  MODIFY modify_contacts VARCHAR(50) NULL;
  
-- đổi tên cột 

ALTER TABLE contacts
  ADD change_column_contacts VARCHAR(40) NOT NULL;
  
ALTER TABLE contacts
  CHANGE COLUMN change_column_contacts da_doi_ten
    VARCHAR(20) NOT NULL;
    
-- xoá cột
 
ALTER TABLE contacts
ADD delete_column_contacts VARCHAR(40) NOT NULL;

ALTER TABLE contacts
DROP COLUMN delete_column_contacts;

-- đổi tên bảng
ALTER TABLE contacts
RENAME TO people;

ALTER TABLE people
RENAME TO contacts;

