package main.java.model;

import java.util.Objects;

public class TeacherAttendance {

    private String date;
    private String status;
    private int teacherId;


    public TeacherAttendance(String date , String status , int id){
        this.date=date;
        this.status=status;
        this.teacherId=id;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date=date;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public int getTeacherId(){
        return teacherId;
    }

    public void setTeacherId(int teacherId){
        this.teacherId=teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId);
    }

    @Override
    public String toString() {
        return "TeacherAttendance{" +
                "date='" + date + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }


}
