<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/27/2020
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Customer details</h1>
<p>
    <a href="/customers">Back to customer</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>${requestScope["customer"].getId()}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${requestScope["customer"].getName()}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${requestScope["customer"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address</td>
        <td>${requestScope["customer"].getAddress()}</td>
    </tr>

</table>

</body>
</html>
