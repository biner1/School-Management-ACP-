package main.java.model;

public class Staff extends Person{

    private int salary;
    private StaffRole role;

    public Staff(int id, String userName, String gender, String birthDate, String email, String address, String phone, StaffRole role, int salary) {
        this(id, userName, gender, birthDate, email, address, phone, role, salary, null);
    }

    public Staff(int id, String userName, String gender, String birthDate, String email, String address, String phone, StaffRole role, int salary, String staffPassword) {
        super(id, userName, gender, birthDate, email, address, phone, staffPassword);
        this.salary = salary;
        this.role = role;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role.name();
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "userName='" + super.getUserName() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
