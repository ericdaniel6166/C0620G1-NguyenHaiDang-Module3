package servlet;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//urlPatterns = {"", "/customer"}
//hoặc một trong 2 cái urlPatterns

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList();
        Customer customer1 = new Customer("Mai Văn Hoàn", "1983-08-23", "Hà Nội", "https://icdn.dantri.com.vn/k:72b62a2872/2015/11/19/thay-giao1-1447903697979/the-he-8x-9x-thay-doi-hinh-anh-nguoi-lam-nghe-day-hoc.jpg");
        Customer customer2 = new Customer("Trần Văn Hoàn", "1983-08-23", "Hà Nội", "https://icdn.dantri.com.vn/k:72b62a2872/2015/11/19/thay-giao1-1447903697979/the-he-8x-9x-thay-doi-hinh-anh-nguoi-lam-nghe-day-hoc.jpg");
        customerList.add(customer1);
        customerList.add(customer2);
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }
}
