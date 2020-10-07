<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/06/2020
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!--	cdn-->
    <%--    cdn font Varela--%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">

    <%--    cdn Google Material Icons --%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <%--    cdn font awesome 4.7--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <%--    cdn bootstrap 4.3--%>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

    <style>
        body {
            color: #333;
            background: #fafafa;
            font-family: 'Varela Round', sans-serif;
        }

        .delete-form {
            padding: 50px;
            margin: 30px 0;
        }

        .delete-form h1 {
            color: #dc3545;
            font-weight: bold;
            margin: 0 0 15px;
        }

        .delete-form .form-control, .delete-form .btn {
            min-height: 38px;
            border-radius: 2px;
        }

        .delete-form .form-control:focus {
            border-color: #19bc9d;
        }

        .delete-form .btn-primary, .delete-form .btn-primary:active {
            color: #fff;
            min-width: 150px;
            font-size: 16px;
            background: #19bc9d !important;
            border: none;
        }

        .delete-form .btn-primary:hover {
            background: #15a487 !important;
        }

        .delete-form .btn i {
            margin-right: 5px;
        }

        .delete-form label {
            opacity: 0.7;
        }

        .delete-form textarea {
            resize: vertical;
        }

        .hint-text {
            font-size: 15px;
            padding-bottom: 20px;
            opacity: 0.6;
        }

        .btn-group {
            float: right;
        }

        .btn {
            color: #fff;
            float: left;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .btn span {
            float: left;
            margin-top: 2px;
        }
    </style>

</head>
<body>

<div class="container-lg">
    <div class="row">
        <div class="col-md-10 mx-auto">
            <div class="delete-form">
                <h1>Delete Customer</h1>
                <p>${message}</p>
                <form method="post">
                    <div class="form-group">
                        <p>Are you sure you want to delete these Records?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                    </div>
                    <div class="form-group">
                        <input type="hidden" class="form-control" name="customerIdDelete" id="customerIdDelete" value="${customerDTODelete.getCustomerId()}">
                        <h3>Customer ID:</h3>
                        <p>${customerDTODelete.getCustomerId()}</p>
                    </div>

                    <div class="form-group">
                        <h3>Type Of Customer Name:</h3>
                        <p>${customerDTODelete.getTypeOfCustomerName()}</p>
                    </div>

                    <div class="form-group">
                        <h3>Customer Name:</h3>
                        <p>${customerDTODelete.getCustomerName()}</p>
                    </div>

                    <div class="form-group">
                        <h3>Date Of Birth:</h3>
                        <p>${customerDTODelete.getDateOfBirth()}</p>
                    </div>
                    <div class="form-group">
                        <h3>ID Number:</h3>
                        <p>${customerDTODelete.getIdNumber()}</p>
                    </div>
                    <div class="form-group">
                        <h3>Phone:</h3>
                        <p>${customerDTODelete.getPhone()}</p>
                    </div>
                    <div class="form-group">
                        <h3>Email:</h3>
                        <p>${customerDTODelete.getEmail()}</p>
                    </div>
                    <div class="form-group">
                        <h3>Address:</h3>
                        <p>${customerDTODelete.getAddress()}</p>
                    </div>
                    <button type="button" onclick="location.href='/list_customer?action=list'" class="btn btn-secondary" >
                        <i class="material-icons">arrow_back</i>
                        Back
                    </button>
                    <button type="submit" class="btn btn-danger">
                        Delete
                        <i class="material-icons">delete</i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
