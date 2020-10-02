package dao;

import model.Department;

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
                Integer departmentId = Integer.valueOf(resultSet.getString("department_id"));
                String departmentName = resultSet.getString("department_name");
                departmentList.add(new Department(departmentId, departmentName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Department searchDepartmentById(Integer id) {
        Department department = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_DEPARTMENT_NAME_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer departmentId = Integer.valueOf(resultSet.getString("department_id"));
                String departmentName = resultSet.getString("department_id");
                department = new Department(departmentId, departmentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
}
