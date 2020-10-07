package dao.employee;

import dao.BaseDAO;
import model.employee.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    public static final String SELECT_DEPARTMENT_NAME_BY_ID = "SELECT department_id, department_name FROM departments where department_id = ? ;";
    public static final String SELECT_ALL_DEPARTMENTS = "SELECT * FROM departments;";
    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<Department> listDepartment() {
        List<Department> departmentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_DEPARTMENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String departmentId = (resultSet.getString("department_id"));
                String departmentName = resultSet.getString("department_name");
                Department department = new Department(departmentId, departmentName);
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Department searchDepartmentById(String id) {
        Department department = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_DEPARTMENT_NAME_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String departmentId = (resultSet.getString("department_id"));
                String departmentName = resultSet.getString("department_name");
                department = new Department(departmentId, departmentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
}
