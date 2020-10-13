package bo;

import model.TrangThai;

import java.util.List;

public interface TrangThaiBO {
    List<TrangThai> listTrangThai();

    TrangThai searchTrangThaiById(String id);
}
