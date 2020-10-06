package dao.customer;

import dto.customer.CustomerDTO;
import model.customer.Customer;

import java.util.List;

public interface CustomerDAO {
    List<CustomerDTO> listCustomer();

    boolean addCustomer(Customer customer);

    boolean editCustomer(Customer customer);

    boolean deleteCustomer(Integer id);

    CustomerDTO searchCustomerById(Integer id);

    List<CustomerDTO> searchCustomerByName(String name);
}
