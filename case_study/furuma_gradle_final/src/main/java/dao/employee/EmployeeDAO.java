package dao.employee;

import dto.employee.EmployeeDTO;
import model.employee.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<EmployeeDTO> listEmployee();

    boolean addEmployee(Employee employee);

    boolean editEmployee(Employee employee);

    boolean deleteEmployee(String id);

    Employee searchEmployeeById(String id);

    List<EmployeeDTO> searchEmployeeByName(String name);

}
