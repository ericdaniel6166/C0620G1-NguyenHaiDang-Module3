package dto;

public class MatBangDTO {
    //    ma_mat_bang,
//    dien_tich,
//    tang,
//    gia_tien,
//    ngay_bat_dau,
//    ngay_ket_thuc,
//    lmb.loai_mat_bang_id,
//    loai_mat_bang_ten,
//    tt.trang_thai_id,
//    trang_thai_ten
    private String maMatBang;
    private String dienTich;
    private String tang;
    private String giaTien;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String loaiMatBangId;
    private String loaiMatBangTen;
    private String trangThaiId;
    private String trangThaiTen;

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public String getTang() {
        return tang;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLoaiMatBangId() {
        return loaiMatBangId;
    }

    public void setLoaiMatBangId(String loaiMatBangId) {
        this.loaiMatBangId = loaiMatBangId;
    }

    public String getLoaiMatBangTen() {
        return loaiMatBangTen;
    }

    public void setLoaiMatBangTen(String loaiMatBangTen) {
        this.loaiMatBangTen = loaiMatBangTen;
    }

    public String getTrangThaiId() {
        return trangThaiId;
    }

    public void setTrangThaiId(String trangThaiId) {
        this.trangThaiId = trangThaiId;
    }

    public String getTrangThaiTen() {
        return trangThaiTen;
    }

    public void setTrangThaiTen(String trangThaiTen) {
        this.trangThaiTen = trangThaiTen;
    }

    public MatBangDTO(String maMatBang, String dienTich, String tang, String giaTien, String ngayBatDau, String ngayKetThuc, String loaiMatBangId, String loaiMatBangTen, String trangThaiId, String trangThaiTen) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.tang = tang;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.loaiMatBangId = loaiMatBangId;
        this.loaiMatBangTen = loaiMatBangTen;
        this.trangThaiId = trangThaiId;
        this.trangThaiTen = trangThaiTen;
    }

    public MatBangDTO() {
    }
}
