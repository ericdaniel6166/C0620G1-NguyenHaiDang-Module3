<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/24/2020
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post">
    <label>Rate: </label><br/>

<%--    lấy theo attribute name --%>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type="submit" id="submit" value="Converter"/>
</form>
</body>
</html>
