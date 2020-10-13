package model;

public class LoaiMatBang {
    private String loaiMatBangId;
    private String loaiMatBangTen;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + loaiMatBangId + '\'' +
                ", categoryName='" + loaiMatBangTen + '\'' +
                '}';
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

    public LoaiMatBang(String loaiMatBangId, String loaiMatBangTen) {
        this.loaiMatBangId = loaiMatBangId;
        this.loaiMatBangTen = loaiMatBangTen;
    }

    public LoaiMatBang() {
    }
}
