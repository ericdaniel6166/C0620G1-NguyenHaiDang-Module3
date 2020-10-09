package dao.service;

import dao.BaseDAO;
import model.service.TypeOfRent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfRentDAOImpl implements TypeOfRentDAO {
    public static final String LIST_TYPE_OF_RENT = "SELECT * FROM types_of_rent;";

    public static final String SEARCH_TYPE_OF_RENT_NAME_BY_ID ="SELECT * FROM types_of_rent where type_of_rent_id = ? ;";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<TypeOfRent> listTypeOfRent() {
        List<TypeOfRent> typeOfRentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(LIST_TYPE_OF_RENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String typeOfRentId = (resultSet.getString("type_of_rent_id"));
                String typeOfRentName = resultSet.getString("type_of_rent_name");
                String typeOfRentPrice = resultSet.getString("price");
                TypeOfRent typeOfRent = new TypeOfRent(typeOfRentId, typeOfRentName,typeOfRentPrice);
                typeOfRentList.add(typeOfRent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeOfRentList;
    }
    @Override
    public TypeOfRent searchTypeOfRentById(String id) {
        TypeOfRent typeOfRent = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_TYPE_OF_RENT_NAME_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String typeOfRentId = (resultSet.getString("type_of_rent_id"));
                String typeOfRentName =resultSet.getString("type_of_rent_name");
                String typeOfRentPrice =resultSet.getString("price");
                typeOfRent = new TypeOfRent(typeOfRentId, typeOfRentName,typeOfRentPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeOfRent;
    }
}
