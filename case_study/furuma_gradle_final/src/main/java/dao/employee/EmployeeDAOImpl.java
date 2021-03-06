package dao.employee;

import dao.BaseDAO;
import dto.employee.EmployeeDTO;
import model.employee.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    public static final String LIST_EMPLOYEE_VIEW = "SELECT * FROM view_employees;";
    private static final String INSERT_EMPLOYEE = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET employee_name = ?, position_id = ?, level_id = ?, department_id = ?, date_of_birth = ?, id_number = ?, salary = ?, phone = ?, email = ?, address = ? WHERE (employee_id = ?);";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE employee_id = ?;";

    private static final String SEARCH_EMPLOYEE_BY_ID_VIEW = "SELECT * FROM employees where employee_id = ?;";
    private static final String SEARCH_EMPLOYEE_BY_NAME_VIEW = "SELECT * FROM view_employees WHERE employee_name LIKE CONCAT('%',?,'%');";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<EmployeeDTO> listEmployee() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(LIST_EMPLOYEE_VIEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String employeeId = (resultSet.getString("employee_id"));
                String employeeName = resultSet.getString("employee_name");

                String positionId = (resultSet.getString("position_id"));
                String positionName = resultSet.getString("position_name");

                String levelId = (resultSet.getString("level_id"));
                String levelName = resultSet.getString("level_name");

                String departmentId = (resultSet.getString("department_id"));
                String departmentName = resultSet.getString("department_name");

                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                String salary = (resultSet.getString("salary"));
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                EmployeeDTO employeeDTO = new EmployeeDTO(employeeId, employeeName, positionId, positionName, levelId, levelName, departmentId, departmentName, dateOfBirth, idNumber, salary, phone, email, address);
                employeeDTOList.add(employeeDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeDTOList;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        boolean rowInsert = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_EMPLOYEE);
            String employeeId = employee.getEmployeeId();
            if (employeeId != "") {
                preparedStatement.setString(1, employeeId);
            } else {
                preparedStatement.setString(1, null);
            }

            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getPositionId());
            preparedStatement.setString(4, employee.getLevelId());
            preparedStatement.setString(5, employee.getDepartmentId());
            preparedStatement.setString(6, employee.getDateOfBirth());
            preparedStatement.setString(7, employee.getIdNumber());
            preparedStatement.setString(8, employee.getSalary());
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
            preparedStatement.setString(2, employee.getPositionId());
            preparedStatement.setString(3, employee.getLevelId());
            preparedStatement.setString(4, employee.getDepartmentId());
            preparedStatement.setString(5, employee.getDateOfBirth());
            preparedStatement.setString(6, employee.getIdNumber());
            preparedStatement.setString(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getEmployeeId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;

    }

    @Override
    public boolean deleteEmployee(String id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;

    }

    @Override
    public Employee searchEmployeeById(String id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_EMPLOYEE_BY_ID_VIEW);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String employeeId = (resultSet.getString("employee_id"));
                String employeeName = resultSet.getString("employee_name");
                String positionId = (resultSet.getString("position_id"));
                String levelId = (resultSet.getString("level_id"));
                String departmentId = (resultSet.getString("department_id"));
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                String salary = (resultSet.getString("salary"));
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                employee = new Employee(employeeId, employeeName, positionId, levelId, departmentId, dateOfBirth, idNumber, salary, phone, email, address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<EmployeeDTO> searchEmployeeByName(String name) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_EMPLOYEE_BY_NAME_VIEW);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String employeeId = (resultSet.getString("employee_id"));
                String employeeName = resultSet.getString("employee_name");

                String positionId = (resultSet.getString("position_id"));
                String positionName = resultSet.getString("position_name");

                String levelId = (resultSet.getString("level_id"));
                String levelName = resultSet.getString("level_name");

                String departmentId = (resultSet.getString("department_id"));
                String departmentName = resultSet.getString("department_name");

                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                String salary = (resultSet.getString("salary"));
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                employeeDTOList.add(new EmployeeDTO(employeeId, employeeName, positionId, positionName, levelId, levelName, departmentId, departmentName, dateOfBirth, idNumber, salary, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeDTOList;
    }


}
