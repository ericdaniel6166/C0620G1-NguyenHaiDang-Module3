<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/27/2020
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Products</h1>
<p>
    <a href="/products">
        <button>Back to product list</button>
    </a>
    <a href="/products?action=create">
        <button>Create new product</button>
    </a>
    <a href="/products?action=search-by-name">
        <button>Search product by name</button>
    </a>
</p>


<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>
                <a href="/products?action=view&id=${product.getId()}">
                        ${product.getName()}
                </a>
            </td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td>
                <a href="products?action=edit&id=${product.getId()}">
                    edit
                </a>
            </td>
            <td>
                <a href="products?action=delete&id=${product.getId()}">
                    delete
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
