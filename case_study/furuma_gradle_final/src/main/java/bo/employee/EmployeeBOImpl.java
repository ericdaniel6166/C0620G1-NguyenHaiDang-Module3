package bo.employee;


import common.Validator;
import dao.employee.EmployeeDAO;
import dao.employee.EmployeeDAOImpl;
import dto.employee.EmployeeDTO;
import model.employee.Employee;

import java.util.List;

import static common.Validator.*;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<EmployeeDTO> listEmployee() {
        return this.employeeDAO.listEmployee();
    }

    @Override
    public String addEmployee(Employee employee) {
        String message = "";
        boolean employeeAdded = false;
        if (employee.getEmployeeId() != null && !Validator.regex(REGEX_SERVICE_NAME, employee.getEmployeeId())) {
            message += "Invalid Employee ID: Employee ID is a positive integer. <br>";
        }
        if (this.searchEmployeeById(employee.getEmployeeId()) != null) {
            message += "Invalid Employee ID: Employee ID already exists. <br>";
        }
        if (!Validator.regex(REGEX_PERSON_NAME, employee.getEmployeeName())) {
            message += "Invalid name: Please input valid name (ex: An Binh). <br>";
        }
        if (!Validator.regex(REGEX_ID_NUMBER, employee.getIdNumber())) {
            message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_NUMBER, employee.getSalary())) {
            message += "Invalid Salary: Salary is a positive number. <br>";
        }
        if (!Validator.regex(REGEX_PHONE, employee.getPhone())) {
            message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
        }
        if (!Validator.regex(REGEX_EMAIL, employee.getEmail())) {
            message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
        }
        if ("".equals(message)) {
            employeeAdded = this.employeeDAO.addEmployee(employee);
            message = "Employee was successfully added.";
        }
        return message;
    }

    @Override
    public String editEmployee(Employee employee) {
        String message = "";
        boolean employeeEdited = false;

        if (!Validator.regex(REGEX_PERSON_NAME, employee.getEmployeeName())) {
            message += "Invalid Name: Please input valid name. <br>";
        }
        if (!Validator.regex(REGEX_ID_NUMBER, employee.getIdNumber())) {
            message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
        }
        Double salaryEdit = null;
        if (!Validator.regex(REGEX_POSITIVE_NUMBER, employee.getSalary())) {
            message += "Invalid Salary: Salary is a positive number. <br>";
        }
        if (!Validator.regex(REGEX_PHONE, employee.getPhone())) {
            message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
        }
        if (!Validator.regex(REGEX_EMAIL, employee.getEmail())) {
            message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
        }
        if ("".equals(message)) {
            employeeEdited = this.employeeDAO.editEmployee(employee);
            message = "Employee was successfully edited.";
        }
        return message;
    }

    @Override
    public String deleteEmployee(String id) {
        String message = "";
        boolean employeeDeleted = false;
        employeeDeleted = this.employeeDAO.deleteEmployee(id);
        message = "Employee was successfully deleted.";
        return message;
    }

    @Override
    public Employee searchEmployeeById(String id) {
        return this.employeeDAO.searchEmployeeById(id);
    }

    @Override
    public List<EmployeeDTO> searchEmployeeByName(String employeeName) {
        return this.employeeDAO.searchEmployeeByName(employeeName);
    }


}
