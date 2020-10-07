package dto.employee;

public class EmployeeDTO {
    private String employeeId;
    private String employeeName;
    private String positionId;
    private String positionName;
    private String levelId;
    private String levelName;
    private String departmentId;
    private String departmentName;
    private String dateOfBirth;
    private String idNumber;
    private String salary;
    private String phone;
    private String email;
    private String address;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", salary=" + salary +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public EmployeeDTO(String employeeId, String employeeName, String positionId, String positionName, String levelId, String levelName, String departmentId, String departmentName, String dateOfBirth, String idNumber, String salary, String phone, String email, String address) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.positionId = positionId;
        this.positionName = positionName;
        this.levelId = levelId;
        this.levelName = levelName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.dateOfBirth = dateOfBirth;
        this.idNumber = idNumber;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public EmployeeDTO() {
    }
}
