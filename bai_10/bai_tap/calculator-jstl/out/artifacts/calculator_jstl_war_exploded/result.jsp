<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/25/2020
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result:</h1>

<c:if test="${checkException == false}">
    <p><c:out value="${result}"></c:out></p>
</c:if>
<c:if test="${checkException == true}">
    <p><c:out value="${ex}"></c:out></p>
</c:if>

</body>
</html>
