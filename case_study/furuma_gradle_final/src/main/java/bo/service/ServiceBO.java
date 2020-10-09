package bo.service;

import dto.service.ServiceDTO;
import model.service.Service;

import java.util.List;

public interface ServiceBO {
    List<ServiceDTO> listService();

    String addService(Service service);

    String editService(Service service);

    String deleteService(String id);

    ServiceDTO searchServiceById(String id);

    List<ServiceDTO> searchServiceByName(String name);
}
