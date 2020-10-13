package dao;

import model.LoaiMatBang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiMatBangDAOImpl implements LoaiMatBangDAO {
    public static final String SELECT_CATEGORY_NAME_BY_ID = "select * from loai_mat_bang where loai_mat_bang_id=?;";
    public static final String SELECT_ALL_CATEGORY = "select * from loai_mat_bang;;";
    private BaseDAO baseDAO = new BaseDAO();


    @Override
    public List<LoaiMatBang> listLoaiMatBang() {
        List<LoaiMatBang> loaiMatBangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String loaiMatBangId = (resultSet.getString("loai_mat_bang_id"));
                String loaiMatBangTen = resultSet.getString("loai_mat_bang_ten");
                LoaiMatBang loaiMatBang = new LoaiMatBang(loaiMatBangId, loaiMatBangTen);
                loaiMatBangList.add(loaiMatBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiMatBangList;
    }

    @Override
    public LoaiMatBang searchLoaiMatBangById(String id) {
        LoaiMatBang loaiMatBang = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_CATEGORY_NAME_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String loaiMatBangId = (resultSet.getString("loai_mat_bang_id"));
                String loaiMatBangTen = resultSet.getString("loai_mat_bang_ten");
                loaiMatBang = new LoaiMatBang(loaiMatBangId, loaiMatBangTen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiMatBang;
    }
}
