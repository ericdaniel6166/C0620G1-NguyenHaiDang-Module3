package controller.customer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerServlet", urlPatterns = "/list_customer")
public class CustomerServlet extends HttpServlet {
//    private CustomerBO customerBO = new CustomerBOImpl();
//    private PositionBO positionBO = new PositionBOImpl();
//    private LevelBO levelBO = new LevelBOImpl();
//    private DepartmentBO departmentBO = new DepartmentBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
//                addCustomer(request, response);
                break;
            case "edit":
//                editCustomer(request, response);
                break;
            case "delete":
//                deleteCustomer(request, response);
                break;
            default:
                break;
        }
//        listCustomer(request, response);
    }

//    private String editCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String message = "";
//        boolean customerEdited = false;
//        try {
//            Integer customerIdEdit = Integer.valueOf(request.getParameter("customerIdEdit"));
//
//            String customerNameEdit = request.getParameter("customerNameEdit");
//            if (!Validator.regex(REGEX_NAME, customerNameEdit)) {
//                message += "Invalid Name: Please input valid name. <br>";
//            }
//
//            Integer positionIdEdit = Integer.valueOf(request.getParameter("positionIdEdit"));
//            Integer levelIdEdit = Integer.valueOf(request.getParameter("levelIdEdit"));
//            Integer departmentIdEdit = Integer.valueOf(request.getParameter("departmentIdEdit"));
//
//            String dateOfBirthEdit = request.getParameter("dateOfBirthEdit");
//
//            String idNumberEdit = request.getParameter("idNumberEdit");
//            if (!Validator.regex(REGEX_ID_NUMBER, idNumberEdit)) {
//                message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
//            }
//
//            String salaryEditString = request.getParameter("salaryEdit");
//            Double salaryEdit = null;
//            if (!Validator.regex(REGEX_POSITIVE_NUMBER, salaryEditString)) {
//                message += "Invalid Salary: Salary is a positive number. <br>";
//            } else {
//                salaryEdit = Double.valueOf(salaryEditString);
//            }
//
//            String phoneEdit = request.getParameter("phoneEdit");
//            if (!Validator.regex(REGEX_PHONE, phoneEdit)) {
//                message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
//            }
//
//            String emailEdit = request.getParameter("emailEdit");
//            if (!Validator.regex(REGEX_EMAIL, emailEdit)) {
//                message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
//            }
//
//            String addressEdit = request.getParameter("addressEdit");
//
//            if (message.equals("")) {
//                Customer customer = new Customer(customerIdEdit, customerNameEdit, positionIdEdit, levelIdEdit, departmentIdEdit, dateOfBirthEdit, idNumberEdit, salaryEdit, phoneEdit, emailEdit, addressEdit);
//                customerEdited = this.customerBO.editCustomer(customer);
//                message = "Customer was successfully edited.";
//            }
//
//            request.setAttribute("message", message);
//
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        return message;
//    }

//    private String deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String message = "";
//        boolean customerDeleted = false;
//        try {
//            Integer customerIdDelete = Integer.valueOf(request.getParameter("customerIdDelete"));
//            customerDeleted = this.customerBO.deleteCustomer(customerIdDelete);
//            message = "Customer was successfully deleted.";
//
//            request.setAttribute("message", message);
//
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        return message;
//    }

//    private String addCustomer(HttpServletRequest request, HttpServletResponse response) {
//        //            Add
////            ******
//        boolean customerAdded = false;
//        String message = "";
//        try {
//            String customerIdString = request.getParameter("customerId");
//            Integer customerId = null;
//            if (customerIdString.equals("")) {
//                customerId = null;
//            } else if (!Validator.regex(REGEX_POSITIVE_INTEGER, customerIdString)) {
//                message += "Invalid Customer ID: Customer ID is a positive integer. <br>";
//            } else {
//                customerId = Integer.valueOf(customerIdString);
//                if (this.customerBO.searchCustomerById(customerId) != null) {
//                    message += "Invalid Customer ID: Customer ID already exists. <br>";
//                }
//            }
//
//            String customerName = request.getParameter("customerName");
//            if (!Validator.regex(REGEX_NAME, customerName)) {
//                message += "Invalid name: Please input valid name (ex: An Binh). <br>";
//            }
//
//            Integer positionId = Integer.valueOf(request.getParameter("positionId"));
//
//            Integer levelId = Integer.valueOf(request.getParameter("levelId"));
//
//            Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
//
//            String dateOfBirth = request.getParameter("dateOfBirth");
//
//            String idNumber = request.getParameter("idNumber");
//            if (!Validator.regex(REGEX_ID_NUMBER, idNumber)) {
//                message += "Invalid ID Number: ID Number must be 9 or 12 digits. <br>";
//            }
//
//            String salaryString = request.getParameter("salary");
//            Double salary = null;
//            if (!Validator.regex(REGEX_POSITIVE_NUMBER, salaryString)) {
//                message += "Invalid Salary: Salary is a positive number. <br>";
//            } else {
//                salary = Double.valueOf(salaryString);
//            }
//
//            String phone = request.getParameter("phone");
//            if (!Validator.regex(REGEX_PHONE, phone)) {
//                message += "Invalid Phone: Phone must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx. <br>";
//            }
//
//            String email = request.getParameter("email");
//            if (!Validator.regex(REGEX_EMAIL, email)) {
//                message += "Invalid Email: Please input valid email (ex: abc_abc.abc@abc.abc.abc). <br>";
//            }
//
//            String address = request.getParameter("address");
//
//            if (message.equals("")) {
//                Customer customer = new Customer(customerId, customerName, positionId, levelId, departmentId, dateOfBirth, idNumber, salary, phone, email, address);
//                customerAdded = this.customerBO.addCustomer(customer);
//                message = "Customer was successfully added.";
//            }
//
//            request.setAttribute("message", message);
//
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        return message;
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "list";
//        }
//        switch (action) {
//            case "add":
////                showAddForm(request, response);
//                break;
//            case "edit":
////                showEditForm(request, response);
//                break;
//            case "delete":
////                showDeleteForm(request, response);
//                break;
//            case "view":
////                viewCustomer(request,response);
//                break;
//            case "search_by_name":
//                searchCustomerByName(request, response);
//            default:
//                listCustomer(request, response);
//                break;
//        }
    }

//    private String searchCustomerByName(HttpServletRequest request, HttpServletResponse response) {
//        boolean customerSearched = false;
//        String message = "";
//        List<CustomerDTO> customerDTOList = null;
//        try {
//            String customerNameSearch = request.getParameter("customerNameSearch");
//            customerDTOList = this.customerBO.searchCustomerByName(customerNameSearch);
//            if (customerDTOList == null) {
//                message += "Customer Name " + '"' + customerNameSearch + '"' + " is not found";
//            } else {
//                message = "Customer Name " + '"' + customerNameSearch + '"';
//            }
//
//            request.setAttribute("customerDTOList", customerDTOList);
//            request.setAttribute("message", message);
//
//            List<Position> positionList = this.positionBO.listPosition();
//            request.setAttribute("positionList", positionList);
//
//            List<Level> levelList = this.levelBO.listLevel();
//            request.setAttribute("levelList", levelList);
//
//            List<Department> departmentList = this.departmentBO.listDepartment();
//            request.setAttribute("departmentList", departmentList);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list_customer.jsp");
//            dispatcher.forward(request, response);
//
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//        return message;
//    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            List<CustomerDTO> customerDTOList = this.customerBO.listCustomer();
//            request.setAttribute("customerDTOList", customerDTOList);
//
//            List<Position> positionList = this.positionBO.listPosition();
//            request.setAttribute("positionList", positionList);
//
//            List<Level> levelList = this.levelBO.listLevel();
//            request.setAttribute("levelList", levelList);
//
//            List<Department> departmentList = this.departmentBO.listDepartment();
//            request.setAttribute("departmentList", departmentList);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list_customer.jsp");
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }
}
