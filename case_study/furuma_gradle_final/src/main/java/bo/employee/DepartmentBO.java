package bo.employee;

import model.employee.Department;

import java.util.List;

public interface DepartmentBO {
    List<Department> listDepartment();

    Department searchDepartmentById(String id);
}
