<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/28/2020
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Search product by name</h1>

<p>
    <a href="/products">
        <button>Back to product list</button>
    </a>
</p>

<form method="post">
    <fieldset>
        <legend>Search product by name</legend>
        <table>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Search product by name">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
