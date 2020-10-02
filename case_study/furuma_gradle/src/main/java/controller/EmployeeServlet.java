package controller;

import bo.*;
import dto.EmployeeDTO;
import model.Department;
import model.Employee;
import model.Level;
import model.Position;

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
    PositionBO positionBO = new PositionBOImpl();
    LevelBO levelBO = new LevelBOImpl();
    DepartmentBO departmentBO = new DepartmentBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addEmployee(request, response);
                listEmployeeView(request, response);
                break;
            case "edit":
//                Bước 10: Phát triển tính năng cập nhật thông tin sản phẩm
//
//                Phương thức showEditForm(request, response)
//                sẽ tìm một sản phẩm theo id được truyền vào.
//                Nếu sản phẩm không tồn tại thì sẽ hiển thị thông báo lỗi.
//                Nếu sản phẩm có tồn tại
//                thì hiển thị thông tin sản phẩm lên một view là employee/edit.jsp:

//                updateEmployee(request, response);
                break;
            case "delete":
//                Bước 11: Phát triển tính năng xoá một sản phẩm

//                deleteEmployee(request,response);
                break;
            case "search_by_name":
//                searchEmployeeByName(request,response);
            default:
                listEmployeeView(request, response);
                break;
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {


//        //            Add
////            ******
//        String employeeIdString = request.getParameter("employeeId");
//        Integer employeeId = null;
//        if (employeeIdString != null) {
//            employeeId = Integer.valueOf(employeeIdString);
//        }
//        String employeeName = request.getParameter("employeeName");
//
//        String positionIdString = request.getParameter("positionId");
//        String positionId = null;
//        if (positionIdString != null) {
//            positionId = Integer.valueOf(positionIdString);
//        }
//
//        String levelIdString = request.getParameter("levelId");
//        String levelId = null;
//        if (levelIdString!=null){
//            levelId = Integer.valueOf(levelIdString);
//        }
//
//        String departmentIdString = request.getParameter("departmentId");
//        String departmentId = null;
//        if (departmentIdString!=null){
//            departmentId = Integer.valueOf(departmentIdString);
//        }
//
//        String dateOfBirth = request.getParameter("dateOfBirth");
//        String idNumber = request.getParameter("idNumber");
//
//        String salaryString = request.getParameter("salary");
//        Double salary = null;
//        if (salaryString!=null){
//            salary = Double.valueOf(salaryString);
//        }
//
//        String phone = request.getParameter("phone");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        Employee employee = new Employee(employeeId, employeeName, positionId, levelId, departmentId, dateOfBirth, idNumber, salary, phone, email, address);
//        this.employeeBO.addEmployee(employee);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

//        Bước 9: Phát triển tính năng thêm một sản phẩm mới
//
//        Điều hướng việc hiển thị form tạo sản phẩm mới:
        switch (action) {
            case "add":
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
            case "search_by_name":
//                searchEmployeeByNameForm(request, response);
            default:
//                listEmployeeTable(request, response);
                listEmployeeView(request, response);
                break;
        }
    }

    private void listEmployeeView(HttpServletRequest request, HttpServletResponse response) {
        try {

            List<EmployeeDTO> employeeDTOList = this.employeeBO.listEmployeeView();
            request.setAttribute("employeeDTOList", employeeDTOList);

            List<Position> positionList = this.positionBO.listPosition();
            request.setAttribute("positionList",positionList);

            List<Level> levelList = this.levelBO.listLevel();
            request.setAttribute("levelList",levelList);

            List<Department> departmentList = this.departmentBO.listDepartment();
            request.setAttribute("departmentList",departmentList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list_employee_view.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployeeTable(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Employee> employeeList = this.employeeBO.listEmployeeTable();
            request.setAttribute("employeeList", employeeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list_employee_table.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
