package dao;

import dto.EmployeeDTO;
import model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    public static final String SELECT_ALL_EMPLOYEES_VIEW = "SELECT * FROM view_employees;";
    public static final String SELECT_ALL_EMPLOYEES_TABLE = "SELECT * FROM employees;";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employees where employee_id = ?;";
    private static final String INSERT_EMPLOYEE = "INSERT INTO employees (employee_id, employee_name, position_id, level_id, department_id, date_of_birth, id_number, salary, phone, email, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET employee_name = ?, position_id = ?, level_id = ?, department_id = ?, date_of_birth = ?, id_number = ?, salary = ?, phone = ?, email = ?, address = ? WHERE (employee_id = ?);";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE employee_id = ?;";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<Employee> listEmployeeTable() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_EMPLOYEES_TABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee;
            while (resultSet.next()) {
                Integer employeeId = Integer.valueOf(resultSet.getString("employee_id"));
                String employeeName = resultSet.getString("employee_name");
                Integer positionId = Integer.valueOf(resultSet.getString("position_id"));
                Integer levelId = Integer.valueOf(resultSet.getString("level_id"));
                Integer departmentId = Integer.valueOf(resultSet.getString("department_id"));
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                double salary = Double.parseDouble(resultSet.getString("salary"));
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                employee = new Employee(employeeId, employeeName, positionId, levelId, departmentId, dateOfBirth, idNumber, salary, phone, email, address);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<EmployeeDTO> listEmployeeView() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_EMPLOYEES_VIEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer employeeId = Integer.valueOf(resultSet.getString("employee_id"));
                String employeeName = resultSet.getString("employee_name");

                String positionName = resultSet.getString("position_name");
                String levelName = resultSet.getString("level_name");
                String departmentName = resultSet.getString("department_name");

                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                double salary = Double.parseDouble(resultSet.getString("salary"));
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                employeeDTOList.add(new EmployeeDTO(employeeId, employeeName, positionName, levelName, departmentName, dateOfBirth, idNumber, salary, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeDTOList;
    }

    @Override
    public Employee searchEmployeeById(Integer id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer employeeId = Integer.valueOf(resultSet.getString("employee_id"));
                String employeeName = resultSet.getString("employee_name");
                Integer positionId = Integer.valueOf(resultSet.getString("position_id"));
                Integer levelId = Integer.valueOf(resultSet.getString("level_id"));
                Integer departmentId = Integer.valueOf(resultSet.getString("department_id"));
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                double salary = Double.parseDouble(resultSet.getString("salary"));
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("String");
                String address = resultSet.getString("address");
                employee = new Employee(employeeId, employeeName, positionId, levelId, departmentId, dateOfBirth, idNumber, salary, phone, email, address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        boolean rowInsert = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setInt(3, employee.getPositionId());
            preparedStatement.setInt(4, employee.getLevelId());
            preparedStatement.setInt(5, employee.getDepartmentId());
            preparedStatement.setString(6, employee.getDateOfBirth());
            preparedStatement.setString(7, employee.getIdNumber());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setString(9, employee.getPhone());
            preparedStatement.setString(10, employee.getEmail());
            preparedStatement.setString(11, employee.getAddress());
            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean editEmployee(Employee employee) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setInt(2, employee.getPositionId());
            preparedStatement.setInt(3, employee.getLevelId());
            preparedStatement.setInt(4, employee.getDepartmentId());
            preparedStatement.setString(5, employee.getDateOfBirth());
            preparedStatement.setString(6, employee.getIdNumber());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setInt(11, employee.getEmployeeId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;

    }

    @Override
    public boolean deleteEmployee(Integer id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;

    }
}
