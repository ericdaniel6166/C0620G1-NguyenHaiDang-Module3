package dto.employee;

public class EmployeeDTO {
    private Integer employeeId;
    private String employeeName;
    private Integer positionId;
    private String positionName;
    private Integer levelId;
    private String levelName;
    private Integer departmentId;
    private String departmentName;
    private String dateOfBirth;
    private String idNumber;
    private Double salary;
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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

    public EmployeeDTO(Integer employeeId, String employeeName, Integer positionId, String positionName, Integer levelId, String levelName, Integer departmentId, String departmentName, String dateOfBirth, String idNumber, double salary, String phone, String email, String address) {
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
