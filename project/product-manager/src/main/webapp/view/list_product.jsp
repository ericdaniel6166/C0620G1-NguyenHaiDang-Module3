<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/09/2020
  Time: 9:30 AM
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
            category: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            category: absolute;
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
            category: absolute;
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

    <%--        search all--%>
    <div class="row">
        <div class="col-12 ">
            <div class="search-box">
                <form action="/list_product?action=search" method="post">
                    <div class="row float-right">
                        <div class="col-4">
                            <input type="text" class="form-control" name="productNameSearch" id="productNameSearch"
                                   placeholder="productNameSearch">
                        </div>
                        <div class="col-4">
                            <input type="text" class="form-control" name="priceSearch" id="priceSearch"
                                   placeholder="priceSearch">
                        </div>
                        <div class="col-4">
                            <input type="text" class="form-control" name="quantitySearch" id="quantitySearch"
                                   placeholder="quantitySearch">
                        </div>
                        <div class="col-4">
                            <input type="text" class="form-control" name="descriptionSearch" id="descriptionSearch"
                                   placeholder="descriptionSearch">
                        </div>
                        <div class="col-4">
                            <input type="text" class="form-control" name="categoryNameSearch" id="categoryNameSearch"
                                   placeholder="categoryNameSearch">
                        </div>
                        <div class="col-4">
                            <input type="text" class="form-control" name="colorNameSearch" id="colorNameSearch"
                                   placeholder="colorNameSearch">
                        </div>

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

    <%--    search-box--%>
    <div class="row">
        <div class="col-12">
            <div class="search-box">
                <form action="/list_product?action=search_by_name" method="post">
                    <div class="row">
                        <input type="text" name="productNameSearchByName" id="productNameSearchByName"
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
                                <h2><b>Product List</b></h2>
                            </div>
                            <div class="col-sm-9 ">
                                <!--						href  đến form add new -->
                                <a href="#addProductModal" class="btn btn-success" data-toggle="modal">
                                    <i class="material-icons">add_circle</i> <span>Add New Product</span></a>
                                <!--						href đến confirm delete-->
                                <%--                        <a href="#deleteProductModal" class="btn btn-danger" data-toggle="modal"><i--%>
                                <%--                                class="material-icons">remove_circle</i> <span>Delete</span></a>--%>
                                <a href="/list_product?action=list" class="btn btn-info">
                                    <i class="material-icons">view_list</i>
                                    <span>Product List</span>
                                </a>
                                <a href="../../index.jsp" class="btn btn-primary">
                                    <i class="material-icons">home</i>
                                    <span>Home</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover" id="productTable">
                        <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Category Name</th>
                            <th>Color Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="productDTO" items='${requestScope["productDTOList"]}'>
                            <tr>
                                <td>${productDTO.getProductId()}</td>
                                <td>
                                    <a href="#viewProductModal" data-toggle="modal"
                                       onclick="setProductView(
                                               '${productDTO.getProductId()}',
                                               '${productDTO.getProductName()}',
                                               '${productDTO.getCategoryName()}',
                                               '${productDTO.getColorName()}',
                                               '${productDTO.getPrice()}',
                                               '${productDTO.getQuantity()}'
                                               )"
                                    >
                                        <div data-toggle="tooltip" title="View">
                                                ${productDTO.getProductName()}
                                        </div>
                                    </a>
                                </td>
                                <td>${productDTO.getCategoryName()}</td>
                                <td>${productDTO.getColorName()}</td>
                                <td>${productDTO.getPrice()}</td>
                                <td>${productDTO.getQuantity()}</td>
                                <td>
                                    <a href="#editProductModal" class="edit" data-toggle="modal"
                                       onclick="setProductEdit(
                                               '${productDTO.getProductId()}',
                                               '${productDTO.getProductName()}',
                                               '${productDTO.getCategoryId()}',
                                               '${productDTO.getColorId()}',
                                               '${productDTO.getPrice()}',
                                               '${productDTO.getQuantity()}',
                                               )">
                                        <i class="material-icons" data-toggle="tooltip" title="Edit">mode_edit</i>
                                    </a>
                                    <a href="#deleteProductModal" class="delete" data-toggle="modal"
                                       onclick="setProductDelete('${productDTO.getProductId()}')">
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
<div id="addProductModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_product?action=add" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="productIdAdd">Product ID</label>
                        <input type="text" class="form-control" name="productIdAdd" id="productIdAdd">
                    </div>
                    <div class="form-group">
                        <label for="productNameAdd">Product Name</label>
                        <input type="text" class="form-control" name="productNameAdd" id="productNameAdd">
                    </div>
                    <div class="form-group">
                        <label for="categoryIdAdd">Category ID</label>
                        <select class="form-control" name="categoryIdAdd" id="categoryIdAdd">
                            <c:forEach var="category" items="${requestScope['categoryList']}">
                                <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="colorIdAdd">Color ID</label>
                        <select class="form-control" name="colorIdAdd" id="colorIdAdd">
                            <c:forEach var="color" items="${requestScope['colorList']}">
                                <option value="${color.getColorId()}">${color.getColorName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="text" class="form-control" name="priceAdd" id="priceAdd">
                    </div>
                    <div class="form-group">
                        <label>Quantity</label>
                        <input type="text" class="form-control" name="quantityAdd" id="quantityAdd">
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" class="form-control" name="descriptionAdd" id="descriptionAdd">
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
<div id="editProductModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_product?action=edit" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <%--                        <label for="productIdEdit">Product ID</label>--%>
                        <input type="hidden" class="form-control" name="productIdEdit" id="productIdEdit">
                    </div>
                    <div class="form-group">
                        <label for="productNameEdit">Product Name</label>
                        <input type="text" class="form-control" name="productNameEdit" id="productNameEdit">
                    </div>
                    <div class="form-group">
                        <label for="categoryIdEdit">Category ID</label>
                        <select class="form-control" name="categoryIdEdit" id="categoryIdEdit">
                            <c:forEach var="category" items="${requestScope['categoryList']}">
                                <option value="${category.getCategoryId()}">
                                        ${category.getCategoryName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="colorIdEdit">Color ID</label>
                        <select class="form-control" name="colorIdEdit" id="colorIdEdit">
                            <c:forEach var="color" items="${requestScope['colorList']}">
                                <option value="${color.getColorId()}">
                                        ${color.getColorName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="priceEdit">Price</label>
                        <input type="text" class="form-control" name="priceEdit" id="priceEdit">
                    </div>
                    <div class="form-group">
                        <label for="quantityEdit">Quantity</label>
                        <input type="text" class="form-control" name="quantityEdit" id="quantityEdit">
                    </div>
                    <div class="form-group">
                        <label for="descriptionEdit">descriptionEdit</label>
                        <input type="text" class="form-control" name="descriptionEdit" id="descriptionEdit">
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
<div id="deleteProductModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/list_product?action=delete" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>

                    <%--                    Input Product ID delete --%>
                    <input type="hidden" name="productIdDelete" id="productIdDelete">

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
<div id="viewProductModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Product Information</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-6"><p>Product ID:</p></div>
                    <div class="col-6"><p id="productIdView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>Product Name:</p></div>
                    <div class="col-6"><p id="productNameView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>Category Name:</p></div>
                    <div class="col-6"><p id="categoryNameView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>Color Name:</p></div>
                    <div class="col-6"><p id="colorNameView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>Price:</p></div>
                    <div class="col-6"><p id="priceView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>Quantity:</p></div>
                    <div class="col-6"><p id="quantityView"></p></div>
                </div>
                <div class="row">
                    <div class="col-6"><p>descriptionView</p></div>
                    <div class="col-6"><p id="descriptionView"></p></div>
                </div>

            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
            </div>
        </div>
    </div>
</div>

<script>
    function setProductView(productId, productName, categoryName, colorName, price, quantity, description) {
        document.getElementById("productIdView").innerHTML = productId;
        document.getElementById("productNameView").innerHTML = productName;

        document.getElementById("categoryNameView").innerHTML = categoryName;
        document.getElementById("colorNameView").innerHTML = colorName;

        document.getElementById("priceView").innerHTML = price;
        document.getElementById("quantityView").innerHTML = quantity;
        document.getElementById("descriptionView").innerHTML = description;
    }

    // Xoá lịch sử lưu trên add modal
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }


    function setProductEdit(productId, productName, categoryId, colorId, price, quantity, description) {
        document.getElementById("productIdEdit").value = productId;
        document.getElementById("productNameEdit").value = productName;

        document.getElementById('categoryIdEdit').value = categoryId;
        document.getElementById('colorIdEdit').value = colorId;

        document.getElementById("priceEdit").value = price;
        document.getElementById("quantityEdit").value = quantity;
        document.getElementById("descriptionEdit").value = description;
    }

    function setProductDelete(productIdDelete) {
        document.getElementById("productIdDelete").value = productIdDelete;
    }

    $(document).ready(function () {
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Pagination, Instant search, Multi-column ordering
        // https://datatables.net/
        $('#productTable').DataTable();
    });
</script>

</body>
</html>
