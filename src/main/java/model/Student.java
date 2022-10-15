package main.java.model;

public class Student extends Person {
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName, String gender, String birthDate, String email, String address, String phone) {
        super(id, gender, birthDate, email, address, phone);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                '}';
    }
}
