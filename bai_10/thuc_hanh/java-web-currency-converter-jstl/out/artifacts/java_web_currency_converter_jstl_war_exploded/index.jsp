<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/25/2020
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<form action="converter.jsp" method="post">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>

</body>
</html>
