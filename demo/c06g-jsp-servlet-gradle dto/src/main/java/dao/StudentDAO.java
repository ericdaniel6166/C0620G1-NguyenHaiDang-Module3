package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> findAll();

    String save(Student student);

    Student findById(String id);

    String edit(Student student);

    String deleteById(String id);


}
