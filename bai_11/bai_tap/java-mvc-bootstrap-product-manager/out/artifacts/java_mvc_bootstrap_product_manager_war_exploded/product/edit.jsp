<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/27/2020
  Time: 7:03 PM
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

<%--Bước 10: Phát triển tính năng cập nhật thông tin khách hàng--%>
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
                        <h4 class="modal-title">Edit Product</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label>Name</label>
                                </div>
                                <div class="col-6">
                                    <input type="text" name="name" id="name" class="form-control" required value="${requestScope["product"].getName()}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label>Price</label>
                                </div>
                                <div class="col-6">
                                    <input type="text" name="price" id="price" class="form-control" required value="${requestScope["product"].getPrice()}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label>Description</label>
                                </div>
                                <div class="col-6">
                                    <input type="text" name="description" id="description" class="form-control" required value="${requestScope["product"].getDescription()}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label>Producer</label>
                                </div>
                                <div class="col-6">
                                    <input type="text" name="producer" id="producer" class="form-control" required value="${requestScope["product"].getProducer()}">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-warning" value="Edit">
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

<%--<h1>Edit product</h1>--%>
<%--<p>--%>
<%--    <c:if test="${requestScope['message']!=null}">--%>
<%--        <span class="message">${requestScope["message"]}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<%--<p>--%>
<%--    <a href="/products">--%>
<%--        <button>Back to product list</button>--%>
<%--    </a>--%>
<%--</p>--%>
<%--<form method="post">--%>
<%--    <fieldset>--%>
<%--        <legend>Product information</legend>--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>Name: </td>--%>
<%--                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Price: </td>--%>
<%--                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Description: </td>--%>
<%--                <td><input type="text" name="description" id="description" value="${requestScope["product"].getDescription()}"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Producer: </td>--%>
<%--                <td><input type="text" name="producer" id="producer" value="${requestScope["product"].getProducer()}"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td></td>--%>
<%--                <td><input type="submit" value="Update product"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </fieldset>--%>
<%--</form>--%>

</body>
</html>
