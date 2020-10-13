package bo.service;

import common.Validator;
import dao.service.ServiceDAO;
import dao.service.ServiceDAOImpl;
import dto.service.ServiceDTO;
import model.service.Service;

import java.util.List;

import static common.Validator.*;

public class ServiceBOImpl implements ServiceBO {
    private ServiceDAO serviceDAO = new ServiceDAOImpl();

    @Override
    public List<ServiceDTO> listService() {
        return this.serviceDAO.listService();
    }

    @Override
    public String addService(Service service) {
        String message = "";
        boolean serviceAdded = false;

        if (service.getServiceId() != "" && !Validator.regex(REGEX_POSITIVE_INTEGER, service.getServiceId())) {
            message += "Invalid Service ID: Service ID is a positive integer. <br>";
        }
        if (service.getServiceId() != "" && this.searchServiceById(service.getServiceId()) != null) {
            message += "Invalid Service ID: Service ID already exists. <br>";
        }
        if (!Validator.regex(REGEX_SERVICE_NAME, service.getServiceName())) {
            message += "Invalid name: Please input valid service name (ex: DV-XXXX). <br>";
        }

        if (!Validator.regex(REGEX_POSITIVE_NUMBER, service.getArea())) {
            message += "Invalid Area: Area is a positive number. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_INTEGER, service.getNumberOfFloors())) {
            message += "Invalid Number Of Floors: Number Of Floors is a positive integer. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_INTEGER, service.getMaximumNumberOfCustomers())) {
            message += "Invalid Maximum Number Of Customers: Maximum Number Of Customers is a positive integer. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_NUMBER, service.getRentPrice())) {
            message += "Invalid Rent Price: Rent Price is a positive number. <br>";
        }
        if ("".equals(message)) {
            serviceAdded = this.serviceDAO.addService(service);
            message = "Service was successfully added.";
        }
        return message;
    }

    @Override
    public String editService(Service service) {
        String message = "";
        boolean serviceEdited = false;

        if (!Validator.regex(REGEX_SERVICE_NAME, service.getServiceName())) {
            message += "Invalid name: Please input valid service name (ex: DV-XXXX). <br>";
        }

        if (!Validator.regex(REGEX_POSITIVE_NUMBER, service.getArea())) {
            message += "Invalid Area: Area is a positive number. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_INTEGER, service.getNumberOfFloors())) {
            message += "Invalid Number Of Floors: Number Of Floors is a positive integer. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_INTEGER, service.getMaximumNumberOfCustomers())) {
            message += "Invalid Maximum Number Of Customers: Maximum Number Of Customers is a positive integer. <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_NUMBER, service.getRentPrice())) {
            message += "Invalid Rent Price: Rent Price is a positive number. <br>";
        }

        if ("".equals(message)) {
            serviceEdited = this.serviceDAO.editService(service);
            message = "Service was successfully edited.";
        }
        return message;
    }

    @Override
    public String deleteService(String id) {
        String message = "";
        boolean serviceDeleted = false;

        serviceDeleted = this.serviceDAO.deleteService(id);
        message = "Service was successfully deleted.";
        return message;
    }

    @Override
    public ServiceDTO searchServiceById(String id) {
        return this.serviceDAO.searchServiceById(id);
    }

    @Override
    public List<ServiceDTO> searchServiceByName(String name) {
        return this.serviceDAO.searchServiceByName(name);
    }
}
