package main.java.model;

public class Accountant extends Person {
    private String fullName;
    private String major; //what  he studied
    private int salary;

    public Accountant(int id, String fullName, String major, String gender, String birthDate, String email, String address, String phone, int salary) {
        super(id, gender, birthDate, email, address, phone);
        this.fullName = fullName;
        this.major = major;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                "fullName='" + fullName + '\'' +
                ", major='" + major + '\'' +
                ", email='" + super.getEmail() + '\'' +
                '}';
    }
}
