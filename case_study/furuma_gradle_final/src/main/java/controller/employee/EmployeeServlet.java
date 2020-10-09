package controller.employee;

import bo.employee.*;
import dto.employee.EmployeeDTO;
import model.employee.Department;
import model.employee.Employee;
import model.employee.Level;
import model.employee.Position;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/list_employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeBO employeeBO = new EmployeeBOImpl();
    private PositionBO positionBO = new PositionBOImpl();
    private LevelBO levelBO = new LevelBOImpl();
    private DepartmentBO departmentBO = new DepartmentBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addEmployee(request, response);
                listEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                listEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                listEmployee(request, response);
                break;
            case "search_by_name":
                searchEmployeeByName(request, response);
            default:
                break;
        }
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) {
        boolean employeeSearched = false;
        String message = "";
        List<EmployeeDTO> employeeDTOList = null;
        try {
            String employeeNameSearch = request.getParameter("employeeNameSearch");
            employeeDTOList = this.employeeBO.searchEmployeeByName(employeeNameSearch);
            if (employeeDTOList == null) {
                message += "Employee Name " + '"' + employeeNameSearch + '"' + " is not found";
            } else {
                message = "Employee Name " + '"' + employeeNameSearch + '"';
            }

            request.setAttribute("employeeDTOList", employeeDTOList);
            request.setAttribute("message", message);

            List<Position> positionList = this.positionBO.listPosition();
            request.setAttribute("positionList", positionList);

            List<Level> levelList = this.levelBO.listLevel();
            request.setAttribute("levelList", levelList);

            List<Department> departmentList = this.departmentBO.listDepartment();
            request.setAttribute("departmentList", departmentList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list_employee.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            String employeeIdEdit = (request.getParameter("employeeIdEdit"));

            String employeeNameEdit = request.getParameter("employeeNameEdit");

            String positionIdEdit = (request.getParameter("positionIdEdit"));
            String levelIdEdit = (request.getParameter("levelIdEdit"));
            String departmentIdEdit = (request.getParameter("departmentIdEdit"));

            String dateOfBirthEdit = request.getParameter("dateOfBirthEdit");

            String idNumberEdit = request.getParameter("idNumberEdit");

            String salaryEditString = request.getParameter("salaryEdit");

            String phoneEdit = request.getParameter("phoneEdit");

            String emailEdit = request.getParameter("emailEdit");

            String addressEdit = request.getParameter("addressEdit");

            Employee employee = new Employee(employeeIdEdit, employeeNameEdit, positionIdEdit, levelIdEdit, departmentIdEdit, dateOfBirthEdit, idNumberEdit, salaryEditString, phoneEdit, emailEdit, addressEdit);
            message = this.employeeBO.editEmployee(employee);

            request.setAttribute("message", message);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            String employeeIdDelete = (request.getParameter("employeeIdDelete"));
            message = this.employeeBO.deleteEmployee(employeeIdDelete);

            request.setAttribute("message", message);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            String employeeIdString = request.getParameter("employeeId");

            String employeeName = request.getParameter("employeeName");

            String positionId = (request.getParameter("positionId"));

            String levelId = (request.getParameter("levelId"));

            String departmentId = (request.getParameter("departmentId"));

            String dateOfBirth = request.getParameter("dateOfBirth");

            String idNumber = request.getParameter("idNumber");

            String salaryString = request.getParameter("salary");

            String phone = request.getParameter("phone");

            String email = request.getParameter("email");

            String address = request.getParameter("address");

            Employee employee = new Employee(employeeIdString, employeeName, positionId, levelId, departmentId, dateOfBirth, idNumber, salaryString, phone, email, address);
            message = this.employeeBO.addEmployee(employee);

            request.setAttribute("message", message);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
//                showAddForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
                break;
            case "view":
//                viewEmployee(request,response);
                break;

            default:
                listEmployee(request, response);
                break;
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<EmployeeDTO> employeeDTOList = this.employeeBO.listEmployee();
            request.setAttribute("employeeDTOList", employeeDTOList);

            List<Position> positionList = this.positionBO.listPosition();
            request.setAttribute("positionList", positionList);

            List<Level> levelList = this.levelBO.listLevel();
            request.setAttribute("levelList", levelList);

            List<Department> departmentList = this.departmentBO.listDepartment();
            request.setAttribute("departmentList", departmentList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list_employee.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
