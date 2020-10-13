package model;

public class TrangThai {
    private String trangThaiId;
    private String trangThaiTen;

    @Override
    public String toString() {
        return "Color{" +
                "colorId='" + trangThaiId + '\'' +
                ", colorName='" + trangThaiTen + '\'' +
                '}';
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

    public TrangThai(String trangThaiId, String trangThaiTen) {
        this.trangThaiId = trangThaiId;
        this.trangThaiTen = trangThaiTen;
    }

    public TrangThai() {
    }
}
