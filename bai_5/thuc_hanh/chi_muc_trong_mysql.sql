use classicmodels;

ALTER TABLE customers DROP INDEX idx_customerName;

EXPLAIN SELECT * FROM customers WHERE customerName = 'Atelier graphique';

-- rows = 122; 

ALTER TABLE customers ADD INDEX idx_customerName(customerName);

EXPLAIN SELECT * FROM customers WHERE customerName = 'Atelier graphique';

-- rows = 1; 