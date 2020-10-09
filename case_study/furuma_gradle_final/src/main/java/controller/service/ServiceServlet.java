package controller.service;

import bo.service.*;
import dto.service.ServiceDTO;
import model.service.Service;
import model.service.TypeOfRent;
import model.service.TypeOfService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/list_service")
public class ServiceServlet extends HttpServlet {
    private ServiceBO serviceBO = new ServiceBOImpl();
    private TypeOfRentBO typeOfRentBO = new TypeOfRentBOImpl();
    private TypeOfServiceBO typeOfServiceBO = new TypeOfServiceBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addService(request, response);
                listService(request, response);
                break;
            case "edit":
                editService(request, response);
                listService(request, response);
                break;
            case "delete":
                deleteService(request, response);
                listService(request, response);
                break;
            case "search_by_name":
                searchServiceByName(request, response);
            default:
                break;
        }
    }

    private void searchServiceByName(HttpServletRequest request, HttpServletResponse response) {
        boolean serviceSearched = false;
        String message = "";
        List<ServiceDTO> serviceDTOList;
        try {
            String serviceNameSearch = request.getParameter("serviceNameSearch");
            serviceDTOList = this.serviceBO.searchServiceByName(serviceNameSearch);
            if (serviceDTOList.size() == 0) {
                message += "Service Name " + '"' + serviceNameSearch + '"' + " is not found";
            } else {
                message = "Service Name " + '"' + serviceNameSearch + '"';
            }

            request.setAttribute("serviceDTOList", serviceDTOList);
            request.setAttribute("message", message);

            List<TypeOfRent> typeOfRentList = this.typeOfRentBO.listTypeOfRent();
            request.setAttribute("typeOfRentList", typeOfRentList);

            List<TypeOfService> typeOfServiceList = this.typeOfServiceBO.listTypeOfService();
            request.setAttribute("typeOfServiceList", typeOfServiceList);


            RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list_service.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String serviceIdEdit = request.getParameter("serviceIdEdit");

        String serviceNameEdit = request.getParameter("serviceNameEdit");

        String areaEdit = (request.getParameter("areaEdit"));

        String numberOfFloorsEdit = (request.getParameter("numberOfFloorsEdit"));

        String maximumNumberOfCustomersEdit = (request.getParameter("maximumNumberOfCustomersEdit"));

        String rentPriceEdit = request.getParameter("rentPriceEdit");

        String typeOfRentIdEdit = request.getParameter("typeOfRentIdEdit");

        String typeOfServiceIdEdit = request.getParameter("typeOfServiceIdEdit");

        String statusEdit = request.getParameter("statusEdit");

        Service serviceEdit = new Service(serviceIdEdit, serviceNameEdit, areaEdit, numberOfFloorsEdit, maximumNumberOfCustomersEdit, rentPriceEdit, typeOfRentIdEdit, typeOfServiceIdEdit, statusEdit);
        message = this.serviceBO.editService(serviceEdit);

        request.setAttribute("message", message);


    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String serviceIdDelete = (request.getParameter("serviceIdDelete"));
        message = this.serviceBO.deleteService(serviceIdDelete);

        request.setAttribute("message", message);


    }

    private void addService(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String serviceIdAdd = request.getParameter("serviceIdAdd");

        String serviceNameAdd = request.getParameter("serviceNameAdd");

        String areaAdd = (request.getParameter("areaAdd"));

        String numberOfFloorsAdd = (request.getParameter("numberOfFloorsAdd"));

        String maximumNumberOfCustomersAdd = (request.getParameter("maximumNumberOfCustomersAdd"));

        String rentPriceAdd = request.getParameter("rentPriceAdd");

        String typeOfRentIdAdd = request.getParameter("typeOfRentIdAdd");

        String typeOfServiceIdAdd = request.getParameter("typeOfServiceIdAdd");

        String statusAdd = request.getParameter("statusAdd");

        Service serviceAdd = new Service(serviceIdAdd, serviceNameAdd, areaAdd, numberOfFloorsAdd, maximumNumberOfCustomersAdd, rentPriceAdd, typeOfRentIdAdd, typeOfServiceIdAdd, statusAdd);
        message = this.serviceBO.addService(serviceAdd);

        request.setAttribute("message", message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
//                showAddForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
                break;
            case "view":
//                viewService(request,response);
                break;

            default:
                listService(request, response);
                break;
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<ServiceDTO> serviceDTOList = this.serviceBO.listService();
            request.setAttribute("serviceDTOList", serviceDTOList);

            List<TypeOfRent> typeOfRentList = this.typeOfRentBO.listTypeOfRent();
            request.setAttribute("typeOfRentList", typeOfRentList);

            List<TypeOfService> typeOfServiceList = this.typeOfServiceBO.listTypeOfService();
            request.setAttribute("typeOfServiceList", typeOfServiceList);


            RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list_service.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
