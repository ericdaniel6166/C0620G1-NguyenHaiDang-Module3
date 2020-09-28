<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/27/2020
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Product details</h1>
<p>
    <a href="/products">Back to product</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>${requestScope["product"].getId()}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <td>Description</td>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
    <tr>
        <td>Producer</td>
        <td>${requestScope["product"].getProducer()}</td>
    </tr>

</table>

</body>
</html>
