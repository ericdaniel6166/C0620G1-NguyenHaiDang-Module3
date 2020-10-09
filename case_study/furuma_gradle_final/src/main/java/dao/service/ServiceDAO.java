package dao.service;

import dto.service.ServiceDTO;
import model.service.Service;

import java.util.List;

public interface ServiceDAO {
    List<ServiceDTO> listService();

    boolean addService(Service service);

    boolean editService(Service service);

    boolean deleteService(String id);

    ServiceDTO searchServiceById(String id);

    List<ServiceDTO> searchServiceByName(String name);
}
