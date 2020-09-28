package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
//        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
//        char operator = request.getParameter("operator").charAt(0);
//
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Result:</h1>");
//        try{
////            method calculate cuả class Calculator
//            float result = Calculator.calculate(firstOperand, secondOperand, operator);
//            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
//        }catch (Exception ex){
//            writer.println("Error: " + ex.getMessage());
//        }
//        writer.println("</html>");

//        //    dùng String cho operator
//
//        String operator = request.getParameter("operator");
//
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Result:</h1>");
//        try{
////            method calculate cuả class Calculator
//            float result = Calculator.calculate(firstOperand, secondOperand, operator);
//            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
//        }catch (Exception ex){
//            writer.println("Error: " + ex.getMessage());
//        }
//        writer.println("</html>");

        //    dùng String cho operator

        String operator = request.getParameter("operator");
//
//
        boolean checkException = false;
        try{
            float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
            float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
//            method calculate cuả class Calculator
            request.setAttribute("checkException",checkException);
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            request.setAttribute("result",result);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }catch (Exception ex){
            checkException = true;
            request.setAttribute("checkException",checkException);
            request.setAttribute("ex",ex);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
