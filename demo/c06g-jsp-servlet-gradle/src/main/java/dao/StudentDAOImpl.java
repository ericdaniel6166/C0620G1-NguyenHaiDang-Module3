package dao;

import model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().
                            prepareStatement("select id, `name`, date_of_birth " +
                                    "from student " +
                                    "order by `name`");

            ResultSet resultSet = preparedStatement.executeQuery();

            Student student;
            while (resultSet.next()) {
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");

                student = new Student(id, name, dateOfBirth, 10, 1);
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public String save(Student student) {
        try {
            PreparedStatement preparedStatement
                    = this.baseDAO.getConnection().prepareStatement("insert into student(`name`, date_of_birth) " +
                        "values (?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "OK";
    }
}
