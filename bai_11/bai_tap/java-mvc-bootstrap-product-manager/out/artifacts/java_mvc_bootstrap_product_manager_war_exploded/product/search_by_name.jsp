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
    <%--    jquery-3.5.1--%>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <%--    bootstrap/4.5.2--%>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <%--    Custom--%>
    <link rel="stylesheet" href="../css/css.css">
    <script src="../js/js.js"></script>

    <style>
        form{
            max-width: 450px;
            margin: 0 auto;
        }
    </style>

</head>
<body>

<div class="container-fluid">
    <header class="row">
        <div class="col-12">
            <h1 class="modal-title text-center">Product Manager</h1>
        </div>
    </header>
    <div class="row">
        <div class="col-12 text-center">
            <div class="col-12 text-center">
                <c:if test="${requestScope['message']!= null}">
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </div>
            <div class="col-12 text-center">
                <a href="/products">
                    <button class="btn btn-primary">Home</button>
                </a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <form method="post">
                <fieldset>
                    <div class="modal-header">
                        <h4 class="modal-title">Search Product</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label>Name</label>
                                </div>
                                <div class="col-6">
                                    <input type="text" name="name" id="name" class="form-control" required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-success" value="Search">
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

<%--<p>--%>
<%--    <a href="/products">--%>
<%--        <button>Back to product list</button>--%>
<%--    </a>--%>
<%--</p>--%>

<%--<form method="post">--%>
<%--    <fieldset>--%>
<%--        <legend>Search product by name</legend>--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>Name</td>--%>
<%--                <td>--%>
<%--                    <input type="text" name="name" id="name">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td></td>--%>
<%--                <td>--%>
<%--                    <input type="submit" value="Search product by name">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </fieldset>--%>
<%--</form>--%>
</body>
</html>
