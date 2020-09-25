package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = "/abcServlet")
public class SumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numOne = request.getParameter("num1");
        String numTwo = request.getParameter("num2");
        int result = Integer.parseInt(numOne) + Integer.parseInt(numTwo);

//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<html>");
//        printWriter.print("<body>");
//        printWriter.print("<h2 style='color: red'>" + result + "</h2>");
//        printWriter.print("</body>");
//        printWriter.print("</html>");

        // autoboxing, Wrapper class, autoboxing, unboxing
        request.setAttribute("total", String.valueOf(result));

        // FORWARD
        request.getRequestDispatcher("result_sum.jsp").forward(request, response);

        // REDIRECT
//        response.sendRedirect("result_sum.jsp");

//        ADVANCE
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
