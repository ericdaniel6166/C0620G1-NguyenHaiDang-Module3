<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/08/2020
  Time: 2:23 PM
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
            /*text-align: left;*/
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
                <form action="/list_service?action=search_by_name" method="post">
                    <div class="row">
                        <input type="text" name="serviceNameSearch" id="serviceNameSearch"
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
                            <div class="col-sm-3 ">
                                <h2><b>Service List</b></h2>
                            </div>
                            <div class="col-sm-9 ">
                                <!--						href  đến form add new -->
                                <a href="#addServiceModal" class="btn btn-success" data-toggle="modal">
                                    <i class="material-icons">add_circle</i> <span>Add New Service</span></a>
                                <!--						href đến confirm delete-->
                                <%--                        <a href="#deleteServiceModal" class="btn btn-danger" data-toggle="modal"><i--%>
                                <%--                                class="material-icons">remove_circle</i> <span>Delete</span></a>--%>
                                <a href="/list_service?action=list" class="btn btn-info">
                                    <i class="material-icons">view_list</i>
                                    <span>Service List</span>
                                </a>
                                <a href="../../index.jsp" class="btn btn-primary">
                                    <i class="material-icons">home</i>
                                    <span>Home</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover" id="serviceTable">
                        <thead>
                        <tr>
                            <th>Service ID</th>
                            <th>Service Name</th>

                            <th>area</th>
                            <th>numberOfFloors</th>
                            <th>maximumNumberOfCustomers</th>
                            <th>rentPrice</th>
                            <th>status</th>

                            <th>typeOfRentName</th>
                            <th>typeOfRentPrice</th>

                            <th>TypeOfService Name</th>

                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="serviceDTO" items='${requestScope["serviceDTOList"]}'>
                            <tr>
                                <td>${serviceDTO.getServiceId()}</td>
                                <td>
                                    <a href="#viewServiceModal" data-toggle="modal"
                                       onclick="setServiceView('${serviceDTO.getServiceId()}',
                                               '${serviceDTO.getServiceName()}',
                                               '${serviceDTO.getArea()}',
                                               '${serviceDTO.getNumberOfFloors()}',
                                               '${serviceDTO.getMaximumNumberOfCustomers()}',
                                               '${serviceDTO.getRentPrice()}',
                                               '${serviceDTO.getStatus()}',
                                               '${serviceDTO.getTypeOfRentName()}',
                                               '${serviceDTO.getTypeOfRentPrice()}',
                                               '${serviceDTO.getTypeOfServiceName()}')">

                                        <div data-toggle="tooltip" title="View">
                                                ${serviceDTO.getServiceName()}
                                        </div>
                                    </a>
                                </td>
                                <td>${serviceDTO.getArea()}</td>
                                <td>${serviceDTO.getNumberOfFloors()}</td>
                                <td>${serviceDTO.getMaximumNumberOfCustomers()}</td>
                                <td>${serviceDTO.getRentPrice()}</td>
                                <td>${serviceDTO.getStatus()}</td>

                                <td>${serviceDTO.getTypeOfRentName()}</td>
                                <td>${serviceDTO.getTypeOfRentPrice()}</td>

                                <td>${serviceDTO.getTypeOfServiceName()}</td>
                                <td>
                                    <a href="#editServiceModal" class="edit" data-toggle="modal"
                                       onclick="setServiceEdit(
                                               '${serviceDTO.getServiceId()}',
                                               '${serviceDTO.getServiceName()}',

                                               '${serviceDTO.getArea()}',
                                               '${serviceDTO.getNumberOfFloors()}',
                                               '${serviceDTO.getMaximumNumberOfCustomers()}',
                                               '${serviceDTO.getRentPrice()}',
                                               '${serviceDTO.getStatus()}',

                                               '${serviceDTO.getTypeOfRentId()}',

                                               '${serviceDTO.getTypeOfServiceId()}'
                                               )">

                                        <i class="material-icons" data-toggle="tooltip" title="Edit">mode_edit</i>
                                    </a>
                                    <a href="#deleteServiceModal" class="delete" data-toggle="modal"
                                       onclick="setServiceDelete('${serviceDTO.getServiceId()}')">
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
<div id="addServiceModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_service?action=add" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Service</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="serviceIdAdd">Service ID</label>
                        <input type="text" class="form-control" name="serviceIdAdd" id="serviceIdAdd">
                    </div>
                    <div class="form-group">
                        <label for="serviceNameAdd">Service Name</label>
                        <input type="text" class="form-control" name="serviceNameAdd" id="serviceNameAdd">
                    </div>

                    <div class="form-group">
                        <label>area</label>
                        <input type="text" class="form-control" name="areaAdd" id="areaAdd">
                    </div>
                    <div class="form-group">
                        <label>numberOfFloors</label>
                        <input type="text" class="form-control" name="numberOfFloorsAdd" id="numberOfFloorsAdd">
                    </div>
                    <div class="form-group">
                        <label>maximumNumberOfCustomers</label>
                        <input type="text" class="form-control" name="maximumNumberOfCustomersAdd"
                               id="maximumNumberOfCustomersAdd">
                    </div>
                    <div class="form-group">
                        <label>rentPrice</label>
                        <input type="text" class="form-control" name="rentPriceAdd" id="rentPriceAdd">
                    </div>

                    <div class="form-group">
                        <label for="typeOfRentIdAdd">TypeOfRent ID</label>
                        <select class="form-control" name="typeOfRentIdAdd" id="typeOfRentIdAdd">
                            <c:forEach var="typeOfRent" items="${requestScope['typeOfRentList']}">
                                <option value="${typeOfRent.getTypeOfRentId()}">${typeOfRent.getTypeOfRentName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="typeOfServiceIdAdd">TypeOfService ID</label>
                        <select class="form-control" name="typeOfServiceIdAdd" id="typeOfServiceIdAdd">
                            <c:forEach var="typeOfService" items="${requestScope['typeOfServiceList']}">
                                <option value="${typeOfService.getTypeOfServiceId()}">${typeOfService.getTypeOfServiceName()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>status</label>
                        <input type="text" class="form-control" name="statusAdd" id="statusAdd">
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
<div id="editServiceModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_service?action=edit" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Service</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <input type="hidden" class="form-control" name="serviceIdEdit" id="serviceIdEdit">
                    </div>

                    <div class="form-group">
                        <label for="serviceNameEdit">Service Name</label>
                        <input type="text" class="form-control" name="serviceNameEdit" id="serviceNameEdit">
                    </div>

                    <div class="form-group">
                        <label>area</label>
                        <input type="text" class="form-control" name="areaEdit" id="areaEdit">
                    </div>
                    <div class="form-group">
                        <label>numberOfFloors</label>
                        <input type="text" class="form-control" name="numberOfFloorsEdit" id="numberOfFloorsEdit">
                    </div>
                    <div class="form-group">
                        <label>maximumNumberOfCustomers</label>
                        <input type="text" class="form-control" name="maximumNumberOfCustomersEdit"
                               id="maximumNumberOfCustomersEdit">
                    </div>
                    <div class="form-group">
                        <label>rentPrice</label>
                        <input type="text" class="form-control" name="rentPriceEdit" id="rentPriceEdit">
                    </div>

                    <div class="form-group">
                        <label for="typeOfRentIdEdit">TypeOfRent ID</label>
                        <select class="form-control" name="typeOfRentIdEdit" id="typeOfRentIdEdit">
                            <c:forEach var="typeOfRent" items="${requestScope['typeOfRentList']}">
                                <option value="${typeOfRent.getTypeOfRentId()}">${typeOfRent.getTypeOfRentName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="typeOfServiceIdEdit">TypeOfService ID</label>
                        <select class="form-control" name="typeOfServiceIdEdit" id="typeOfServiceIdEdit">
                            <c:forEach var="typeOfService" items="${requestScope['typeOfServiceList']}">
                                <option value="${typeOfService.getTypeOfServiceId()}">${typeOfService.getTypeOfServiceName()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>status</label>
                        <input type="text" class="form-control" name="statusEdit" id="statusEdit">
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
<div id="deleteServiceModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_service?action=delete" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Service</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>

                    <%--                    Input Service ID delete --%>
                    <input type="hidden" name="serviceIdDelete" id="serviceIdDelete">

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
<div id="viewServiceModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Service Information</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-6"><p>Service ID:</p></div>
                    <div class="col-6"><p id="serviceIdView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>Service Name:</p></div>
                    <div class="col-6"><p id="serviceNameView"></p></div>
                </div>
                
                <div class="row">
                    <div class="col-6"><p>area</p></div>
                    <div class="col-6"><p id="areaView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>numberOfFloors</p></div>
                    <div class="col-6"><p id="numberOfFloorsView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>maximumNumberOfCustomers</p></div>
                    <div class="col-6"><p id="maximumNumberOfCustomersView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>rentPrice</p></div>
                    <div class="col-6"><p id="rentPriceView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>status</p></div>
                    <div class="col-6"><p id="statusView"></p></div>
                </div>
                
                <div class="row">
                    <div class="col-6"><p>typeOfRentName</p></div>
                    <div class="col-6"><p id="typeOfRentNameView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>typeOfRentPrice</p></div>
                    <div class="col-6"><p id="typeOfRentPriceView"></p></div>
                </div>
                
                <div class="row">
                    <div class="col-6"><p>typeOfServiceName</p></div>
                    <div class="col-6"><p id="typeOfServiceNameView"></p></div>
                </div>

            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
            </div>
        </div>
    </div>
</div>


<script>
    function setServiceView(serviceId, serviceName, area, numberOfFloors, maximumNumberOfCustomers, rentPrice, status, typeOfRentName, typeOfRentPrice, typeOfServiceName) {
        document.getElementById("serviceIdView").innerHTML = serviceId;
        document.getElementById("serviceNameView").innerHTML = serviceName;

        document.getElementById("areaView").innerHTML = area;
        document.getElementById("numberOfFloorsView").innerHTML = numberOfFloors;
        document.getElementById("maximumNumberOfCustomersView").innerHTML = maximumNumberOfCustomers;
        document.getElementById("rentPriceView").innerHTML = rentPrice;
        document.getElementById("statusView").innerHTML = status;

        document.getElementById("typeOfRentNameView").innerHTML = typeOfRentName;
        document.getElementById("typeOfRentPriceView").innerHTML = typeOfRentPrice;

        document.getElementById("typeOfServiceNameView").innerHTML = typeOfServiceName;
    }

    function setServiceEdit(serviceId, serviceName, area, numberOfFloors, maximumNumberOfCustomers, rentPrice, status, typeOfRentId, typeOfServiceId) {
        document.getElementById("serviceIdEdit").value = serviceId;
        document.getElementById("serviceNameEdit").value = serviceName;

        document.getElementById('areaEdit').value = area;
        document.getElementById('numberOfFloorsEdit').value = numberOfFloors;
        document.getElementById('maximumNumberOfCustomersEdit').value = maximumNumberOfCustomers;
        document.getElementById("rentPriceEdit").value = rentPrice;
        document.getElementById("statusEdit").value = status;

        document.getElementById("typeOfRentIdEdit").value = typeOfRentId;

        document.getElementById("typeOfServiceIdEdit").value = typeOfServiceId;
    }

    function setServiceDelete(serviceId) {
        document.getElementById("serviceIdDelete").value = serviceId;
    }

    // Xoá lịch sử lưu trên add modal
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }

    $(document).ready(function () {
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Pagination, Instant search, Multi-column ordering
        // https://datatables.net/
        $('#serviceTable').DataTable();
    });
</script>
</body>
</html>
