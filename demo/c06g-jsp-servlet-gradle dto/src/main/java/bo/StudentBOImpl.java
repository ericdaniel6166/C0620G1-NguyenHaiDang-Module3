package bo;

import common.ValidateName;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> findAll() {
        return this.studentDAO.findAll();
    }

    @Override
    public String save(Student student) {
        String message = "";
        if (student.getName() == null || student.getName().equals("")) {
            message = "Please input name";
        } else if (!ValidateName.isValidName(student.getName())) {
            message = "Please do not input digit";
        } else {
            message = studentDAO.save(student);
        }

        return message;
    }

    @Override
    public Student findById(String id) {
        return this.studentDAO.findById(id);
    }

    @Override
    public String edit(Student student) {
        String message = "";
        if (student.getName() == null || student.getName().equals("")) {
            message = "Please input name";
        } else if (!ValidateName.isValidName(student.getName())) {
            message = "Please do not input digit";
        } else {
            message = studentDAO.edit(student);
        }

        return message;
    }

    @Override
    public String deleteById(String id) {
        return this.studentDAO.deleteById(id);
    }
}
