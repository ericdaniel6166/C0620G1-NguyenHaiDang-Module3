package dao.employee;

import dto.employee.EmployeeDTO;
import model.employee.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<EmployeeDTO> listEmployee();

    boolean addEmployee(Employee employee);

    boolean editEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    Employee searchEmployeeById(Integer id);

    List<EmployeeDTO> searchEmployeeByName(String name);

}
