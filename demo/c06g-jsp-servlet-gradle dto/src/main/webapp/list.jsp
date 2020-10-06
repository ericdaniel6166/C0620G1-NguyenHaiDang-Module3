<%--<%@ page import="model.Student" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
    ${msgTransaction}<br>
    <a href="/listStudent?actionUser=transaction">Create student (transaction)</a>
    <a href="/listStudent?actionUser=create">Create student</a>

    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Ranking</th>
            <th>Gender</th>
            <th>Action</th>
        </tr>
<%--    <%--%>
<%--        List<Student> studentList = (ArrayList<Student>) request.getAttribute("abcList");--%>

<%--        for (Student student : studentList) {--%>
<%--    %>--%>
<%--        <tr>--%>
<%--            <td><%=student.getId()%></td>--%>
<%--            <td><%=student.getName()%></td>--%>
<%--            <td><%=student.getDateOfBirth()%></td>--%>
<%--        </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
        <c:forEach var="student" items="${abcList}">
            <tr>
                <td>${student.id}</td>
                <td><c:out value="${student.name}"></c:out></td>
                <td>${student.dateOfBirth}</td>
                <td>
                    <c:choose>
                        <c:when test="${student.mark > 5}">
                            Good
                        </c:when>
                        <c:when test="${student.mark == 5}">
                            Normal
                        </c:when>
                        <c:otherwise>
                            Bad
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${student.gender == 0}">
                        Female
                    </c:if>
                    <c:if test="${student.gender == 1}">
                        Male
                    </c:if>
                </td>
                <td>
                    <a href="/listStudent?actionUser=update&id=${student.id}">Update</a>
                    <a href="#" onclick="setStudentId('${student.id}')" data-toggle="modal" data-target="#deleteModal">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <form action="/listStudent" method="get" id="formDelete">
        <input type="hidden" name="actionUser" value="delete" />
        <input type="hidden" id="idStudentHidden" name="idStudentHidden" />
    </form>
    <!-- Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="submitFormDelete()">Save changes</button>
                </div>
            </div>
        </div>
    </div>
<%--    ${testVariable}--%>
<%--    <c:out value="${testVariable}" />--%>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        function setStudentId(id) {
            document.getElementById("idStudentHidden").value = id;
        }

        function submitFormDelete() {
            let formDelete = document.getElementById("formDelete");
            formDelete.submit();
        }
    </script>
</body>
</html>
