package com.codegym.dao;

import com.codegym.model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    //    Bước 5: Tạo lớp truy cập cơ sở dữ liệu:
//
//

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select * from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    private static final String SORT_USERS_BY_NAME = "select * from users order by name;";

    //    **********
//    Tìm tương đối
//    *******
//    Cách 1
//    ***********
//    private static final String SEARCH_USERS_BY_COUNTRY = "select * from users where country like ?;";
//    *******
//    Cách 2
//    **********
    private static final String SEARCH_USERS_BY_COUNTRY = "select * from users where country like concat('%',?,'%');";

    //    **********
//    Tìm tuyệt đối
//    *********
//    private static final String SEARCH_USERS_BY_COUNTRY = "select * from users where country = ?;";
//    **********

    //    [Thực hành] Thực thi SQL không sử dụng Transaction
//    **********
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";
//    *************

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
            printSQLException(e);
        }

    }

    @Override
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            printSQLException(e);
        }
        return users;
    }

//    *******
    @Override
    public List<User> selectAllUsersUseTransaction() {
        List<User> users = new ArrayList<>();
        String query = "call select_all_users();";
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             CallableStatement callableStatement = connection.prepareCall(query);) {
            // Step 3: Execute the query or update query
            ResultSet resultSet = callableStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
//    ************
    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//    ********


    @Override
    public boolean deleteUserUseTransaction(int id) throws SQLException {
        boolean rowDeleted;
        String query = "call delete_users(?);";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


//    ******
    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
//    *********

    @Override
    public boolean updateUserUseTransaction(User user) throws SQLException {
        boolean rowUpdated;
        String query = "call update_users(?,?,?,?);";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.setInt(4, user.getId());
            rowUpdated = callableStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    //    **********
//    12. JDBC & CRUD
//    [Bài tập] Cập nhật ứng dụng quản lý UserAssignment
//    ************

    @Override
    public List<User> sortUsersByName() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_BY_NAME);) {

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            printSQLException(e);
        }
        return users;
    }

    @Override
    public List<User> searchUsersByCountry(String countrySearch) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_BY_COUNTRY);) {
            //    **********
            //    Tìm tương đối
//            Cách 1
            //    *******
//            preparedStatement.setString(1, "%"+ countrySearch+"%");
//            **********
//            Cách 2
//            ***********
            preparedStatement.setString(1, countrySearch);
//            **********
//            Tìm tuyệt đối
//            *******
//            preparedStatement.setString(1, countrySearch);
//            ***********
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            printSQLException(e);
        }
        return users;
    }

    //    ************
//    13. JDBC Querying & Transaction
//    [Thực hành] Gọi MySql Stored Procedures từ JDBC
//    ***********
    //    Bước 3: Cập nhật lớp UserDAO, override 2 phương thức
    //    ********
    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet rs = callableStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
//    ******
//    13. JDBC Querying & Transaction
//    *********
//    [Thực hành] MySql JDBC Transaction
//    *********

    @Override
    public void addUserTransaction(User user, int[] permision) {
        Connection connection = null;

        // for insert a new user
        PreparedStatement preparedStatementInsert = null;

        // for assign permision to user
        PreparedStatement preparedStatementAssignment = null;

        // for getting user i
        ResultSet rs = null;

        try {
            connection = getConnection();
            // set auto commit to false
            connection.setAutoCommit(false);
            //
            // Insert user
            //
            preparedStatementInsert = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatementInsert.setString(1, user.getName());
            preparedStatementInsert.setString(2, user.getEmail());
            preparedStatementInsert.setString(3, user.getCountry());
            int rowAffected = preparedStatementInsert.executeUpdate();
            // get user id
            rs = preparedStatementInsert.getGeneratedKeys();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }
            //
            // in case the insert operation successes, assign permision to user
            //
            if (rowAffected == 1) {
                // assign permision to user
                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "
                        + "VALUES(?,?)";
                preparedStatementAssignment = connection.prepareStatement(sqlPivot);
                for (int permisionId : permision) {
                    preparedStatementAssignment.setInt(1, userId);
                    preparedStatementAssignment.setInt(2, permisionId);
                    preparedStatementAssignment.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException ex) {
            // roll back the transaction
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatementInsert != null) {
                    preparedStatementInsert.close();
                }
                if (preparedStatementAssignment != null) {
                    preparedStatementAssignment.close();
                }
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    **********
    //    ******
//    13. JDBC Querying & Transaction
//    *********
//    [Thực hành] Thực thi SQL không sử dụng Transaction
//    *********

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);
            // Run list of insert commands
            preparedStatementInsert.setString(1, "Quynh");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.execute();
            preparedStatementInsert.setString(1, "Ngan");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.execute();
            // Run list of update commands
            // below line caused error, test transaction
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
            preparedStatementUpdate.setBigDecimal(2, new BigDecimal(999.99));
            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            preparedStatementUpdate.setString(2, "Quynh");
            preparedStatementUpdate.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
//    **********
    //    ******
//    13. JDBC Querying & Transaction
//    *********
//    [Thực hành] Thực thi SQL có sử dụng Transaction
//    *********

    @Override
    public void insertUpdateUseTransaction() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);
//            Trong đoạn mã trên, để cho phép Transaction,
//            chúng ta thiết lập auto commit là "false" như sau:
            // start transaction block
            connection.setAutoCommit(false); // default true
            // Run list of insert commands
            preparedStatementInsert.setString(1, "Quynh");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.execute();
            preparedStatementInsert.setString(1, "Ngan");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.execute();
            // Run list of update commands
            // below line caused error, test transaction
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
//            preparedStatementUpdate.setBigDecimal(2, new BigDecimal(999.99));
            preparedStatementUpdate.setBigDecimal(1, new BigDecimal(999.99));
            preparedStatementUpdate.setString(2, "Quynh");
            preparedStatementUpdate.execute();
//            Kết thúc khối lệnh, gọi phương thức commit(),
//                    sau đó thiết lập lại auto commit là "true" như sau:
            // end transaction block, commit changes
            connection.commit();
            // good practice to set it back to default true
            connection.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

//    **********




    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
