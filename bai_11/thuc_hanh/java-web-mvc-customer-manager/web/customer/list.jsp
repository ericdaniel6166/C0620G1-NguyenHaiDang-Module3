<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/27/2020
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Bước 8: Khởi chạy ứng dụng và đi đến đường dẫn --%>
<%--http://localhost:8080/customers để quan sát kết quả--%>

<h1>Customers</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td>
                <a href="/customers?action=view&id=${customer.getId()}">
                        ${customer.getName()}
                </a>
            </td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td>
                <a href="customers?action=edit&id=${customer.getId()}">
                    edit
                </a>
            </td>
            <td>
                <a href="customers?action=delete&id=${customer.getId()}">
                    delete
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
