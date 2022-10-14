package main.java.model;
import java.util.Objects;

public class StudentAttendance {
    private String date;
    private int studentId;
    private String status;




    public StudentAttendance(String date, int studentId , String status){
        this.date=date;
        this.studentId=studentId;
        this.status=status;

    }

    public String getDate(){
        return date;
    };

    public void setDate(String date){
        this.date=date;
    };

    public int getStudentId(){
        return studentId;
    };

    public void setStudentId(int studentId){
        this.studentId=studentId;
    };

    public String getStatus(){
        return status;
    };

    public void setStatus(String status){
        this.status=status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }


    public String toString() {
        return "StudentAttendance{" +
                "date='" + date + '\''+
                "studentId='" + studentId+ '\'' +
                "status='" + status + '\''+
                '}';
    }
}