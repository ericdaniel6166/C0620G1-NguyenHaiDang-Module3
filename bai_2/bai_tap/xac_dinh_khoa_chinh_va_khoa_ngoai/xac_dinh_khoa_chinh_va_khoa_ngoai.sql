DROP DATABASE IF EXISTS my_database;

CREATE DATABASE my_database;

USE my_database;

CREATE TABLE customers (
    customer_number INT,
    full_name VARCHAR(45),
    address VARCHAR(45),
    email VARCHAR(45),
    phone INT,
    PRIMARY KEY (customer_number)
);

CREATE TABLE accounts (
    account_number INT,
    account_type VARCHAR(45),
    date_opened DATE,
    balance DOUBLE,
    customer_number INT,
    PRIMARY KEY (account_number)
);

CREATE TABLE transactions (
    transaction_number INT,
    account_number INT,
    transaction_date DATE,
    amounts DOUBLE,
    descriptions VARCHAR(45),
    PRIMARY KEY (transaction_number)
);

ALTER TABLE accounts
ADD FOREIGN KEY (customer_number) 
REFERENCES customers (customer_number);

ALTER TABLE transactions
ADD FOREIGN KEY (account_number)
REFERENCES accounts (account_number);








