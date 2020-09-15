USE classicmodels;

-- INNER JOIN

SELECT 
    productCode, productName, buyprice, textDescription
FROM
    products
        INNER JOIN
    productlines ON products.productline = productlines.productline
WHERE
    buyprice > 56.76 AND buyprice < 95.59;

-- LEFT JOIN 

SELECT 
    customers.customerNumber,
    customers.customerName,
    orders.orderNumber,
    orders.status
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber;

-- SELF JOIN 

SELECT 
    CONCAT(m.lastname, ', ', m.firstname) AS 'Manager',
    CONCAT(e.lastname, ', ', e.firstname) AS 'Direct report'
FROM
    employees e
        INNER JOIN
    employees m ON m.employeeNumber = e.reportsto
ORDER BY manager;