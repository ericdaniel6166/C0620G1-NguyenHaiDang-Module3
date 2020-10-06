package bo;

import dao.StudentDAO;
import dao.StudentDAOTransactionImpl;
import model.Student;

import java.util.List;

public class StudentBOTransactionImpl implements StudentBO {

    StudentDAO studentDAO = new StudentDAOTransactionImpl();

    @Override
    public List<Student> findAll() {
        return this.studentDAO.findAll();
    }

    @Override
    public String save(Student student) {
        return studentDAO.save(null);
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public String edit(Student student) {
        return null;
    }

    @Override
    public String deleteById(String id) {
        return null;
    }
}
