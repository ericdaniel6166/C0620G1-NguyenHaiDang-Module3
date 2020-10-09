package dao.service;

import model.service.TypeOfService;

import java.util.List;

public interface TypeOfServiceDAO {
    List<TypeOfService> listTypeOfService();

    TypeOfService searchTypeOfServiceById(String id);
}
