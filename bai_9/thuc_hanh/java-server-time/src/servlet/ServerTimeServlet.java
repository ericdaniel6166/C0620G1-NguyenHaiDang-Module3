package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//Bước 3: Đặt đường dẫn cho ServerTimeServlet là "/index"

@WebServlet(name = "ServerTimeServlet", urlPatterns = "/index")
public class ServerTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    index không viết method post/get thì default là doGet

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Nhập đoạn mã sau đây vào trong phương thức doGet() của ServerTimeServlet:

        PrintWriter writer = response.getWriter();

        Date today = new Date();

        writer.println("<html>");
        writer.println("<h1>Hello world</h1>");
        writer.println("<h1>" + today + "</h1>");
        writer.println("</html>");
    }
}
