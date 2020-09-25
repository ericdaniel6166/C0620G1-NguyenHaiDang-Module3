<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 09/24/2020
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String numOne = request.getParameter("num1");
        String numTwo = request.getParameter("num2");
        int result = Integer.parseInt(numOne) + Integer.parseInt(numTwo);
    %>

    <h2 style="color: green">JSP <%=result%></h2>
</body>
</html>
