package dao;

import dto.MatBangDTO;
import model.MatBang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangDAOImpl implements MatBangDAO {
    public static final String LIST_MAT_BANG_VIEW = "select * from view_mat_bang;";
    private static final String INSERT_MAT_BANG = "insert into mat_bang values (?,?,?,?,?,?,?,?);";
    private static final String UPDATE_MAT_BANG = "update matBang set matBang_name=?,price=?,quantity=?,color_id=?,category_id=?, description=? where matBang_id=?;";
    private static final String DELETE_MAT_BANG = "DELETE FROM mat_bang WHERE ma_mat_bang = ?;";

    private static final String SEARCH_MAT_BANG_BY_ID_VIEW = "select * from view_mat_bang where ma_mat_bang = ?;";
    private static final String SEARCH_MAT_BANG_BY_NAME_VIEW = "SELECT * FROM view_matBang WHERE matBang_name LIKE CONCAT('%',?,'%');";
    private static final String SEARCH_MAT_BANG = "SELECT * FROM view_mat_bang WHERE tang LIKE CONCAT('%', ?, '%') and gia_tien like CONCAT('%', ?, '%') and loai_mat_bang_ten like CONCAT('%', ?, '%');";

    private BaseDAO baseDAO = new BaseDAO();
    @Override
    public List<MatBangDTO> listMatBang() {
        List<MatBangDTO> matBangDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(LIST_MAT_BANG_VIEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String maMatBang = (resultSet.getString("ma_mat_bang"));
                String dienTich = resultSet.getString("dien_tich");

                String tang = (resultSet.getString("tang"));
                String giaTien = resultSet.getString("gia_tien");

                String ngayBatDau = (resultSet.getString("ngay_bat_dau"));
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");


                String loaiMatBangId = resultSet.getString("loai_mat_bang_id");
                String loaiMatBangTen = resultSet.getString("loai_mat_bang_ten");
                String trangThaiId = resultSet.getString("trang_thai_id");
                String trangThaiTen = resultSet.getString("trang_thai_ten");
                MatBangDTO matBangDTO = new MatBangDTO(maMatBang,dienTich,tang,giaTien,ngayBatDau,ngayKetThuc,loaiMatBangId,loaiMatBangTen, trangThaiId,trangThaiTen);
                matBangDTOList.add(matBangDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangDTOList;
    }

    @Override
    public MatBangDTO searchMatBangById(String id) {
        MatBangDTO matBangDTO = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_MAT_BANG_BY_ID_VIEW);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String maMatBang = (resultSet.getString("ma_mat_bang"));
                String dienTich = resultSet.getString("dien_tich");

                String tang = (resultSet.getString("tang"));
                String giaTien = resultSet.getString("gia_tien");

                String ngayBatDau = (resultSet.getString("ngay_bat_dau"));
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");


                String loaiMatBangId = resultSet.getString("loai_mat_bang_id");
                String loaiMatBangTen = resultSet.getString("loai_mat_bang_ten");
                String trangThaiId = resultSet.getString("trang_thai_id");
                String trangThaiTen = resultSet.getString("trang_thai_ten");
                matBangDTO = new MatBangDTO(maMatBang,dienTich,tang,giaTien,ngayBatDau,ngayKetThuc,loaiMatBangId,loaiMatBangTen, trangThaiId,trangThaiTen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangDTO;
    }

    @Override
    public boolean addMatBang(MatBang matBang) {
        boolean rowInsert = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_MAT_BANG);
            String maMatBang = matBang.getMaMatBang();
//            if (!"".equals(maMatBang)) {
//                preparedStatement.setString(1, maMatBang);
//            } else {
//                preparedStatement.setString(1, null);
//            }

            preparedStatement.setString(1, maMatBang);

            preparedStatement.setString(2, matBang.getTrangThaiId());
            preparedStatement.setString(3, matBang.getDienTich());
            preparedStatement.setString(4, matBang.getTang());
            preparedStatement.setString(5, matBang.getLoaiMatBangId());
            preparedStatement.setString(6, matBang.getGiaTien());
            preparedStatement.setString(7, matBang.getNgayBatDau());
            preparedStatement.setString(8, matBang.getNgayKetThuc());

            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
        
    }

    @Override
    public boolean deleteMatBang(String id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_MAT_BANG);
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<MatBangDTO> searchMatBang(String tang, String giaTien, String loaiMatBangTen) {
        List<MatBangDTO> matBangDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_MAT_BANG);
            preparedStatement.setString(1, tang);
            preparedStatement.setString(2, giaTien);
            preparedStatement.setString(3, loaiMatBangTen);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = (resultSet.getString("ma_mat_bang"));
                String dienTich = resultSet.getString("dien_tich");

                String tangSearch = (resultSet.getString("tang"));
                String giaTienSearch = resultSet.getString("gia_tien");

                String ngayBatDau = (resultSet.getString("ngay_bat_dau"));
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");


                String loaiMatBangId = resultSet.getString("loai_mat_bang_id");
                String loaiMatBangTenSearch = resultSet.getString("loai_mat_bang_ten");
                String trangThaiId = resultSet.getString("trang_thai_id");
                String trangThaiTen = resultSet.getString("trang_thai_ten");
                MatBangDTO matBangDTO = new MatBangDTO(maMatBang,dienTich,tangSearch,giaTienSearch,ngayBatDau,ngayKetThuc,loaiMatBangId,loaiMatBangTenSearch, trangThaiId,trangThaiTen);
                matBangDTOList.add(matBangDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangDTOList;
    }
}
