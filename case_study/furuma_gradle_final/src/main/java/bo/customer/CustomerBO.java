package bo.customer;

import dto.customer.CustomerDTO;
import model.customer.Customer;

import java.util.List;

public interface CustomerBO {
    List<CustomerDTO> listCustomer();

    String addCustomer(Customer customer);

    String editCustomer(Customer customer);

    String deleteCustomer(String id);

    CustomerDTO searchCustomerById(String id);

    List<CustomerDTO> searchCustomerByName(String name);
}
