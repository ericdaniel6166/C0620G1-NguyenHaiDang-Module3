package dao;

import model.TrangThai;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiDAOImpl implements TrangThaiDAO {
    public static final String SELECT_COLOR_NAME_BY_ID = "select * from trang_thai where trang_thai_id=?; ;";
    public static final String SELECT_ALL_COLOR = "SELECT * FROM trang_thai;";
    private BaseDAO baseDAO = new BaseDAO();


    @Override
    public List<TrangThai> listTrangThai() {
        List<TrangThai> trangThaiList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_COLOR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String trangThaiId = (resultSet.getString("trang_thai_id"));
                String trangThaiTen = resultSet.getString("trang_thai_ten");
                TrangThai trangThai = new TrangThai(trangThaiId, trangThaiTen);
                trangThaiList.add(trangThai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trangThaiList;
    }

    @Override
    public TrangThai searchTrangThaiById(String id) {
        TrangThai trangThai = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_COLOR_NAME_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String trangThaiId = (resultSet.getString("trang_thai_id"));
                String trangThaiTen = resultSet.getString("trang_thai_ten");
                trangThai = new TrangThai(trangThaiId, trangThaiTen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trangThai;
    }
}
