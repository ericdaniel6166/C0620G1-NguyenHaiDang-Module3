package bo.service;

import dao.service.TypeOfRentDAO;
import dao.service.TypeOfRentDAOImpl;
import model.service.TypeOfRent;

import java.util.List;

public class TypeOfRentBOImpl implements TypeOfRentBO {
    private TypeOfRentDAO typeOfRentDAO = new TypeOfRentDAOImpl();

    @Override
    public List<TypeOfRent> listTypeOfRent() {
        return this.typeOfRentDAO.listTypeOfRent();
    }

    @Override
    public TypeOfRent searchTypeOfRentById(String id) {
        return this.typeOfRentDAO.searchTypeOfRentById(id);
    }
}
