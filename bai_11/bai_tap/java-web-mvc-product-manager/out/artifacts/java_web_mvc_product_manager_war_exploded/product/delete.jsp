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
<%--Bước 11: Phát triển tính năng xoá một khách hàng--%>

<h1>Delete product</h1>
<p>
    <c:if test="${requestScope['message']!=null}">
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">
        <button>Back to product list</button>
    </a>
</p>
<form method="post">
    <h3>Are you sure</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>

            <tr>
                <td>Description: </td>
                <td>${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${requestScope["product"].getProducer()}</td>
            </tr>
            <tr>
                <td>
                    <a href="/products">
                        <button>Back to product list</button>
                    </a>
                </td>
                <td><input type="submit" value="Delete product"></td>
            </tr>
        </table>
    </fieldset>
</form>


</body>
</html>
