package dao;

import dto.MatBangDTO;
import model.MatBang;

import java.util.List;

public interface MatBangDAO {

    List<MatBangDTO> listMatBang();

    boolean addMatBang(MatBang matBang);

//    boolean editMatBang(MatBang matBang);

    boolean deleteMatBang(String id);

    MatBangDTO searchMatBangById(String id);

//    List<MatBangDTO> searchMatBangByName(String name);
    List<MatBangDTO> searchMatBang(String tang, String giaTien,String loaiMatBangTen);



}
