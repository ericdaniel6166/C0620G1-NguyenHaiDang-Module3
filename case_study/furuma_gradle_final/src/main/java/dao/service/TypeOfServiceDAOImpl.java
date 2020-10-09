package dao.service;

import dao.BaseDAO;
import model.service.TypeOfService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfServiceDAOImpl implements TypeOfServiceDAO {
    public static final String LIST_TYPE_OF_SERVICE = "SELECT * FROM types_of_service;";

    public static final String SEARCH_TYPE_OF_SERVICE_NAME_BY_ID ="SELECT * FROM types_of_service where type_of_service_id = ? ;";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<TypeOfService> listTypeOfService() {
        List<TypeOfService> typeOfServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(LIST_TYPE_OF_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String typeOfServiceId = String.valueOf(resultSet.getString("type_of_service_id"));
                String typeOfServiceName = resultSet.getString("type_of_service_name");
                TypeOfService typeOfService = new TypeOfService(typeOfServiceId, typeOfServiceName);
                typeOfServiceList.add(typeOfService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeOfServiceList;
    }
    @Override
    public TypeOfService searchTypeOfServiceById(String id) {
        TypeOfService typeOfService = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_TYPE_OF_SERVICE_NAME_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String typeOfServiceId = String.valueOf(resultSet.getString("typeOfService_id"));
                String typeOfServiceName =resultSet.getString("typeOfService_name");
                typeOfService = new TypeOfService(typeOfServiceId, typeOfServiceName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeOfService;
    }
}
