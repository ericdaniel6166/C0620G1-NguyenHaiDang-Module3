package model;

public class Color {
    private String colorId;
    private String colorName;

    @Override
    public String toString() {
        return "Color{" +
                "colorId='" + colorId + '\'' +
                ", colorName='" + colorName + '\'' +
                '}';
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Color(String colorId, String colorName) {
        this.colorId = colorId;
        this.colorName = colorName;
    }

    public Color() {
    }
}
