package bo.customer;

import dao.customer.TypeOfCustomerDAO;
import dao.customer.TypeOfCustomerDAOImpl;
import model.customer.TypeOfCustomer;

import java.util.List;

public class TypeOfCustomerBOImpl implements TypeOfCustomerBO {
    private TypeOfCustomerDAO typeOfCustomerDAO = new TypeOfCustomerDAOImpl();

    @Override
    public List<TypeOfCustomer> listTypeOfCustomer() {
        return this.typeOfCustomerDAO.listTypeOfCustomer();
    }

    @Override
    public TypeOfCustomer searchTypeOfCustomerById(String id) {
        return this.typeOfCustomerDAO.searchTypeOfCustomerById(id);
    }
}
