package main.java.model;

public class Principal extends Person{
    private String fullName;
    private int salary;

    public Principal(int id, String fullName, String gender, String birthDate, String email, String address, String phone, int salary) {
        super(id, gender, birthDate, email, address, phone);
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "fullName='" + fullName + '\'' +
                ", email='" + super.getEmail() + '\'' +
                '}';
    }
}
