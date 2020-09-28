package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getParameter() để lấy value của biến từ request
        String productDescription = request.getParameter("productDescription");
        Double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        Double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));

        Double amount = listPrice * discountPercent * 0.01;

//        set attribute có string    tên là amount để trang jsp nhận biến amount của servlet
        request.setAttribute("amount", amount);
        request.setAttribute("productDescription", productDescription);

//        getRequestDispatcher trỏ đến trang jsp servlet forward tới
//        forward cả request và response đến trang jsp
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
