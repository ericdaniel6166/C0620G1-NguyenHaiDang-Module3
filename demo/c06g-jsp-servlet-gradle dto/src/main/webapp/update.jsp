<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 10/01/2020
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p style="color: red">${message}</p>
    <form method="post">
        <input type="hidden" name="actionUser" value="update" />
        <p>Name: </p>
        <input type="text" name="nameStudent" value="${student.name}"/>
        <p>Date of birth: </p>
        <input type="date" name="dateOfBirth" value="${student.dateOfBirth}"/>
        <input type="submit" value="Edit" />
    </form>
</body>
</html>
