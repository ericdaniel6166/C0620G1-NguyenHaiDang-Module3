package model;

public class MatBang {
//    ma_mat_bang varchar(45),
//    trang_thai_id int,
//    dien_tich int,
//    tang int,
//    loai_mat_bang_id int,
//    gia_tien double,
//    ngay_bat_dau date,
//    ngay_ket_thuc date,

    private String maMatBang;
    private String trangThaiId;
    private String dienTich;
    private String tang;
    private String loaiMatBangId;
    private String giaTien;
    private String ngayBatDau;
    private String ngayKetThuc;

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public String getTrangThaiId() {
        return trangThaiId;
    }

    public void setTrangThaiId(String trangThaiId) {
        this.trangThaiId = trangThaiId;
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

    public String getLoaiMatBangId() {
        return loaiMatBangId;
    }

    public void setLoaiMatBangId(String loaiMatBangId) {
        this.loaiMatBangId = loaiMatBangId;
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

    public MatBang(String maMatBang, String trangThaiId, String dienTich, String tang, String loaiMatBangId, String giaTien, String ngayBatDau, String ngayKetThuc) {
        this.maMatBang = maMatBang;
        this.trangThaiId = trangThaiId;
        this.dienTich = dienTich;
        this.tang = tang;
        this.loaiMatBangId = loaiMatBangId;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang() {
    }
}
