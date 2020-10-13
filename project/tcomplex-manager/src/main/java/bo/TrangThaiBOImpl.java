package bo;

import dao.TrangThaiDAO;
import dao.TrangThaiDAOImpl;
import model.TrangThai;

import java.util.List;

public class TrangThaiBOImpl implements TrangThaiBO {
    private TrangThaiDAO trangThaiDAO=new TrangThaiDAOImpl();

    @Override
    public List<TrangThai> listTrangThai() {
        return trangThaiDAO.listTrangThai();
    }

    @Override
    public TrangThai searchTrangThaiById(String id) {
        return trangThaiDAO.searchTrangThaiById(id);
    }
}
