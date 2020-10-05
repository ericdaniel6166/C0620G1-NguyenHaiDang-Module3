package bo.employee;

import dao.employee.DepartmentDAO;
import dao.employee.DepartmentDAOImpl;
import model.employee.Department;

import java.util.List;

public class DepartmentBOImpl implements DepartmentBO {
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public List<Department> listDepartment() {
        return this.departmentDAO.listDepartment();
    }

    @Override
    public Department searchDepartmentById(Integer id) {
        return departmentDAO.searchDepartmentById(id);
    }
}
