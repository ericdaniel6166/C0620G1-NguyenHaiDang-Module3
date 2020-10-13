package bo.customer;

import common.Validator;
import dao.customer.CustomerDAO;
import dao.customer.CustomerDAOImpl;
import dto.customer.CustomerDTO;
import model.customer.Customer;

import java.util.List;

import static common.Validator.*;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<CustomerDTO> listCustomer() {
        return this.customerDAO.listCustomer();
    }

    @Override
    public String addCustomer(Customer customer) {
        String message = "";
        boolean customerAdded = false;
        if (!"".equals(customer.getCustomerId()) && !Validator.regex(REGEX_SERVICE_NAME, customer.getCustomerId())) {
            message += "Invalid Customer ID: Customer ID is a positive integer. <br>";
        }
        if (!"".equals(customer.getCustomerId()) && this.searchCustomerById(customer.getCustomerId()) != null) {
            message += "Invalid Customer ID: Customer ID already exists. <br>";
        }
        if (!Validator.regex(REGEX_PERSON_NAME, customer.getCustomerName())) {
            message += "Invalid name: Please input valid name (ex: An Binh). <br>";
        }


        if (!Validator.regex(REGEX_ID_NUMBER, customer.getIdNumber())) {
            message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
        }


        if (!Validator.regex(REGEX_PHONE, customer.getPhone())) {
            message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
        }

        if (!Validator.regex(REGEX_EMAIL, customer.getEmail())) {
            message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
        }
        if ("".equals(message)) {
            customerAdded = this.customerDAO.addCustomer(customer);
            message = "Customer was successfully added.";
        }
        return message;
    }

    @Override
    public String editCustomer(Customer customer) {
        String message = "";
        boolean customerEdited = false;
        if (!Validator.regex(REGEX_PERSON_NAME, customer.getCustomerName())) {
            message += "Invalid Name: Please input valid name. <br>";
        }

        if (!Validator.regex(REGEX_ID_NUMBER, customer.getIdNumber())) {
            message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
        }

        if (!Validator.regex(REGEX_PHONE, customer.getPhone())) {
            message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
        }

        if (!Validator.regex(REGEX_EMAIL, customer.getEmail())) {
            message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
        }
        if ("".equals(message)) {
            customerEdited = this.customerDAO.editCustomer(customer);
            message = "Customer was successfully edited.";
        }

        return message;
    }

    @Override
    public String deleteCustomer(String id) {
        String message = "";
        boolean customerDeleted = false;
        customerDeleted = this.customerDAO.deleteCustomer(id);
        message = "Customer was successfully deleted.";
        return message;
    }

    @Override
    public CustomerDTO searchCustomerById(String id) {
        return this.customerDAO.searchCustomerById(id);
    }

    @Override
    public List<CustomerDTO> searchCustomerByName(String name) {
        return this.customerDAO.searchCustomerByName(name);
    }
}
