package main.java.model.models;

import java.util.Objects;

public class StaffAttendance {

    private int id;
    private String date;
    private String status;
    private int staffId;


    public StaffAttendance(int id, int staffId, String date, String status){
        this.id = id;
        this.date = date;
        this.status = status;
        this.staffId = staffId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getStaffId(){
        return staffId;
    }

    public void setStaffId(int teacherId){
        this.staffId = teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }

    @Override
    public String toString() {
        return "StaffAttendance{" +
                "date='" + date + '\'' +
                ", Status='" + status + '\'' +
                ", StaffId='" + staffId + '\'' +
                '}';
    }


}
