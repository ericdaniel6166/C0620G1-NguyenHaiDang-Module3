package controller.customer;

import bo.customer.CustomerBO;
import bo.customer.CustomerBOImpl;
import bo.customer.TypeOfCustomerBO;
import bo.customer.TypeOfCustomerBOImpl;
import dto.customer.CustomerDTO;
import model.customer.Customer;
import model.customer.TypeOfCustomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/list_customer")
public class CustomerServlet extends HttpServlet {
    private CustomerBO customerBO = new CustomerBOImpl();
    private TypeOfCustomerBO typeOfCustomerBO = new TypeOfCustomerBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;

            case "search_by_name":
                searchCustomerByName(request, response);
            default:
                break;
        }
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) {
        boolean customerSearched = false;
        String message = "";
        List<CustomerDTO> customerDTOList;
        try {
            String customerNameSearch = request.getParameter("customerNameSearch");

            customerDTOList = this.customerBO.searchCustomerByName(customerNameSearch);

            RequestDispatcher dispatcher;

            if (customerDTOList.size() == 0) {
                message += "Customer Name " + '"' + customerNameSearch + '"' + " is not found";


                dispatcher = request.getRequestDispatcher("view/customer/search_by_name_customer.jsp");

            } else {
                customerSearched = true;
                request.setAttribute("customerDTOList", customerDTOList);

                List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
                request.setAttribute("typeOfCustomerList", typeOfCustomerList);

                message = "Customer Name: " + '"' + customerNameSearch + '"';

                dispatcher = request.getRequestDispatcher("view/customer/list_customer.jsp");
            }

            request.setAttribute("message", message);

            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        boolean customerDeleted = false;
        try {
            String customerIdDelete = (request.getParameter("customerIdDelete"));

            CustomerDTO customerDTODelete = this.customerBO.searchCustomerById(customerIdDelete);
            request.setAttribute("customerDTODelete", customerDTODelete);

            List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);

            message = this.customerBO.deleteCustomer(customerIdDelete);
//            message = "Customer was successfully deleted.";
            request.setAttribute("message", message);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/delete_customer.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        boolean customerEdited = false;
        try {
            String customerIdEdit = (request.getParameter("customerIdEdit"));

            String customerNameEdit = request.getParameter("customerNameEdit");
//            if (!Validator.regex(REGEX_NAME, customerNameEdit)) {
//                message += "Invalid Name: Please input valid name. <br>";
//            }

            String typeOfCustomerIdEdit = (request.getParameter("typeOfCustomerIdEdit"));

            String dateOfBirthEdit = request.getParameter("dateOfBirthEdit");

            String idNumberEdit = request.getParameter("idNumberEdit");
//            if (!Validator.regex(REGEX_ID_NUMBER, idNumberEdit)) {
//                message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
//            }

            String phoneEdit = request.getParameter("phoneEdit");
//            if (!Validator.regex(REGEX_PHONE, phoneEdit)) {
//                message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
//            }

            String emailEdit = request.getParameter("emailEdit");
//            if (!Validator.regex(REGEX_EMAIL, emailEdit)) {
//                message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
//            }

            String addressEdit = request.getParameter("addressEdit");


            Customer customer = new Customer(customerNameEdit, typeOfCustomerIdEdit, customerNameEdit, dateOfBirthEdit, idNumberEdit, phoneEdit, emailEdit, addressEdit);

            message = this.customerBO.editCustomer(customer);
            request.setAttribute("message", message);
//                message = "Customer was successfully edited.";

            CustomerDTO customerDTOEdit = this.customerBO.searchCustomerById(customerIdEdit);
            request.setAttribute("customerDTOEdit", customerDTOEdit);

            List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit_customer.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        //            Add
//            ******
        boolean customerAdded = false;
        String message = "";
        try {
            String customerIdAddString = request.getParameter("customerIdAdd");
//            String customerIdAdd = null;
//            if (customerIdAddString.equals("")) {
//                customerIdAdd = null;
//            } else if (!Validator.regex(REGEX_POSITIVE_INTEGER, customerIdAddString)) {
//                message += "Invalid Customer ID: Customer ID is a positive integer. <br>";
//            } else {
//                customerIdAdd = (customerIdAddString);
//                if (this.customerBO.searchCustomerById(customerIdAdd) != null) {
//                    message += "Invalid Customer ID: Customer ID already exists. <br>";
//                }
//            }

            String typeOfCustomerIdAdd = (request.getParameter("typeOfCustomerIdAdd"));

            String customerNameAdd = request.getParameter("customerNameAdd");
//            if (!Validator.regex(REGEX_PERSON_NAME, customerNameAdd)) {
//                message += "Invalid name: Please input valid name (ex: An Binh). <br>";
//            }

            String dateOfBirthAdd = request.getParameter("dateOfBirthAdd");

            String idNumberAdd = request.getParameter("idNumberAdd");
//            if (!Validator.regex(REGEX_ID_NUMBER, idNumberAdd)) {
//                message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
//            }


            String phoneAdd = request.getParameter("phoneAdd");
//            if (!Validator.regex(REGEX_PHONE, phoneAdd)) {
//                message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
//            }

            String emailAdd = request.getParameter("emailAdd");
//            if (!Validator.regex(REGEX_EMAIL, emailAdd)) {
//                message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
//            }

            String addressAdd = request.getParameter("addressAdd");

            Customer customer = new Customer(customerIdAddString, typeOfCustomerIdAdd, customerNameAdd, dateOfBirthAdd, idNumberAdd, phoneAdd, emailAdd, addressAdd);
            message = this.customerBO.addCustomer(customer);
//                message = "Customer was successfully added.";

            request.setAttribute("message", message);

            List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/add_customer.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            case "search_by_name":
                showSearchCustomerByNameForm(request, response);
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showSearchCustomerByNameForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/search_by_name_customer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);

            String customerIdView = (request.getParameter("customerIdView"));
            CustomerDTO customerDTOView = this.customerBO.searchCustomerById(customerIdView);
            request.setAttribute("customerDTOView", customerDTOView);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/view_customer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);

            String customerIdDelete = (request.getParameter("customerIdDelete"));
            CustomerDTO customerDTODelete = this.customerBO.searchCustomerById(customerIdDelete);
            request.setAttribute("customerDTODelete", customerDTODelete);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/delete_customer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);

            String customerIdEdit = (request.getParameter("customerIdEdit"));
            CustomerDTO customerDTOEdit = this.customerBO.searchCustomerById(customerIdEdit);
            request.setAttribute("customerDTOEdit", customerDTOEdit);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit_customer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/add_customer.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<TypeOfCustomer> typeOfCustomerList = this.typeOfCustomerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);

            List<CustomerDTO> customerDTOList = this.customerBO.listCustomer();
            request.setAttribute("customerDTOList", customerDTOList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list_customer.jsp");

            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
