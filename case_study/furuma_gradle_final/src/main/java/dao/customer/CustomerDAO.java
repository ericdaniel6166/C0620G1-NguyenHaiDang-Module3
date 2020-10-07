package dao.customer;

import dto.customer.CustomerDTO;
import model.customer.Customer;

import java.util.List;

public interface CustomerDAO {
    List<CustomerDTO> listCustomer();

    boolean addCustomer(Customer customer);

    boolean editCustomer(Customer customer);

    boolean deleteCustomer(String id);

    CustomerDTO searchCustomerById(String id);

    List<CustomerDTO> searchCustomerByName(String name);
}
