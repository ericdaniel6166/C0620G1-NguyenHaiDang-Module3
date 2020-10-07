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

        .edit-form {
            padding: 50px;
            margin: 30px 0;
        }

        .edit-form h1 {
            color: #ffc107;
            font-weight: bold;
            margin: 0 0 15px;
        }

        .edit-form .form-control, .edit-form .btn {
            min-height: 38px;
            border-radius: 2px;
        }

        .edit-form .form-control:focus {
            border-color: #19bc9d;
        }

        .edit-form .btn-primary, .edit-form .btn-primary:active {
            color: #fff;
            min-width: 150px;
            font-size: 16px;
            background: #19bc9d !important;
            border: none;
        }

        .edit-form .btn-primary:hover {
            background: #15a487 !important;
        }

        .edit-form .btn i {
            margin-right: 5px;
        }

        .edit-form label {
            opacity: 0.7;
        }

        .edit-form textarea {
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

<%--    <script>--%>
<%--        document.getElementById('typeOfCustomerId').value=${customerDTOEdit.getTypeOfCustomerId()};--%>
<%--    </script>--%>
</head>
<body>

<div class="container-lg">
    <div class="row">
        <div class="col-md-10 mx-auto">
            <div class="edit-form">
                <h1>Edit Customer</h1>
                <p>${message}</p>
                <form method="post">
                    <div class="form-group">
                        <input type="hidden" class="form-control" name="customerIdEdit" id="customerIdEdit" value="${customerDTOEdit.getCustomerId()}">
                    </div>

                    <div class="form-group">
                        <label for="typeOfCustomerIdEdit">Type Of Customer Name:</label>
                        <select class="form-control" name="typeOfCustomerIdEdit" id="typeOfCustomerIdEdit">
                            <c:forEach var="typeOfCustomer" items="${requestScope['typeOfCustomerList']}">
                                <option value="${typeOfCustomer.getTypeOfCustomerId()}">${typeOfCustomer.getTypeOfCustomerName()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="customerNameEdit">Customer Name:</label>
                        <input type="text" class="form-control" name="customerNameEdit" id="customerNameEdit" value="${customerDTOEdit.getCustomerName()}">
                    </div>

                    <div class="form-group">
                        <label for="dateOfBirthEdit">Date Of Birth:</label>
                        <input type="date" class="form-control" name="dateOfBirthEdit" id="dateOfBirthEdit" value="${customerDTOEdit.getDateOfBirth()}">
                    </div>
                    <div class="form-group">
                        <label for="idNumberEdit">ID Number:</label>
                        <input type="text" class="form-control" name="idNumberEdit" id="idNumberEdit" value="${customerDTOEdit.getIdNumber()}">
                    </div>
                    <div class="form-group">
                        <label for="phoneEdit">Phone:</label>
                        <input type="text" class="form-control" name="phoneEdit" id="phoneEdit" value="${customerDTOEdit.getPhone()}">
                    </div>
                    <div class="form-group">
                        <label for="emailEdit">Email:</label>
                        <input type="text" class="form-control" name="emailEdit" id="emailEdit" value="${customerDTOEdit.getEmail()}">
                    </div>
                    <div class="form-group">
                        <label for="addressEdit">Address:</label>
                        <input type="text" class="form-control" name="addressEdit" id="addressEdit" value="${customerDTOEdit.getAddress()}">
                    </div>
                    <button type="button" onclick="location.href='/list_customer?action=list'" class="btn btn-secondary" >
                        <i class="material-icons">arrow_back</i>
                        Back
                    </button>
                    <button type="submit" class="btn btn-warning">
                        Edit
                        <i class="material-icons">arrow_forward</i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    document.getElementById('typeOfCustomerIdEdit').value= ${customerDTOEdit.getTypeOfCustomerId()};
</script>

</body>
</html>
