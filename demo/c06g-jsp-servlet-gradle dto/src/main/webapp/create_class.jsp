<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 10/02/2020
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/listStudent">
        <input type="hidden" name="actionUser" value="createClass" />
        <input type="text" name="className" />
        <select name="typeOfClass">
            <c:forEach var="typeOfClass" items="${typeOfClasses}">
                <option value="${typeOfClass.id}">${typeOfClass.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Save" />
    </form>
</body>
</html>
