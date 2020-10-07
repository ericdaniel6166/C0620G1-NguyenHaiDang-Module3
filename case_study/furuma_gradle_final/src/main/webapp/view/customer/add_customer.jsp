<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/06/2020
  Time: 10:10 AM
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

        .add-form {
            padding: 50px;
            margin: 30px 0;
        }

        .add-form h1 {
            color: #28a745;
            font-weight: bold;
            margin: 0 0 15px;
        }

        .add-form .form-control, .add-form .btn {
            min-height: 38px;
            border-radius: 2px;
        }

        .add-form .form-control:focus {
            border-color: #19bc9d;
        }

        .add-form .btn-primary, .add-form .btn-primary:active {
            color: #fff;
            min-width: 150px;
            font-size: 16px;
            background: #19bc9d !important;
            border: none;
        }

        .add-form .btn-primary:hover {
            background: #15a487 !important;
        }

        .add-form .btn i {
            margin-right: 5px;
        }

        .add-form label {
            opacity: 0.7;
        }

        .add-form textarea {
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
            <div class="add-form">
                <h1>Add New Customer</h1>
                <p>${message}</p>
                <form method="post">
                    <div class="form-group">
                        <label for="customerIdAdd">Customer ID:</label>
                        <input type="text" class="form-control" name="customerIdAdd" id="customerIdAdd">
                    </div>

                    <div class="form-group">
                        <label for="typeOfCustomerIdAdd">Type Of Customer Name:</label>
                        <select class="form-control" name="typeOfCustomerIdAdd" id="typeOfCustomerIdAdd">
                            <c:forEach var="typeOfCustomer" items="${requestScope['typeOfCustomerList']}">
                                <option value="${typeOfCustomer.getTypeOfCustomerId()}">
                                        ${typeOfCustomer.getTypeOfCustomerName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="customerNameAdd">Customer Name:</label>
                        <input type="text" class="form-control" name="customerNameAdd" id="customerNameAdd">
                    </div>

                    <div class="form-group">
                        <label for="dateOfBirthAdd">Date Of Birth:</label>
                        <input type="date" class="form-control" name="dateOfBirthAdd" id="dateOfBirthAdd">
                    </div>
                    <div class="form-group">
                        <label for="idNumberAdd">ID Number:</label>
                        <input type="text" class="form-control" name="idNumberAdd" id="idNumberAdd">
                    </div>
                    <div class="form-group">
                        <label for="phoneAdd">Phone:</label>
                        <input type="text" class="form-control" name="phoneAdd" id="phoneAdd">
                    </div>
                    <div class="form-group">
                        <label for="emailAdd">Email:</label>
                        <input type="text" class="form-control" name="emailAdd" id="emailAdd">
                    </div>
                    <div class="form-group">
                        <label for="addressAdd">Address:</label>
                        <input type="text" class="form-control" name="addressAdd" id="addressAdd">
                    </div>
                    <button type="button" onclick="location.href='/list_customer?action=list'" class="btn btn-secondary">
                        <i class="material-icons">arrow_back</i>
                        Back
                    </button>
                    <button type="submit" class="btn btn-success">
                        Add
                        <i class="material-icons">arrow_forward</i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
