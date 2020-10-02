package model;

import model.Department;
import model.Employee;
import model.Level;
import model.Position;

public class EmployeeView {
    Employee employee;
    Position position;
    Level level;
    Department department;

    @Override
    public String toString() {
        return "EmployeeView{" +
                "employee=" + employee +
                ", position=" + position +
                ", level=" + level +
                ", department=" + department +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeView(Employee employee, Position position, Level level, Department department) {
        this.employee = employee;
        this.position = position;
        this.level = level;
        this.department = department;
    }

    public EmployeeView() {
    }
}
