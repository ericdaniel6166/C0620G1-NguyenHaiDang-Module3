USE classicmodels;

-- join = inner join

SELECT 
    customers.customerNumber,
    customerName,
    phone,
    paymentDate,
    amount
FROM
    customers
        INNER JOIN
    payments ON customers.customerNumber = payments.customerNumber
WHERE
    city = 'Las Vegas';

SELECT 
    customers.customerNumber,
    customerName,
    phone,
    paymentDate,
    amount
FROM
    customers
        JOIN
    payments ON customers.customerNumber = payments.customerNumber
WHERE
    city = 'Las Vegas';

--  left join

SELECT 
    customers.customerNumber,
    customers.customerName,
    orders.orderNumber,
    orders.status
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber;

-- tìm phần bù
-- dùng left join kèm điều kiên IS NULL để tìm phần bù 

SELECT 
    customers.customerNumber,
    customers.customerName,
    orders.orderNumber,
    orders.status
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber
WHERE
    orderNumber IS NULL;