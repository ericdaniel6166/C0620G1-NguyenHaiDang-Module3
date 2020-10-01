package com.codegym.dao;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
//    Bước 4: Tạo interface IUserDAO:
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

//    **********
//    12. JDBC & CRUD
//    [Bài tập] Cập nhật ứng dụng quản lý UserAssignment
//    ************

    List<User> sortUsersByName();
    List<User> searchUsersByCountry(String countrySearch);

//    ************
//    13. JDBC Querying & Transaction
//    [Thực hành] Gọi MySql Stored Procedures từ JDBC
//    ***********
//    Bước 2: Trên ứng dụng, cập nhật interface IUserDAO, thêm khai báo của 2 phương thức sau:
//    ********
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

//    ******
//    13. JDBC Querying & Transaction
//    *********
//    [Thực hành] MySql JDBC Transaction
//    *********
    void addUserTransaction(User user, int[] permision);

//    *********
//    13. JDBC Querying & Transaction
//    *********
//    [Thực hành] Thực thi SQL không sử dụng Transaction
//    ***************
    void insertUpdateWithoutTransaction();
    //    *********
//    13. JDBC Querying & Transaction
//    *********
//    [Thực hành] Thực thi SQL có sử dụng Transaction
//    ***************
    void insertUpdateUseTransaction();
    //    *********
//    13. JDBC Querying & Transaction
//    *********
//    [Bài tập] Gọi MySql Stored Procedures từ JDBC
//    ***************
//    Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
//    Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
//    Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
//    **********
    List<User> selectAllUsersUseTransaction();

    boolean deleteUserUseTransaction(int id) throws SQLException;

    boolean updateUserUseTransaction(User user) throws SQLException;

}
