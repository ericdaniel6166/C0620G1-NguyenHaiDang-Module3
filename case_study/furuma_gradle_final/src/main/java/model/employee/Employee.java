package model.employee;

public class Employee {
    private String employeeId;
    private String employeeName;
    private String positionId;
    private String levelId;
    private String departmentId;
    private String dateOfBirth;
    private String idNumber;
    private String salary;
    private String phone;
    private String email;
    private String address;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String positionId, String levelId, String departmentId, String dateOfBirth, String idNumber, String salary, String phone, String email, String address) {
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
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
