package bo.customer;

import model.customer.TypeOfCustomer;

import java.util.List;

public interface TypeOfCustomerBO {
    List<TypeOfCustomer> listTypeOfCustomer();

    TypeOfCustomer searchTypeOfCustomerById(Integer id);
}
