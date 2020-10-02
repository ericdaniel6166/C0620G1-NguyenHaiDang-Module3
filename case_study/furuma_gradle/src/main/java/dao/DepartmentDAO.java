package dao;

import model.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> listDepartment();
    Department searchDepartmentById(Integer id);
}
