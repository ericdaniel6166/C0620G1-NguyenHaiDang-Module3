package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOTransactionImpl implements StudentDAO {

    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        try {
//            PreparedStatement preparedStatement =
//                    this.baseDAO.getConnection().
//                            prepareStatement("select id, `name`, date_of_birth " +
//                                    "from student " +
//                                    "order by `name`");
            CallableStatement callableStatement
                    = this.baseDAO.getConnection().prepareCall("call find_by_name_student(?)");
            callableStatement.setString(1, "O");

            ResultSet resultSet = callableStatement.executeQuery();

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
        String msg = "OK, transaction successfully!";
        Connection connection = this.baseDAO.getConnection();
        Savepoint chau = null;

        try {
            connection.setAutoCommit(false);

            PreparedStatement pSInsertClass =
                    connection.prepareStatement("insert into class (id, `name`, type_of_class_id)\n" +
                            "values (?, ?, ?)");
            pSInsertClass.setString(1, "4");
            pSInsertClass.setString(2, "C1020G1");
            pSInsertClass.setString(3, "1");
            int rowAffect = pSInsertClass.executeUpdate();

            msg = String.valueOf(rowAffect);
            chau = connection.setSavepoint("chau");

            PreparedStatement pSInsertStudent
                    = connection.prepareStatement("insert into student(`name`, date_of_birth, class_id) " +
                        "values (?, ?, ?)");
            pSInsertStudent.setString(1, "Nguyen Van A");
            pSInsertStudent.setString(2, "2020-09-303");
            pSInsertStudent.setString(3, "4");

            rowAffect += pSInsertStudent.executeUpdate();

            if (rowAffect == 2) {
                connection.commit();
            } else {
                msg = "rollback 1";
                connection.rollback();
            }

        } catch (SQLException e) {
            try {
                msg = "rollback 2";
//                connection.rollback();
                connection.rollback(chau);

                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return msg;
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
