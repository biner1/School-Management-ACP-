package main.java.model;

public class Student extends Person {

    private String fullName;
    private int classId;

    public Student(int id, String fullName,String username, String gender, String birthDate, String email, String address, String phone, int classId) {
        super(id,username, gender, birthDate, email, address, phone);
        this.fullName = fullName;
        this.classId = classId;
    }

    public Student(int id, String fullName, String username, String gender, String birthDate, String email, String address, String phone, String userPassword, int classId) {
        super(id, username, gender, birthDate, email, address, phone, userPassword);
        this.fullName = fullName;
        this.classId = classId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + fullName + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                '}';
    }
}
