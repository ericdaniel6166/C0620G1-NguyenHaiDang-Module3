package model.service;

public class TypeOfRent {
    private String typeOfRentId;
    private String typeOfRentName;
    private String typeOfRentPrice;

    @Override
    public String toString() {
        return "TypeOfRent{" +
                "typeOfRentId='" + typeOfRentId + '\'' +
                ", typeOfRentName='" + typeOfRentName + '\'' +
                ", typeOfRentPrice='" + typeOfRentPrice + '\'' +
                '}';
    }

    public String getTypeOfRentId() {
        return typeOfRentId;
    }

    public void setTypeOfRentId(String typeOfRentId) {
        this.typeOfRentId = typeOfRentId;
    }

    public String getTypeOfRentName() {
        return typeOfRentName;
    }

    public void setTypeOfRentName(String typeOfRentName) {
        this.typeOfRentName = typeOfRentName;
    }

    public String getTypeOfRentPrice() {
        return typeOfRentPrice;
    }

    public void setTypeOfRentPrice(String typeOfRentPrice) {
        this.typeOfRentPrice = typeOfRentPrice;
    }

    public TypeOfRent(String typeOfRentId, String typeOfRentName, String typeOfRentPrice) {
        this.typeOfRentId = typeOfRentId;
        this.typeOfRentName = typeOfRentName;
        this.typeOfRentPrice = typeOfRentPrice;
    }

    public TypeOfRent() {
    }
}
