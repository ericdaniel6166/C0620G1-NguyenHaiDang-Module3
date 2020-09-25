<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/24/2020
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">
    Product Description: <%=request.getAttribute("productDescription")%>
</h2>
<h2 style="text-align: center">
    Discount Amount: <%=request.getAttribute("amount")%>
</h2>
</body>
</html>
