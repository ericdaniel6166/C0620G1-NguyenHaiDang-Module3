package dao.service;

import model.service.TypeOfRent;

import java.util.List;

public interface TypeOfRentDAO {
    List<TypeOfRent> listTypeOfRent();

    TypeOfRent searchTypeOfRentById(String id);
}
