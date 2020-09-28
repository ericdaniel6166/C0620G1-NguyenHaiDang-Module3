package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
//    Bước 5: Tạo CustomerServlet để xử lý các request.
//
//    Lớp CustomerServlet có một đối tượng CustomerServiceImpl dùng để truy xuất đến dữ liệu.

    private CustomerService customerService = new CustomerServiceImpl();

//    Bước 6: Điều hướng việc xử lý các tính năng khác nhau của CustomerServlet thông qua tham số action

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                Bước 9:
//                Điều hướng việc xử lý lưu trữ khách hàng mới:
//                Phương thức createCustomer(request, response)
//                sẽ nhận về các tham số được gửi lên từ form,
//                    khởi tạo đối tượng Customer
//                và lưu trữ vào trong một danh sách khách hàng giả lập.

                createCustomer(request, response);

                break;
            case "edit":
//                Bước 10: Phát triển tính năng cập nhật thông tin khách hàng
//
//                Phương thức showEditForm(request, response)
//                sẽ tìm một khách hàng theo id được truyền vào.
//                Nếu khách hàng không tồn tại thì sẽ hiển thị thông báo lỗi.
//                Nếu khách hàng có tồn tại
//                thì hiển thị thông tin khách hàng lên một view là customer/edit.jsp:

                updateCustomer(request, response);
                break;
            case "delete":
//                Bước 11: Phát triển tính năng xoá một khách hàng

                deleteCustomer(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
//        Bước 11: Phát triển tính năng xoá một khách hàng

//        trỏ về delete form và thông báo đã xoá

        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer==null){
            dispatcher=request.getRequestDispatcher("error_404.jsp");
        }else {
            this.customerService.remove(id);
            request.setAttribute("customer", customer);
            request.setAttribute("message", "Customer information was deleted");
            dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

//        ********************
//            trỏ thẳng về customer list


//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer==null){
//            dispatcher=request.getRequestDispatcher("error_404.jsp");
//            try {
//                dispatcher.forward(request,response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            this.customerService.remove(id);
//            try {
//                response.sendRedirect("/customers");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
//        Bước 10: Phát triển tính năng cập nhật thông tin khách hàng
//
//        Phương thức showEditForm(request, response)
//        sẽ tìm một khách hàng theo id được truyền vào.
//        Nếu khách hàng không tồn tại thì sẽ hiển thị thông báo lỗi.
//                Nếu khách hàng có tồn tại
//        thì hiển thị thông tin khách hàng lên một view là customer/edit.jsp:

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            this.customerService.update(id, customer);
            request.setAttribute("customer", customer);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

//    Bước 9:
//    Điều hướng việc xử lý lưu trữ khách hàng mới:
//    Phương thức createCustomer(request, response)
//    sẽ nhận về các tham số được gửi lên từ form,
//    khởi tạo đối tượng Customer
//    và lưu trữ vào trong một danh sách khách hàng giả lập.

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
//        Tìm id của customer cuối list rồi cộng 1 bằng id của customer mới thêm vào
        int id = customerService.findAll().get(customerService.findAll().size() - 1).getId() + 1;
//        id của khách hàng mới là ngẫu nhiên
//        int id = (int)(Math.random() * 10000);

        Customer customer = new Customer(id, name, email, address);
        this.customerService.save(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message", "New customer was created");
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

//        Bước 9: Phát triển tính năng thêm một khách hàng mới
//
//        Điều hướng việc hiển thị form tạo khách hàng mới:
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
//                Bước 10: Phát triển tính năng cập nhật thông tin khách hàng
//
//                Điều hướng hiển thị form cập nhật thông tin khách hàng:

                showEditForm(request, response);
                break;
            case "delete":
//                Bước 11: Phát triển tính năng xoá một khách hàng

                showDeleteForm(request, response);
                break;
            case "view":
//                Bước 12: Phát triển tính năng xem chi tiết một khách hàng

                viewCustomer(request,response);
                break;
            default:
//                Bước 7: Phát triển tính năng hiển thị danh sách khách hàng
//
//                Điều hướng action hiển thị danh sách khách hàng
//                về phương thức listCustomers(request, response);

                listCustomer(request, response);
                break;
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
//        Bước 12: Phát triển tính năng xem chi tiết một khách hàng

        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer==null){
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        }else {
            request.setAttribute("customer",customer);
            dispatcher = request.getRequestDispatcher("customer/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        Bước 11: Phát triển tính năng xoá một khách hàng

        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

//    Bước 10: Phát triển tính năng cập nhật thông tin khách hàng
//
//    Điều hướng hiển thị form cập nhật thông tin khách hàng:

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
//        Bước 10: Phát triển tính năng cập nhật thông tin khách hàng

//        Phương thức showEditForm(request, response)
//        sẽ tìm một khách hàng theo id được truyền vào.
//        Nếu khách hàng không tồn tại thì sẽ hiển thị thông báo lỗi.
//        Nếu khách hàng có tồn tại thì hiển thị thông tin khách hàng
//        lên một view là customer/edit.jsp:

        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

//    Bước 9: Phát triển tính năng thêm một khách hàng mới
//
//    Điều hướng việc hiển thị form tạo khách hàng mới:

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
//        Bước 9:
//        Phương thức showCreateForm(request, response);
//        sẽ trả về một form được định nghĩa trong view customer/create.jsp:
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

//    Bước 7: Phát triển tính năng hiển thị danh sách khách hàng
//
//    Điều hướng action hiển thị danh sách khách hàng
//    về phương thức listCustomers(request, response);
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

//        try {
//            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }
}
