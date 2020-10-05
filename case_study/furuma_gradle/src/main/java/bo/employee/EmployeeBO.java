package bo.employee;

import dto.employee.EmployeeDTO;
import model.employee.Employee;

import java.util.List;

public interface EmployeeBO {

    List<EmployeeDTO> listEmployee();

    Employee searchEmployeeById(Integer id);

    boolean addEmployee(Employee employee);

    boolean editEmployee(Employee employee);

    boolean deleteEmployee(Integer id);


    List<EmployeeDTO> searchEmployeeByName(String name);
}
