package controller;

import bo.*;
import model.Student;
import model.TypeOfClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/listStudent"})
public class StudentServlet extends HttpServlet {

    StudentBO studentBO = new StudentBOImpl();
    TypeOfClassBO typeOfClassBO = new TypeOfClassBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUserAbc = request.getParameter("actionUser");

        if (actionUserAbc == null) {
            response.sendRedirect("");
        } else if (actionUserAbc.equals("create")){
            String nameStudent = request.getParameter("nameStudent");
            String dateOfBirth = request.getParameter("dateOfBirth");

//            int idRandom = (int) (Math.random() * 1000);
            Student student = new Student(nameStudent, dateOfBirth);

            String message = this.studentBO.save(student);
            request.setAttribute("message", message);
            request.setAttribute("student", student);

            request.getRequestDispatcher("create.jsp").forward(request, response);
        } else if (actionUserAbc.equals("update")) {
            String id = request.getParameter("id");
            String nameStudent = request.getParameter("nameStudent");
            String dateOfBirth = request.getParameter("dateOfBirth");

            Student student = new Student(Integer.valueOf(id), nameStudent, dateOfBirth);

            String message = this.studentBO.edit(student);
            request.setAttribute("message", message);
            request.setAttribute("student", student);

            this.loadList(request, response);
        } else if (actionUserAbc.equals("createClass")) {
            request.getParameter("typeOfClass");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUserAbc = request.getParameter("actionUser");

        if (actionUserAbc == null) {
            this.loadList(request, response);
        } else if (actionUserAbc.equals("create")) {
            response.sendRedirect("create.jsp");
        } else if (actionUserAbc.equals("transaction")) {
            request.setAttribute("msgTransaction", this.studentBO.save(null));
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } else if (actionUserAbc.equals("update")) {
            String studentId = request.getParameter("id");
            Student student = this.studentBO.findById(studentId);

            request.setAttribute("student", student);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } else if (actionUserAbc.equals("delete")) {
            String studentId = request.getParameter("idStudentHidden");

            this.studentBO.deleteById(studentId);
            loadList(request, response);
        } else if (actionUserAbc.equals("createClass")) {

            List<TypeOfClass> typeOfClasses = this.typeOfClassBO.findAllTypeOfClass();
            request.setAttribute("typeOfClasses", typeOfClasses);
            request.getRequestDispatcher("create_class.jsp").forward(request, response);
        }
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = this.studentBO.findAll();


        request.setAttribute("abcList", studentList);
//        request.setAttribute("testVariable", "<script>location.href = 'https://www.google.com/'; </script>");
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

}
