package controller;

import bo.EmployeeBO;
import bo.EmployeeBOImpl;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO = new EmployeeBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
//                showCreateForm(request, response);
                break;
            case "edit":
//                Bước 10: Phát triển tính năng cập nhật thông tin sản phẩm
//
//                Điều hướng hiển thị form cập nhật thông tin sản phẩm:

//                showEditForm(request, response);
                break;
            case "delete":
//                Bước 11: Phát triển tính năng xoá một sản phẩm

//                showDeleteForm(request, response);
                break;
            case "view":
//                Bước 12: Phát triển tính năng xem chi tiết một sản phẩm

//                viewEmployee(request,response);
                break;
            case "search-by-name":
//                searchEmployeeByNameForm(request, response);
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = this.employeeBO.selectAllEmployees();
        request.setAttribute("employees",employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/employee/list_employee.jsp");
    }
}
