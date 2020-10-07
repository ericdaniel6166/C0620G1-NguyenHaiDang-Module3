package dao.customer;

import dao.BaseDAO;
import dto.customer.CustomerDTO;
import model.customer.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String LIST_CUSTOMER_VIEW = "SELECT * FROM view_customers;";
    private static final String INSERT_CUSTOMER = "INSERT INTO customers VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_CUSTOMER = "UPDATE customers SET  type_of_customer_id = ?,  customer_name = ?, date_of_birth = ?, id_number = ?, phone = ?, email = ?, address = ?  WHERE customer_id = ?;";
    private static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE customer_id = ?;";

    private static final String SEARCH_CUSTOMER_BY_ID_VIEW = "SELECT * FROM view_customers WHERE customer_id = ?;";
    private static final String SEARCH_CUSTOMER_BY_NAME_VIEW = "SELECT * FROM view_customers WHERE customer_name LIKE CONCAT('%',?,'%');";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<CustomerDTO> listCustomer() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(LIST_CUSTOMER_VIEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerId = String.valueOf(resultSet.getString("customer_id"));

                String typeOfCustomerId = String.valueOf(resultSet.getString("type_of_customer_id"));
                String typeOfCustomerName = resultSet.getString("type_name");

                String customerName = resultSet.getString("customer_name");

                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                CustomerDTO customerDTO = new CustomerDTO(customerId, typeOfCustomerId, typeOfCustomerName, customerName, dateOfBirth, idNumber, phone, email, address);
                customerDTOList.add(customerDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerDTOList;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        boolean rowInsert = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_CUSTOMER);
            String customerId = customer.getCustomerId();
            if (customerId != null) {
                preparedStatement.setString(1, customerId);
            } else {
                preparedStatement.setString(1, null);
            }

            preparedStatement.setString(2, customer.getTypeOfCustomerId());

            preparedStatement.setString(3, customer.getCustomerName());

            preparedStatement.setString(4, customer.getDateOfBirth());
            preparedStatement.setString(5, customer.getIdNumber());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, customer.getTypeOfCustomerId());

            preparedStatement.setString(2, customer.getCustomerName());

            preparedStatement.setString(3, customer.getDateOfBirth());
            preparedStatement.setString(4, customer.getIdNumber());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setString(8, customer.getCustomerId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteCustomer(String id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public CustomerDTO searchCustomerById(String id) {
        CustomerDTO customerDTO = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_CUSTOMER_BY_ID_VIEW);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerId = String.valueOf(resultSet.getString("customer_id"));

                String typeOfCustomerId = String.valueOf(resultSet.getString("type_of_customer_id"));
                String typeOfCustomerName = resultSet.getString("type_name");

                String customerName = resultSet.getString("customer_name");

                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customerDTO = new CustomerDTO(customerId, typeOfCustomerId, typeOfCustomerName, customerName, dateOfBirth, idNumber, phone, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> searchCustomerByName(String name) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_CUSTOMER_BY_NAME_VIEW);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerId = String.valueOf(resultSet.getString("customer_id"));

                String typeOfCustomerId = String.valueOf(resultSet.getString("type_of_customer_id"));
                String typeOfCustomerName = resultSet.getString("type_name");

                String customerName = resultSet.getString("customer_name");

                String dateOfBirth = resultSet.getString("date_of_birth");
                String idNumber = resultSet.getString("id_number");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                CustomerDTO customerDTO = new CustomerDTO(customerId, typeOfCustomerId, typeOfCustomerName, customerName, dateOfBirth, idNumber, phone, email, address);
                customerDTOList.add(customerDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerDTOList;
    }
}
