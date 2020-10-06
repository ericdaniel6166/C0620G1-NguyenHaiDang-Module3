package model.customer;

public class Customer {
    private Integer customerId;
    private Integer typeOfCustomerId;
    private String customerName;
    private String dateOfBirth;
    private String idNumber;
    private String phone;
    private String email;
    private String address;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", typeOfCustomerId=" + typeOfCustomerId +
                ", customerName='" + customerName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTypeOfCustomerId() {
        return typeOfCustomerId;
    }

    public void setTypeOfCustomerId(Integer typeOfCustomerId) {
        this.typeOfCustomerId = typeOfCustomerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(Integer customerId, Integer typeOfCustomerId, String customerName, String dateOfBirth, String idNumber, String phone, String email, String address) {
        this.customerId = customerId;
        this.typeOfCustomerId = typeOfCustomerId;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.idNumber = idNumber;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer() {
    }
}
