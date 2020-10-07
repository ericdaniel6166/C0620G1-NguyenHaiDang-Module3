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
//            if (!Validator.regex(REGEX_NAME, employeeNameEdit)) {
//                message += "Invalid Name: Please input valid name. <br>";
//            }

            String positionIdEdit = (request.getParameter("positionIdEdit"));
            String levelIdEdit = (request.getParameter("levelIdEdit"));
            String departmentIdEdit = (request.getParameter("departmentIdEdit"));

            String dateOfBirthEdit = request.getParameter("dateOfBirthEdit");

            String idNumberEdit = request.getParameter("idNumberEdit");
//            if (!Validator.regex(REGEX_ID_NUMBER, idNumberEdit)) {
//                message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
//            }

            String salaryEditString = request.getParameter("salaryEdit");
//            Double salaryEdit = null;
//            if (!Validator.regex(REGEX_POSITIVE_NUMBER, salaryEditString)) {
//                message += "Invalid Salary: Salary is a positive number. <br>";
//            } else {
//                salaryEdit = Double.valueOf(salaryEditString);
//            }

            String phoneEdit = request.getParameter("phoneEdit");
//            if (!Validator.regex(REGEX_PHONE, phoneEdit)) {
//                message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
//            }

            String emailEdit = request.getParameter("emailEdit");
//            if (!Validator.regex(REGEX_EMAIL, emailEdit)) {
//                message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
//            }

            String addressEdit = request.getParameter("addressEdit");

                Employee employee = new Employee(employeeIdEdit, employeeNameEdit, positionIdEdit, levelIdEdit, departmentIdEdit, dateOfBirthEdit, idNumberEdit, salaryEditString, phoneEdit, emailEdit, addressEdit);
                message = this.employeeBO.editEmployee(employee);
//                message = "Employee was successfully edited.";

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
//            message = "Employee was successfully deleted.";

            request.setAttribute("message", message);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        //            Add
//            ******
//        boolean employeeAdded = false;
        String message = "";
        try {
            String employeeIdString = request.getParameter("employeeId");
//            String employeeId = null;
//            if (employeeIdString.equals("")) {
//                employeeId = null;
//            } else if (!Validator.regex(REGEX_POSITIVE_INTEGER, employeeIdString)) {
//                message += "Invalid Employee ID: Employee ID is a positive integer. <br>";
//            } else {
//                employeeId = (employeeIdString);
//                if (this.employeeBO.searchEmployeeById(employeeId) != null) {
//                    message += "Invalid Employee ID: Employee ID already exists. <br>";
//                }
//            }

            String employeeName = request.getParameter("employeeName");
//            if (!Validator.regex(REGEX_NAME, employeeName)) {
//                message += "Invalid name: Please input valid name (ex: An Binh). <br>";
//            }

            String positionId = (request.getParameter("positionId"));

            String levelId = (request.getParameter("levelId"));

            String departmentId = (request.getParameter("departmentId"));

            String dateOfBirth = request.getParameter("dateOfBirth");

            String idNumber = request.getParameter("idNumber");
//            if (!Validator.regex(REGEX_ID_NUMBER, idNumber)) {
//                message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
//            }

            String salaryString = request.getParameter("salary");
//            Double salary = null;
//            if (!Validator.regex(REGEX_POSITIVE_NUMBER, salaryString)) {
//                message += "Invalid Salary: Salary is a positive number. <br>";
//            } else {
//                salary = Double.valueOf(salaryString);
//            }

            String phone = request.getParameter("phone");
//            if (!Validator.regex(REGEX_PHONE, phone)) {
//                message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
//            }

            String email = request.getParameter("email");
//            if (!Validator.regex(REGEX_EMAIL, email)) {
//                message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
//            }

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
