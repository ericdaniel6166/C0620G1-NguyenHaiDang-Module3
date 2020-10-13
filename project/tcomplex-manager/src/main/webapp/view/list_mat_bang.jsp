<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/12/2020
  Time: 10:20 AM
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

    <%--    cdn bootstrap 4.5.2--%>
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
            trangThai: #566787;
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
            trangThai: #fff;
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
            trangThai: #fff;
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
            border-trangThai: #e9e9e9;
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
            background-trangThai: #fcfcfc;
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
            trangThai: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            trangThai: #2196F3;
        }

        table.table td a.edit {
            trangThai: #FFC107;
        }

        table.table td a.delete {
            trangThai: #F44336;
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
            trangThai: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            trangThai: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            trangThai: #ccc;
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
            loaiMatBang: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            loaiMatBang: absolute;
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
            loaiMatBang: absolute;
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
            border-trangThai: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-trangThai: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            trangThai: #b8b8b8;
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
            border-trangThai: #dddddd;
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
            <h1>TComplex Manager</h1>
            <h3>${message}</h3>
        </div>
    </header>

    <%--        search all--%>
    <div class="row">
        <div class="col-12 ">
            <div class="search-box">
                <form action="/list_mat_bang?action=search" method="post">
                    <div class="row float-right">
<%--                        <div class="col-4">--%>
<%--                            <input type="text" class="form-control" name="matBangNameSearch" id="matBangNameSearch"--%>
<%--                                   placeholder="matBangNameSearch">--%>
<%--                        </div>--%>
                        <div class="col-4">
                            <input type="text" class="form-control" name="tangSearch" id="tangSearch"
                                   placeholder="tangSearch">
                        </div>
                        <div class="col-4">
                            <input type="text" class="form-control" name="giaTienSearch" id="giaTienSearch"
                                   placeholder="giaTienSearch">
                        </div>
<%--                        <div class="col-4">--%>
<%--                            <input type="text" class="form-control" name="descriptionSearch" id="descriptionSearch"--%>
<%--                                   placeholder="descriptionSearch">--%>
<%--                        </div>--%>
                        <div class="col-4">
                            <input type="text" class="form-control" name="loaiMatBangTenSearch" id="loaiMatBangTenSearch"
                                   placeholder="loaiMatBangTenSearch">
                        </div>
<%--                        <div class="col-4">--%>
<%--                            <input type="text" class="form-control" name="trangThaiNameSearch" id="trangThaiNameSearch"--%>
<%--                                   placeholder="trangThaiNameSearch">--%>
<%--                        </div>--%>

                    </div>
                    <div class="clearfix text-right" >
                        <div >
                            <button type="submit" value="submit" class="btn btn-info">
                                <i class="material-icons">search</i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

<%--    &lt;%&ndash;    search-box&ndash;%&gt;--%>
<%--    <div class="row">--%>
<%--        <div class="col-12">--%>
<%--            <div class="search-box">--%>
<%--                <form action="/list_mat_bang?action=search_by_name" method="post">--%>
<%--                    <div class="row">--%>
<%--                        <input type="text" name="matBangNameSearchByName" id="matBangNameSearchByName"--%>
<%--                               placeholder="Search by Name">--%>
<%--                        <button type="submit" value="submit" class="btn btn-info">--%>
<%--                            <i class="material-icons">search</i>--%>
<%--                        </button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--        table-responsive--%>
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-3 ">
                                <h2><b>MatBang List</b></h2>
                            </div>
                            <div class="col-sm-9 ">
                                <!--						href  đến form add new -->
                                <a href="#addMatBangModal" class="btn btn-success" data-toggle="modal">
                                    <i class="material-icons">add_circle</i> <span>Add New MatBang</span></a>
                                <!--						href đến confirm delete-->
                                <%--                        <a href="#deleteMatBangModal" class="btn btn-danger" data-toggle="modal"><i--%>
                                <%--                                class="material-icons">remove_circle</i> <span>Delete</span></a>--%>
<%--                                <a href="/list_mat_bang?action=list" class="btn btn-info">--%>
<%--                                    <i class="material-icons">view_list</i>--%>
<%--                                    <span>MatBang List</span>--%>
<%--                                </a>--%>
<%--                                <a href="../../index.jsp" class="btn btn-primary">--%>
<%--                                    <i class="material-icons">home</i>--%>
<%--                                    <span>Home</span>--%>
<%--                                </a>--%>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover" id="matBangTable">
                        <thead>
                        <tr>
                            <th>Ma MatBang</th>
<%--                            <td>${matBangDTO.getDienTich()}</td>--%>
<%--                            <td>${matBangDTO.getTang()}</td>--%>
<%--                            <td>${matBangDTO.getGiaTien()}</td>--%>
<%--                            <td>${matBangDTO.getNgayBatDau()}</td>--%>
<%--                            <td>${matBangDTO.getNgayKetThuc()}</td>--%>
<%--                            <td>${matBangDTO.getLoaiMatBangTen()}</td>--%>
<%--                            <td>${matBangDTO.getTrangThaiTen()}</td>--%>
                            <th>Dien tich</th>
                            <th>Tang</th>
                            <th>Gia tien</th>
                            <th>Ngay bat dau</th>
                            <th>Ngay ket thuc</th>
                            <th>Loai Mat Bang</th>
                            <th>Trang thai</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="matBangDTO" items='${requestScope["matBangDTOList"]}'>
                            <tr>
                                <td>${matBangDTO.getMaMatBang()}</td>
<%--                                <td>--%>
<%--                                    <a href="#viewMatBangModal" data-toggle="modal"--%>
<%--&lt;%&ndash;                                       onclick="setMatBangView(&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getMaMatBang()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getMatBangTen()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getLoaiMatBangTen()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getTrangThaiTen()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getTang()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getGiaTien()}'&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               )"&ndash;%&gt;--%>
<%--                                    >--%>
<%--                                        <div data-toggle="tooltip" title="View">--%>
<%--                                                ${matBangDTO.getMatBangTen()}--%>
<%--                                        </div>--%>
<%--                                    </a>--%>
<%--                                </td>--%>
                                <td>${matBangDTO.getDienTich()}</td>
                                <td>${matBangDTO.getTang()}</td>
                                <td>${matBangDTO.getGiaTien()}</td>
                                <td>${matBangDTO.getNgayBatDau()}</td>
                                <td>${matBangDTO.getNgayKetThuc()}</td>
                                <td>${matBangDTO.getLoaiMatBangTen()}</td>
                                <td>${matBangDTO.getTrangThaiTen()}</td>
                                <td>
<%--                                    <a href="#editMatBangModal" class="edit" data-toggle="modal"--%>
<%--&lt;%&ndash;                                       onclick="setMatBangEdit(&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getMaMatBang()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getMatBangTen()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getLoaiMatBangId()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getTrangThaiId()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getTang()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               '${matBangDTO.getGiaTien()}',&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               )"&ndash;%&gt;--%>
<%--                                    >--%>
<%--                                        <i class="material-icons" data-toggle="tooltip" title="Edit">mode_edit</i>--%>
<%--                                    </a>--%>
                                    <a href="#deleteMatBangModal" class="delete" data-toggle="modal"
                                       onclick="setMatBangDelete('${matBangDTO.getMaMatBang()}')">
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

<!-- Add Modal HTML -->
<div id="addMatBangModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_mat_bang?action=add" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add MatBang</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="maMatBangAdd">Ma MatBang </label>
                        <input type="text" class="form-control" name="maMatBangAdd" id="maMatBangAdd">
                    </div>
                    <div class="form-group">
                        <label>Dien Tich</label>
                        <input type="text" class="form-control" name="dienTichAdd" id="dienTichAdd">
                    </div>
                    <div class="form-group">
                        <label>Tang</label>
                        <input type="text" class="form-control" name="tangAdd" id="tangAdd">
                    </div>

                    <div class="form-group">
                        <label>GiaTien</label>
                        <input type="text" class="form-control" name="giaTienAdd" id="giaTienAdd">
                    </div>
                    <div class="form-group">
                        <label>NgayBatDau</label>
                        <input required type="date" class="form-control" name="ngayBatDauAdd" id="ngayBatDauAdd">
                    </div>
                    <div class="form-group">
                        <label>NgayKetThuc</label>
                        <input required type="date" class="form-control" name="ngayKetThucAdd" id="ngayKetThucAdd">
                    </div>

                    <div class="form-group">
                        <label for="loaiMatBangIdAdd">LoaiMatBang ID</label>
                        <select class="form-control" name="loaiMatBangIdAdd" id="loaiMatBangIdAdd">
                            <c:forEach var="loaiMatBang" items="${requestScope['loaiMatBangList']}">
                                <option value="${loaiMatBang.getLoaiMatBangId()}">${loaiMatBang.getLoaiMatBangTen()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="trangThaiIdAdd">TrangThai ID</label>
                        <select class="form-control" name="trangThaiIdAdd" id="trangThaiIdAdd">
                            <c:forEach var="trangThai" items="${requestScope['trangThaiList']}">
                                <option value="${trangThai.getTrangThaiId()}">${trangThai.getTrangThaiTen()}</option>
                            </c:forEach>
                        </select>
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

<!-- Delete Modal HTML -->
<div id="deleteMatBangModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_mat_bang?action=delete" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Delete MatBang</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>

                    <%--                    Input MatBang ID delete --%>
                    <input type="hidden" name="maMatBangDelete" id="maMatBangDelete">

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function setMatBangDelete(maMatBangDelete) {
        document.getElementById("maMatBangDelete").value = maMatBangDelete;
    }
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }

    $(document).ready(function () {
        // Activate tooltip
        // $('[data-toggle="tooltip"]').tooltip();

        // Pagination, Instant search, Multi-column ordering
        // https://datatables.net/
        $('#matBangTable').DataTable();
    });
</script>

</body>
</html>
