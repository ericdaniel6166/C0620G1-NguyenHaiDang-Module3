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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                Bước 9:
//                Điều hướng việc xử lý lưu trữ sản phẩm mới:
//                Phương thức createProduct(request, response)
//                sẽ nhận về các tham số được gửi lên từ form,
//                    khởi tạo đối tượng Product
//                và lưu trữ vào trong một danh sách sản phẩm giả lập.

                createProduct(request, response);

                break;
            case "edit":
//                Bước 10: Phát triển tính năng cập nhật thông tin sản phẩm
//
//                Phương thức showEditForm(request, response)
//                sẽ tìm một sản phẩm theo id được truyền vào.
//                Nếu sản phẩm không tồn tại thì sẽ hiển thị thông báo lỗi.
//                Nếu sản phẩm có tồn tại
//                thì hiển thị thông tin sản phẩm lên một view là product/edit.jsp:

                updateProduct(request, response);
                break;
            case "delete":
//                Bước 11: Phát triển tính năng xoá một sản phẩm

                deleteProduct(request,response);
                break;
            case "search-by-name":
                searchProductByName(request,response);
            default:
                break;
        }
    }

    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

        List<Product> products= this.productService.findByName(name);

        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
//        Bước 11: Phát triển tính năng xoá một sản phẩm

//        trỏ về delete form và thông báo đã xoá

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null){
            dispatcher=request.getRequestDispatcher("error_404.jsp");
        }else {
            this.productService.remove(id);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was deleted");
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

//        ********************
//            trỏ thẳng về product list


//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = this.productService.findById(id);
//        RequestDispatcher dispatcher;
//        if (product==null){
//            dispatcher=request.getRequestDispatcher("error_404.jsp");
//            try {
//                dispatcher.forward(request,response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            this.productService.remove(id);
//            try {
//                response.sendRedirect("/products");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
//        Bước 10: Phát triển tính năng cập nhật thông tin sản phẩm
//
//        Phương thức showEditForm(request, response)
//        sẽ tìm một sản phẩm theo id được truyền vào.
//        Nếu sản phẩm không tồn tại thì sẽ hiển thị thông báo lỗi.
//                Nếu sản phẩm có tồn tại
//        thì hiển thị thông tin sản phẩm lên một view là product/edit.jsp:

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");

        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setProducer(producer);
            this.productService.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

//    Bước 9:
//    Điều hướng việc xử lý lưu trữ sản phẩm mới:
//    Phương thức createProduct(request, response)
//    sẽ nhận về các tham số được gửi lên từ form,
//    khởi tạo đối tượng Product
//    và lưu trữ vào trong một danh sách sản phẩm giả lập.

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
//        Tìm id của product cuối list rồi cộng 1 bằng id của product mới thêm vào
        int id = productService.findAll().get(productService.findAll().size() - 1).getId() + 1;
//        id của sản phẩm mới là ngẫu nhiên
//        int id = (int)(Math.random() * 10000);

        Product product = new Product(id, name,price, description, producer);
        this.productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New product was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

//        Bước 9: Phát triển tính năng thêm một sản phẩm mới
//
//        Điều hướng việc hiển thị form tạo sản phẩm mới:
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
//                Bước 10: Phát triển tính năng cập nhật thông tin sản phẩm
//
//                Điều hướng hiển thị form cập nhật thông tin sản phẩm:

                showEditForm(request, response);
                break;
            case "delete":
//                Bước 11: Phát triển tính năng xoá một sản phẩm

                showDeleteForm(request, response);
                break;
            case "view":
//                Bước 12: Phát triển tính năng xem chi tiết một sản phẩm

                viewProduct(request,response);
                break;
            case "search-by-name":
                searchProductByNameForm(request, response);
            default:
                listProduct(request, response);
                break;
        }
    }

    private void searchProductByNameForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/search_by_name.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
//        Bước 12: Phát triển tính năng xem chi tiết một sản phẩm

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product==null){
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        }else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        Bước 11: Phát triển tính năng xoá một sản phẩm

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

//    Bước 10: Phát triển tính năng cập nhật thông tin sản phẩm
//
//    Điều hướng hiển thị form cập nhật thông tin sản phẩm:

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
//        Bước 10: Phát triển tính năng cập nhật thông tin sản phẩm

//        Phương thức showEditForm(request, response)
//        sẽ tìm một sản phẩm theo id được truyền vào.
//        Nếu sản phẩm không tồn tại thì sẽ hiển thị thông báo lỗi.
//        Nếu sản phẩm có tồn tại thì hiển thị thông tin sản phẩm
//        lên một view là product/edit.jsp:

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

//    Bước 9: Phát triển tính năng thêm một sản phẩm mới
//
//    Điều hướng việc hiển thị form tạo sản phẩm mới:

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
//        Bước 9:
//        Phương thức showCreateForm(request, response);
//        sẽ trả về một form được định nghĩa trong view product/create.jsp:
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
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
