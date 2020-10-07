package dao.customer;

import dao.BaseDAO;
import model.customer.TypeOfCustomer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfCustomerDAOImpl implements TypeOfCustomerDAO {
    private static final String LIST_TYPE_OF_CUSTOMER = "SELECT * FROM types_of_customer;";
    private static final String VIEW_TYPE_OF_CUSTOMER = "SELECT * FROM types_of_customer WHERE type_of_customer_id =?;";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<TypeOfCustomer> listTypeOfCustomer() {
        List<TypeOfCustomer> typeOfCustomerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(LIST_TYPE_OF_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String typeOfCustomerId = String.valueOf(resultSet.getString("type_of_customer_id"));
                String typeOfCustomerName = resultSet.getString("type_name");
                TypeOfCustomer typeOfCustomer = new TypeOfCustomer(typeOfCustomerId, typeOfCustomerName);
                typeOfCustomerList.add(typeOfCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeOfCustomerList;
    }

    @Override
    public TypeOfCustomer searchTypeOfCustomerById(String id) {
        TypeOfCustomer typeOfCustomer = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(VIEW_TYPE_OF_CUSTOMER);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String typeOfCustomerId = String.valueOf(resultSet.getString("type_of_customer_id"));
                String typeOfCustomerName = resultSet.getString("type_name");
                typeOfCustomer = new TypeOfCustomer(typeOfCustomerId, typeOfCustomerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeOfCustomer;
    }
}
