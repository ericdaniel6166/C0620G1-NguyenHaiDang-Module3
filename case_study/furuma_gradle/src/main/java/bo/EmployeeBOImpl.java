package bo;

import dao.*;
import dto.EmployeeDTO;
import model.*;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<Employee> listEmployeeTable() {
        return employeeDAO.listEmployeeTable();
    }

    @Override
    public List<EmployeeDTO> listEmployeeView() {
        return employeeDAO.listEmployeeView();
    }

    @Override
    public Employee searchEmployeeById(Integer id) {
        return employeeDAO.searchEmployeeById(id);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return employeeDAO.editEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        return employeeDAO.deleteEmployee(id);
    }


}
