package bo;

import model.LoaiMatBang;

import java.util.List;

public interface LoaiMatBangBO {
    List<LoaiMatBang> listLoaiMatBang();

    LoaiMatBang searchLoaiMatBangById(String id);
}
