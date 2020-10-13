package dao;

import model.TrangThai;

import java.util.List;

public interface TrangThaiDAO {
    List<TrangThai> listTrangThai();

    TrangThai searchTrangThaiById(String id);
}
