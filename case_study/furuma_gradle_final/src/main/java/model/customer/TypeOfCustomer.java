package model.customer;

public class TypeOfCustomer {
    private Integer typeOfCustomerId;
    private String typeOfCustomerName;

    @Override
    public String toString() {
        return "TypeOfCustomer{" +
                "typeOfCustomerId=" + typeOfCustomerId +
                ", typeOfCustomerName='" + typeOfCustomerName + '\'' +
                '}';
    }

    public Integer getTypeOfCustomerId() {
        return typeOfCustomerId;
    }

    public void setTypeOfCustomerId(Integer typeOfCustomerId) {
        this.typeOfCustomerId = typeOfCustomerId;
    }

    public String getTypeOfCustomerName() {
        return typeOfCustomerName;
    }

    public void setTypeOfCustomerName(String typeOfCustomerName) {
        this.typeOfCustomerName = typeOfCustomerName;
    }

    public TypeOfCustomer(Integer typeOfCustomerId, String typeOfCustomerName) {
        this.typeOfCustomerId = typeOfCustomerId;
        this.typeOfCustomerName = typeOfCustomerName;
    }

    public TypeOfCustomer() {
    }
}
