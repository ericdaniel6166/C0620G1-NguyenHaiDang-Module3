package bo.customer;

import dao.customer.CustomerDAO;
import dao.customer.CustomerDAOImpl;
import dto.customer.CustomerDTO;
import model.customer.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<CustomerDTO> listCustomer() {
        return this.customerDAO.listCustomer();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return this.customerDAO.addCustomer(customer);
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return this.customerDAO.editCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        return this.customerDAO.deleteCustomer(id);
    }

    @Override
    public CustomerDTO searchCustomerById(Integer id) {
        return this.customerDAO.searchCustomerById(id);
    }

    @Override
    public List<CustomerDTO> searchCustomerByName(String name) {
        return this.customerDAO.searchCustomerByName(name);
    }
}
