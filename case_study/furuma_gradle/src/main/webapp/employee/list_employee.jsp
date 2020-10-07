<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/01/2020
  Time: 11:52 AM
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

    <%--    cdn datatable Pagination, Instant search, Multi-column ordering--%>
    <%--    https://datatables.net/--%>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css">
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>

    <!--	custom style-->
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

        header {
            text-align: center;
        }

        .search-box {
            margin: 10px 50px;
            float: right;
        }

        .table-responsive {
            margin: 20px 0;
        }

        .table-wrapper {
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            min-width: 1000px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 15px;
            background: #435d7d;
            color: #fff;
            padding: 16px 30px;
            min-width: 100%;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .table-title .btn-group {
            float: right;
        }

        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }

        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }

        .custom-checkbox label:before {
            width: 18px;
            height: 18px;
        }

        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }

        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }

        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
            font-size: 14px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }

        .modal textarea.form-control {
            resize: vertical;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
        }
    </style>
    <!--	custom js-->
    <script>
        function setEmployeeView(employeeId, employeeName, positionName, levelName, departmentName, dateOfBirth, idNumber, salary, phone, email, address) {
            document.getElementById("employeeIdView").innerHTML = employeeId;
            document.getElementById("employeeNameView").innerHTML = employeeName;

            document.getElementById("positionNameView").innerHTML = positionName;
            document.getElementById("levelNameView").innerHTML = levelName;
            document.getElementById("departmentNameView").innerHTML = departmentName;

            document.getElementById("dateOfBirthView").innerHTML = dateOfBirth;
            document.getElementById("idNumberView").innerHTML = idNumber;
            document.getElementById("salaryView").innerHTML = salary;
            document.getElementById("phoneView").innerHTML = phone;
            document.getElementById("emailView").innerHTML = email;
            document.getElementById("addressView").innerHTML = address;
        }

        // Xoá lịch sử lưu trên add modal
        if (window.history.replaceState) {
            window.history.replaceState(null, null, window.location.href);
        }


        function setEmployeeEdit(employeeId, employeeName, positionName, levelName, departmentName, dateOfBirth, idNumber, salary, phone, email, address) {
            document.getElementById("employeeIdEdit").value = employeeId;
            document.getElementById("employeeNameEdit").value = employeeName;

            document.getElementById(positionName).selected = true;
            document.getElementById(levelName).selected = true;
            document.getElementById(departmentName).selected = true;

            document.getElementById("dateOfBirthEdit").value = dateOfBirth;
            document.getElementById("idNumberEdit").value = idNumber;
            document.getElementById("salaryEdit").value = salary;
            document.getElementById("phoneEdit").value = phone;
            document.getElementById("emailEdit").value = email;
            document.getElementById("addressEdit").value = address;
        }

        function setEmployeeDelete(employeeIdDelete) {
            document.getElementById("employeeIdDelete").value = employeeIdDelete;
        }

        $(document).ready(function () {
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Pagination, Instant search, Multi-column ordering
            // https://datatables.net/
            $('#employeeTable').DataTable();

        });
    </script>
</head>
<body>

<div class="container-fluid">
    <%--    header--%>
    <header class="row">
        <div class="col-12">
            <h1>Furama Manager</h1>
            <h3>${message}</h3>
        </div>
    </header>
    <%--    search-box--%>
    <div class="row">
        <div class="col-12">
            <div class="search-box">
                <form action="/list_employee?action=search_by_name" method="post">
                    <div class="row">
                        <input type="text" name="employeeNameSearch" id="employeeNameSearch"
                               placeholder="Search by Name">
                        <button type="submit" value="submit" class="btn btn-info">
                            <i class="material-icons">search</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%--    table-responsive--%>
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6 ">
                                <h2><b>Employee List</b></h2>
                            </div>
                            <div class="col-sm-6 ">
                                <!--						href  đến form add new -->
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal">
                                    <i class="material-icons">add_circle</i> <span>Add New Employee</span></a>
                                <!--						href đến confirm delete-->
                                <%--                        <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i--%>
                                <%--                                class="material-icons">remove_circle</i> <span>Delete</span></a>--%>
                                <a href="/list_employee?action=list" class="btn btn-info">
                                    <i class="material-icons">view_list</i>
                                    <span>Employee List</span>
                                </a>
                                <a href="../index.jsp" class="btn btn-primary">
                                    <i class="material-icons">home</i>
                                    <span>Home</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover" id="employeeTable">
                        <thead>
                        <tr>
                            <th>Employee ID</th>
                            <th>Employee Name</th>
                            <th>Position Name</th>
                            <th>Level Name</th>
                            <th>Department Name</th>
                            <th>Date Of Birth</th>
                            <th>ID Number</th>
                            <th>Salary</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="employeeDTO" items='${requestScope["employeeDTOList"]}'>
                            <tr>
                                <td>${employeeDTO.getEmployeeId()}</td>
                                <td>
                                    <a href="#viewEmployeeModal" data-toggle="modal"
                                       onclick="setEmployeeView(
                                               '${employeeDTO.getEmployeeId()}',
                                               '${employeeDTO.getEmployeeName()}',
                                               '${employeeDTO.getPositionName()}',
                                               '${employeeDTO.getLevelName()}',
                                               '${employeeDTO.getDepartmentName()}',
                                               '${employeeDTO.getDateOfBirth()}',
                                               '${employeeDTO.getIdNumber()}',
                                               '${employeeDTO.getSalary()}',
                                               '${employeeDTO.getPhone()}',
                                               '${employeeDTO.getEmail()}',
                                               '${employeeDTO.getAddress()}'
                                               )"
                                    >
                                            ${employeeDTO.getEmployeeName()}
                                    </a>
                                </td>
                                <td>${employeeDTO.getPositionName()}</td>
                                <td>${employeeDTO.getLevelName()}</td>
                                <td>${employeeDTO.getDepartmentName()}</td>
                                <td>${employeeDTO.getDateOfBirth()}</td>
                                <td>${employeeDTO.getIdNumber()}</td>
                                <td>${employeeDTO.getSalary()}</td>
                                <td>${employeeDTO.getPhone()}</td>
                                <td>${employeeDTO.getEmail()}</td>
                                <td>${employeeDTO.getAddress()}</td>
                                <td>
                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"
                                       onclick="setEmployeeEdit(
                                               '${employeeDTO.getEmployeeId()}',
                                               '${employeeDTO.getEmployeeName()}',
                                               '${employeeDTO.getPositionName()}',
                                               '${employeeDTO.getLevelName()}',
                                               '${employeeDTO.getDepartmentName()}',
                                               '${employeeDTO.getDateOfBirth()}',
                                               '${employeeDTO.getIdNumber()}',
                                               '${employeeDTO.getSalary()}',
                                               '${employeeDTO.getPhone()}',
                                               '${employeeDTO.getEmail()}',
                                               '${employeeDTO.getAddress()}'
                                               );">

                                        <i class="material-icons" data-toggle="tooltip" title="Edit">mode_edit</i>
                                    </a>
                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"
                                       onclick="setEmployeeDelete('${employeeDTO.getEmployeeId()}')">
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

<%--Modal--%>
<!-- Add Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_employee?action=add" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="employeeId">Employee ID</label>
                        <input type="text" class="form-control" name="employeeId" id="employeeId">
                    </div>
                    <div class="form-group">
                        <label for="employeeName">Employee Name</label>
                        <input type="text" class="form-control" name="employeeName" id="employeeName">
                    </div>
                    <div class="form-group">
                        <label for="positionId">Position ID</label>
                        <select class="form-control" name="positionId" id="positionId">
                            <c:forEach var="position" items="${requestScope['positionList']}">
                                <option value="${position.getPositionId()}">${position.getPositionName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="levelId">Level ID</label>
                        <select class="form-control" name="levelId" id="levelId">
                            <c:forEach var="level" items="${requestScope['levelList']}">
                                <option value="${level.getLevelId()}">${level.getLevelName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="departmentId">Department ID</label>
                        <select class="form-control" name="departmentId" id="departmentId">
                            <c:forEach var="department" items="${requestScope['departmentList']}">
                                <option value="${department.getDepartmentId()}">${department.getDepartmentName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Date Of Birth</label>
                        <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth">
                    </div>
                    <div class="form-group">
                        <label>ID Number</label>
                        <input type="text" class="form-control" name="idNumber" id="idNumber">
                    </div>
                    <div class="form-group">
                        <label>Salary</label>
                        <input type="text" class="form-control" name="salary" id="salary">
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" name="phone" id="phone">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" class="form-control" name="email" id="email">
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" name="address" id="address">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_employee?action=edit" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <%--                        <label for="employeeIdEdit">Employee ID</label>--%>
                        <input type="hidden" class="form-control" name="employeeIdEdit" id="employeeIdEdit">
                    </div>
                    <div class="form-group">
                        <label for="employeeNameEdit">Employee Name</label>
                        <input type="text" class="form-control" name="employeeNameEdit" id="employeeNameEdit">
                    </div>
                    <div class="form-group">
                        <label for="positionIdEdit">Position ID</label>
                        <select class="form-control" name="positionIdEdit" id="positionIdEdit">
                            <%--                            <option selected id="positionIdEditSelected"></option>--%>
                            <c:forEach var="position" items="${requestScope['positionList']}">

                                <option
                                        value="${position.getPositionId()}"
                                        id="${position.getPositionName()}"
                                >
                                        ${position.getPositionName()}
                                </option>

                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="levelIdEdit">Level ID</label>
                        <select class="form-control" name="levelIdEdit" id="levelIdEdit">
                            <c:forEach var="level" items="${requestScope['levelList']}">
                                <option
                                        value="${level.getLevelId()}"
                                        id="${level.getLevelName()}"
                                >
                                        ${level.getLevelName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="departmentIdEdit">Department ID</label>
                        <select class="form-control" name="departmentIdEdit" id="departmentIdEdit">
                            <c:forEach var="department" items="${requestScope['departmentList']}">
                                <option
                                        value="${department.getDepartmentId()}"
                                        id="${department.getDepartmentName()}"
                                >
                                        ${department.getDepartmentName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="dateOfBirthEdit">Date Of Birth</label>
                        <input type="date" class="form-control" name="dateOfBirthEdit" id="dateOfBirthEdit">
                    </div>
                    <div class="form-group">
                        <label for="idNumberEdit">ID Number</label>
                        <input type="text" class="form-control" name="idNumberEdit" id="idNumberEdit">
                    </div>
                    <div class="form-group">
                        <label for="salaryEdit">Salary</label>
                        <input type="text" class="form-control" name="salaryEdit" id="salaryEdit">
                    </div>
                    <div class="form-group">
                        <label for="phoneEdit">Phone</label>
                        <input type="text" class="form-control" name="phoneEdit" id="phoneEdit">
                    </div>
                    <div class="form-group">
                        <label for="emailEdit">Email</label>
                        <input type="text" class="form-control" name="emailEdit" id="emailEdit">
                    </div>
                    <div class="form-group">
                        <label for="addressEdit">Address</label>
                        <input type="text" class="form-control" name="addressEdit" id="addressEdit">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_employee?action=delete" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>

                    <%--                    Input Employee ID delete --%>
                    <input type="hidden" name="employeeIdDelete" id="employeeIdDelete">

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>
<%-- View Modal--%>
<div id="viewEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Employee Information</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">

                <h5>Employee ID:</h5>
                <p id="employeeIdView"></p>


                <h5>Employee Name:</h5>
                <p id="employeeNameView"></p>


                <h5>Position Name:</h5>
                <p id="positionNameView"></p>


                <h5>Level Name:</h5>
                <p id="levelNameView"></p>


                <h5>Department Name:</h5>
                <p id="departmentNameView"></p>


                <h5>Date Of Birth:</h5>
                <p id="dateOfBirthView"></p>


                <h5>ID Number:</h5>
                <p id="idNumberView"></p>


                <h5>Salary:</h5>
                <p id="salaryView"></p>


                <h5>Phone:</h5>
                <p id="phoneView"></p>


                <h5>Email:</h5>
                <p id="emailView"></p>


                <h5>Address:</h5>
                <p id="addressView"></p>


                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
