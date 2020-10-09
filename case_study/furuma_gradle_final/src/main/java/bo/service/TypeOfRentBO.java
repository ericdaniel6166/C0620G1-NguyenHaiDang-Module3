package bo.service;

import model.service.TypeOfRent;

import java.util.List;

public interface TypeOfRentBO {
    List<TypeOfRent> listTypeOfRent();

    TypeOfRent searchTypeOfRentById(String id);
}
