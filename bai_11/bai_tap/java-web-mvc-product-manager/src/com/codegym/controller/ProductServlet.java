package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

//        Bước 9: Phát triển tính năng thêm một khách hàng mới
//
//        Điều hướng việc hiển thị form tạo khách hàng mới:
        switch (action) {
            case "create":
//                showCreateForm(request, response);
                break;
            case "edit":
//                Bước 10: Phát triển tính năng cập nhật thông tin khách hàng
//
//                Điều hướng hiển thị form cập nhật thông tin khách hàng:

//                showEditForm(request, response);
                break;
            case "delete":
//                Bước 11: Phát triển tính năng xoá một khách hàng

//                showDeleteForm(request, response);
                break;
            case "view":
//                Bước 12: Phát triển tính năng xem chi tiết một khách hàng

//                viewCustomer(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
