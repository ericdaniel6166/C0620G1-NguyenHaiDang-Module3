package bo;

import model.Department;

import java.util.List;

public interface DepartmentBO {
    List<Department> listDepartment();
    Department searchDepartmentById(Integer id);
}
