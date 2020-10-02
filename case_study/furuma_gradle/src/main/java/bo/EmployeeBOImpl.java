package bo;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeDAO.selectAllEmployees();
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return employeeDAO.selectEmployeeById(id);
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        return employeeDAO.insertEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}
