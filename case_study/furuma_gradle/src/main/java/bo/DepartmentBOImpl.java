package bo;

import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import model.Department;

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
