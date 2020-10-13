package dao;

import model.LoaiMatBang;

import java.util.List;

public interface LoaiMatBangDAO {
    List<LoaiMatBang> listLoaiMatBang();

    LoaiMatBang searchLoaiMatBangById(String id);
}
