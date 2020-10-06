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

    @Override
    public Student findById(String id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement
                    = this.baseDAO.getConnection().prepareStatement("select id, `name`, date_of_birth " +
                                                                        "from student " +
                                                                        "where id = ?");
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            student = new Student(resultSet.getString("name"),
                    resultSet.getString("date_of_birth"));
            student.setId(Integer.valueOf(id));
            // String -> int
            // Integer.valueOf
            // int -> String
            // String.valueOf


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public String edit(Student student) {
        try {
            PreparedStatement preparedStatement
                    = this.baseDAO.getConnection().prepareStatement("update student " +
                        "set `name` = ?, date_of_birth = ? " +
                        "where id = ?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());
            preparedStatement.setString(3, String.valueOf(student.getId()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "OK";
    }

    @Override
    public String deleteById(String id) {
        try {
            PreparedStatement preparedStatement
                    = this.baseDAO.getConnection().prepareStatement("delete from student " +
                    "where id = ?");
            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "OK";
    }
}
