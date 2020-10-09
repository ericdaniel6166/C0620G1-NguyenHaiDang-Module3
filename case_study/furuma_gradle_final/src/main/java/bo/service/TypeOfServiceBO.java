package bo.service;

import model.service.TypeOfService;

import java.util.List;

public interface TypeOfServiceBO {
    List<TypeOfService> listTypeOfService();

    TypeOfService searchTypeOfServiceById(String id);
}
