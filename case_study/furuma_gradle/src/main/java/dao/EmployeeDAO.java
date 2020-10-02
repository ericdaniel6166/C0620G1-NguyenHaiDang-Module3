package dao;

import dto.EmployeeDTO;
import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> listEmployeeTable();
    List<EmployeeDTO> listEmployeeView();

    Employee searchEmployeeById(Integer id);

    boolean addEmployee(Employee employee);

    boolean editEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

}
