package bo;

import common.Validator;
import dao.MatBangDAO;
import dao.MatBangDAOImpl;
import dto.MatBangDTO;
import model.MatBang;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import static common.Validator.*;

public class MatBangBOImpl implements MatBangBO {
    MatBangDAO matBangDAO = new MatBangDAOImpl();

    @Override
    public List<MatBangDTO> listMatBang() {
        return this.matBangDAO.listMatBang();
    }

    @Override
    public String addMatBang(MatBang matBang) {
        String message = "";
        if (!Validator.regex(REGEX_MA_MAT_BANG, matBang.getMaMatBang())) {
            message += "Invalid MaMatBang <br>";
        } else if (this.searchMatBangById(matBang.getMaMatBang())!=null){
            message += "Invalid MaMatBang. Already exists <br>";
        }

        if (!Validator.regex(REGEX_POSITIVE_NUMBER, matBang.getDienTich())) {
            message += "Invalid DienTich. positive number <br>" ;
        } else if (Double.valueOf(matBang.getDienTich()) <= 20) {
            message += "DienTich >20 <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_INTEGER,matBang.getTang())){
            message += "Invalid Tang. Positive integer <br>";
        }else if (Integer.valueOf(matBang.getTang()) >15 ||Integer.valueOf(matBang.getTang()) <1) {
            message += "1<=Tang<=15 <br>";
        }
        if (!Validator.regex(REGEX_POSITIVE_NUMBER,matBang.getGiaTien())){
            message += "Invalid DienTich. positive number <br>" ;
        }else if(Double.valueOf(matBang.getGiaTien())<1500000){
            message += "GiaTien >=1500000 <br>";
        }
        LocalDate ngayBatDau = LocalDate.parse(matBang.getNgayBatDau());
        LocalDate ngayKetThuc = LocalDate.parse(matBang.getNgayKetThuc());
        Period periodDiff = Period.between(ngayBatDau, ngayKetThuc);
        if (periodDiff.getMonths()<6){
            message += "Invalid ngayKetThuc > ngayBatDau 6 thang<br>";
        }
        if (message == "") {
            this.matBangDAO.addMatBang(matBang);
            message = "Added";
        }
        return message;
    }

    @Override
    public String deleteMatBang(String id) {
        String message = "";
        if (message == "") {
            this.matBangDAO.deleteMatBang(id);
            message = "Deleted";
        }
        return message;
    }

    @Override
    public List<MatBangDTO> searchMatBang(String tang, String giaTien, String loaiMatBangTen) {
        return this.matBangDAO.searchMatBang(tang, giaTien, loaiMatBangTen);
    }

    @Override
    public MatBangDTO searchMatBangById(String id) {
        return this.matBangDAO.searchMatBangById(id);
    }
}
