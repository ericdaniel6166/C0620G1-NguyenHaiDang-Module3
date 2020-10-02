package bo;

import dto.EmployeeDTO;
import model.Employee;
import model.EmployeeView;

import java.util.List;

public interface EmployeeBO {
    List<Employee> listEmployeeTable();

    List<EmployeeDTO> listEmployeeView();

    Employee searchEmployeeById(Integer id);

    boolean addEmployee(Employee employee);

    boolean editEmployee(Employee employee);

    boolean deleteEmployee(Integer id);



}
