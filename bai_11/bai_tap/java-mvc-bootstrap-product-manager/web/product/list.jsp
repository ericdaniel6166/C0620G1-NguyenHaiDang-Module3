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


</head>
<body>

<div class="container-fluid">
    <header class="row">
        <div class="col-12">
            <h1 class="text-center">Product Manager</h1>
        </div>
    </header>
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-3">
                                <h2 <b>Product List</b></h2>
                            </div>
                            <div class="col-sm-9">
                                <a href="/products?action=search-by-name" class="btn btn-info">
                                    <i class="material-icons">search</i>
                                    <span>Search product</span>
                                </a>
                                <a href="/products?action=create" class="btn btn-success">
                                    <i class="material-icons">add_circle</i>
                                    <span>Create new product</span>
                                </a>
                                <a href="/products" class="btn btn-primary">
                                    <i class="material-icons">home</i>
                                    <span>Home</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Description</th>
                            <th>Producer</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items='${requestScope["products"]}' var="product">
                            <tr>
                                <td>${product.getId()}</td>
                                <td>
                                    <a href="/products?action=view&id=${product.getId()}">
                                            ${product.getName()}
                                    </a>
                                </td>
                                <td>${product.getPrice()}</td>
                                <td>${product.getDescription()}</td>
                                <td>${product.getProducer()}</td>
                                <td>
                                    <a href="products?action=edit&id=${product.getId()}" class="edit">
                                        <i class="material-icons" data-toggle="tooltip" title="Edit">mode_edit</i>
                                    </a>
                                    <a href="products?action=delete&id=${product.getId()}" class="delete">
                                        <i class="material-icons" data-toggle="tooltip" title="Delete">delete</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
