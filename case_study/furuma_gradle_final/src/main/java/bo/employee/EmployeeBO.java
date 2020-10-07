package bo.employee;

import dto.employee.EmployeeDTO;
import model.employee.Employee;

import java.util.List;

public interface EmployeeBO {
    List<EmployeeDTO> listEmployee();

    String addEmployee(Employee employee);

    String editEmployee(Employee employee);

    String deleteEmployee(String id);

    Employee searchEmployeeById(String id);

    List<EmployeeDTO> searchEmployeeByName(String name);
}
