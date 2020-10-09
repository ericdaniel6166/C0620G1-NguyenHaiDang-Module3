package bo.service;

import dao.service.TypeOfServiceDAO;
import dao.service.TypeOfServiceDAOImpl;
import model.service.TypeOfService;

import java.util.List;

public class TypeOfServiceBOImpl implements TypeOfServiceBO {
    private TypeOfServiceDAO typeOfServiceDAO = new TypeOfServiceDAOImpl();

    @Override
    public List<TypeOfService> listTypeOfService() {
        return this.typeOfServiceDAO.listTypeOfService();
    }

    @Override
    public TypeOfService searchTypeOfServiceById(String id) {
        return this.searchTypeOfServiceById(id);
    }
}
