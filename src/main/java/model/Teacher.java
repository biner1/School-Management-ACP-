package main.java.model;

public class Teacher extends Person {
    private String fullName;
    private String teaches; // lesson he teaches
    private int salary;

    public Teacher(int id, String fullName, String teaches, String gender, String birthDate, String email, String address, String phone, int salary) {
        super(id, gender, birthDate, email, address, phone);
        this.fullName = fullName;
        this.teaches = teaches;
        this.salary = salary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                ", teaches='" + teaches + '\'' +
                ", email='" + super.getEmail() + '\'' +
                '}';
    }
}
