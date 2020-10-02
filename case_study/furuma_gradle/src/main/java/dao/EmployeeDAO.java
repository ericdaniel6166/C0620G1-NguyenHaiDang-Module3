package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> selectAllEmployees();

    Employee selectEmployeeById(int id);

    boolean insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int id);

}
