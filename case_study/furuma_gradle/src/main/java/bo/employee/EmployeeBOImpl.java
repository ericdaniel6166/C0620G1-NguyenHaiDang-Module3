package bo.employee;

import dao.employee.EmployeeDAO;
import dao.employee.EmployeeDAOImpl;
import dto.employee.EmployeeDTO;
import model.employee.Employee;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<EmployeeDTO> listEmployee() {
        return this.employeeDAO.listEmployee();
    }

    @Override
    public List<EmployeeDTO> searchEmployeeByName(String employeeName) {
        return this.employeeDAO.searchEmployeeByName(employeeName);
    }

    @Override
    public Employee searchEmployeeById(Integer id) {
        return this.employeeDAO.searchEmployeeById(id);
    }

    @Override
    public boolean addEmployee(Employee employee) {

        return this.employeeDAO.addEmployee(employee);
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return this.employeeDAO.editEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        return this.employeeDAO.deleteEmployee(id);
    }


}
