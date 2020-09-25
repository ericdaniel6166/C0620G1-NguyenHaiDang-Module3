package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
//    Lưu ý: Nếu quan sát trên url, sẽ có sự khác nahou:
//
//    Url với POST: http://localhost:8080/login
//    Url với GET: http://localhost:8080/login?username=admin&password=admin

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        phương thức request.getParameter() được sử dụng để lấy tham số được đẩy lên từ form.

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//
//        if ("admin".equals(username) && "admin".equals(password)) {
//            writer.println("<h1>Welcome " + username + " to website</h1>");
//        } else {
//            writer.println("<h1>Login Error</h1>");
//        }
//
//        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        if("admin".equals(username) && "admin".equals(password)) {
            writer.println("<h1>Welcome "+username+" to website</h1>");
        } else{
            writer.println("<h1>Login Error</h1>");
        }

        writer.println("</html>");
    }
}
