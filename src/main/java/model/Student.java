package main.java.model;

public class Student extends Person {

    private int gradeId;

    public Student(int id, String userName, String gender, String birthDate, String email, String address, String phone, int gradeId) {
        this(id, userName, gender, birthDate, email, address, phone, gradeId,null);
        this.gradeId = gradeId;
    }
    public Student(int id, String userName, String gender, String birthDate, String email, String address, String phone, int gradeId, String password) {
        super(id, userName, gender, birthDate, email, address, phone, password);
        this.gradeId = gradeId;
    }


    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + super.getUserName() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                '}';
    }
}
