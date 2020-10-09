package dao.service;

import dao.BaseDAO;
import dto.service.ServiceDTO;
import model.service.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    public static final String LIST_SERVICE_VIEW = "SELECT * FROM view_services;";

    private static final String ADD_SERVICE = "INSERT INTO services VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String EDIT_SERVICE = "UPDATE services SET service_name = ?, area = ?, number_of_floors = ?, maximum_number_of_customers = ?, rent_price = ?, type_of_rent_id = ?, type_of_service_id = ?, status = ? WHERE (service_id = ?);";
    private static final String DELETE_SERVICE = "DELETE FROM services WHERE service_id = ?;";

    private static final String SEARCH_SERVICE_BY_ID_VIEW = "SELECT * FROM view_services where service_id = ?;";
    private static final String SEARCH_SERVICE_BY_NAME_VIEW = "SELECT * FROM view_services WHERE service_name LIKE CONCAT('%',?,'%');";

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<ServiceDTO> listService() {
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(LIST_SERVICE_VIEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String serviceId = (resultSet.getString("service_id"));
                String serviceName = resultSet.getString("service_name");

                String area = (resultSet.getString("area"));

                String numberOfFloors = (resultSet.getString("number_of_floors"));

                String maximumNumberOfCustomers = (resultSet.getString("maximum_number_of_customers"));

                String rentPrice = resultSet.getString("rent_price");
                String typeOfRentId = resultSet.getString("type_of_rent_id");
                String typeOfServiceId = (resultSet.getString("type_of_service_id"));
                String status = resultSet.getString("status");
                String typeOfRentName = resultSet.getString("type_of_rent_name");
                String typeOfRentPrice = resultSet.getString("price");
                String typeOfServiceName = resultSet.getString("type_of_service_name");
                ServiceDTO serviceDTO = new ServiceDTO(serviceId, serviceName, area, numberOfFloors, maximumNumberOfCustomers, rentPrice, typeOfRentId, typeOfServiceId, status, typeOfRentName, typeOfRentPrice, typeOfServiceName);
                serviceDTOList.add(serviceDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceDTOList;
    }

    @Override
    public boolean addService(Service service) {
        boolean rowInsert = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(ADD_SERVICE);
            String serviceId = service.getServiceId();
            if (serviceId != "") {
                preparedStatement.setString(1, serviceId);
            } else {
                preparedStatement.setString(1, null);
            }

            preparedStatement.setString(2, service.getServiceName());
            preparedStatement.setString(3, service.getArea());
            preparedStatement.setString(4, service.getNumberOfFloors());
            preparedStatement.setString(5, service.getMaximumNumberOfCustomers());
            preparedStatement.setString(6, service.getRentPrice());
            preparedStatement.setString(7, service.getTypeOfRentId());
            preparedStatement.setString(8, service.getTypeOfServiceId());
            preparedStatement.setString(9, service.getStatus());
            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean editService(Service service) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(EDIT_SERVICE);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setString(2, service.getArea());
            preparedStatement.setString(3, service.getNumberOfFloors());
            preparedStatement.setString(4, service.getMaximumNumberOfCustomers());
            preparedStatement.setString(5, service.getRentPrice());
            preparedStatement.setString(6, service.getTypeOfRentId());
            preparedStatement.setString(7, service.getTypeOfServiceId());
            preparedStatement.setString(8, service.getStatus());

            preparedStatement.setString(9, service.getServiceId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteService(String id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_SERVICE);
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public ServiceDTO searchServiceById(String id) {
        ServiceDTO serviceDTO = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_SERVICE_BY_ID_VIEW);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String serviceId = (resultSet.getString("service_id"));
                String serviceName = resultSet.getString("service_name");

                String area = (resultSet.getString("area"));

                String numberOfFloors = (resultSet.getString("number_of_floors"));

                String maximumNumberOfCustomers = (resultSet.getString("maximum_number_of_customers"));

                String rentPrice = resultSet.getString("rent_price");
                String typeOfRentId = resultSet.getString("type_of_rent_id");
                String typeOfServiceId = (resultSet.getString("type_of_service_id"));
                String status = resultSet.getString("status");
                String typeOfRentName = resultSet.getString("type_of_rent_name");
                String typeOfRentPrice = resultSet.getString("price");
                String typeOfServiceName = resultSet.getString("type_of_service_name");
                serviceDTO = new ServiceDTO(serviceId, serviceName, area, numberOfFloors, maximumNumberOfCustomers, rentPrice, typeOfRentId, typeOfServiceId, status, typeOfRentName, typeOfRentPrice, typeOfServiceName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceDTO;
    }

    @Override
    public List<ServiceDTO> searchServiceByName(String name) {
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_SERVICE_BY_NAME_VIEW);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String serviceId = (resultSet.getString("service_id"));
                String serviceName = resultSet.getString("service_name");

                String area = (resultSet.getString("area"));

                String numberOfFloors = (resultSet.getString("number_of_floors"));

                String maximumNumberOfCustomers = (resultSet.getString("maximum_number_of_customers"));

                String rentPrice = resultSet.getString("rent_price");
                String typeOfRentId = resultSet.getString("type_of_rent_id");
                String typeOfServiceId = (resultSet.getString("type_of_service_id"));
                String status = resultSet.getString("status");
                String typeOfRentName = resultSet.getString("type_of_rent_name");
                String typeOfRentPrice = resultSet.getString("price");
                String typeOfServiceName = resultSet.getString("type_of_service_name");
                ServiceDTO serviceDTO = new ServiceDTO(serviceId,serviceName,area,numberOfFloors,maximumNumberOfCustomers,rentPrice,typeOfRentId,typeOfServiceId,status,typeOfRentName,typeOfRentPrice,typeOfServiceName);
                serviceDTOList.add(serviceDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceDTOList;
    }
}
