package model;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private Integer positionId;
    private Integer levelId;
    private Integer departmentId;
    private String dateOfBirth;
    private String idNumber;
    private double salary;
    private String phone;
    private String email;
    private String address;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, Integer positionId, Integer levelId, Integer departmentId, String dateOfBirth, String idNumber, double salary, String phone, String email, String address) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.positionId = positionId;
        this.levelId = levelId;
        this.departmentId = departmentId;
        this.dateOfBirth = dateOfBirth;
        this.idNumber = idNumber;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", positionId=" + positionId +
                ", levelId=" + levelId +
                ", departmentId=" + departmentId +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", salary=" + salary +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
