package main.java.model;
import java.util.Objects;

public class Subject {

    private int studentId;
    private String subjectName;
    private int teacherId;


    public Subject(int studentId, String subjectName , int teacherId){
        this.studentId=studentId;
        this.subjectName=subjectName;
        this.teacherId=teacherId;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId=studentId;
    }

    public String getSubjectName(){
        return subjectName;
    }

    public void setSubjectName(String subjectName){
        this.subjectName=subjectName;
    }

    public int getTeacherId(){
        return teacherId;
    }
    public void setTeacherId(int teacherId){
        this.teacherId=teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "Subject='" + subjectName + '\'' +
                '}';
    }
}
