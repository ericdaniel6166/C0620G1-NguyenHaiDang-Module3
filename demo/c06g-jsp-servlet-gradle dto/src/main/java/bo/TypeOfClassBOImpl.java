package bo;

import dao.TypeOfClassDAO;
import dao.TypeOfClassDAOImpl;
import model.TypeOfClass;

import java.util.List;

public class TypeOfClassBOImpl implements TypeOfClassBO {
    private TypeOfClassDAO typeOfClassDAO = new TypeOfClassDAOImpl();

    @Override
    public List<TypeOfClass> findAllTypeOfClass() {
        return this.typeOfClassDAO.findAllTypeOfClass();
    }
}
