package bo;

import dao.LoaiMatBangDAO;
import dao.LoaiMatBangDAOImpl;
import model.LoaiMatBang;

import java.util.List;

public class LoaiMatBangBOImpl implements LoaiMatBangBO {
    LoaiMatBangDAO loaiMatBangDAO =new LoaiMatBangDAOImpl();
    @Override
    public List<LoaiMatBang> listLoaiMatBang() {
        return loaiMatBangDAO.listLoaiMatBang();
    }

    @Override
    public LoaiMatBang searchLoaiMatBangById(String id) {
        return loaiMatBangDAO.searchLoaiMatBangById(id);
    }
}
