package main.java.model.models;

import java.util.Objects;
import java.io.Serializable;

public class StudentAttendance implements  Serializable{

    private int id;
    private String date;
    private int studentId;
    private String status;

    public StudentAttendance(int id, int studentId, String date, String status){
        this.id = id;
        this.date = date;
        this.studentId = studentId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate(){
        return date;
    };

    public void setDate(String date){
        this.date = date;
    };

    public int getStudentId(){
        return studentId;
    };

    public void setStudentId(int studentId){
        this.studentId = studentId;
    };

    public String getStatus(){
        return status;
    };

    public void setStatus(String status){
        this.status = status;
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