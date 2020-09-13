use classicmodels;

select * from customers;

select customername, phone, city, country from customers;

select * from customers
where customerName = 'Atelier graphique';

select customername, phone, city, country from customers
where customerName = 'Atelier graphique';

select * from customers
where customerName like '%A%';

select * from customers
where customerName like 'A%';

select * from customers
where customerName like '%e';

select * from customers
where customerName like '%e%';

select * from customers
where city in ('Nantes', 'Las Vegas', 'Warszawa', 'NYC');

select customername, phone, city, country from customers
where city in ('Nantes', 'Las Vegas', 'Warszawa', 'NYC');

select * from orders;

select orderNumber, orderDate, customerNumber from orders;

select * from orders;

select * from orders
where orderNumber between '10100' and '10110';

select * from orders
where orderDate < '2003-03-03';

select * from orders
where orderDate < '2004-03-03';

select * from orders
where orderDate < '2003-03-03' and status = 'Shipped';


