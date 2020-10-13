package bo;

import dto.MatBangDTO;
import model.MatBang;

import java.util.List;

public interface MatBangBO {
    List<MatBangDTO> listMatBang();

    String addMatBang(MatBang matBang);

//    boolean editMatBang(MatBang matBang);

    String deleteMatBang(String id);

    MatBangDTO searchMatBangById(String id);

    //    List<MatBangDTO> searchMatBangByName(String name);
    List<MatBangDTO> searchMatBang(String tang, String giaTien,String loaiMatBangTen);
}
