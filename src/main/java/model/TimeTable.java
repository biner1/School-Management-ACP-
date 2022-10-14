package main.java.model;
import java.util.Objects;

public class TimeTable {
    private int tableId;
    private int classId;
    private String subjects;
    private String time;

    public TimeTable(int tableid, int classId, String subjects, String time){
        this.tableId = tableid;
        this.classId = classId;
        this.subjects = subjects;
        this.time = time;

    }
    public int gettableId(){
        return tableId;
    }
    public void settableId(int id){
        this.tableId = id;
    }
    public int getclassId(){
        return classId;
    }
    public void setclassId(int id){
        this.classId = id;
    }
    public String getSubjects(){
        return  subjects;
    }
    public void setSubjects(String subjects){
        this.subjects = subjects;
    }
    public String gettime(){
        return  time;
    }
    public void settime(String time){
        this.time = time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId,classId);
    }

    public String toString(){
        return "TimeTable{" +
                "tableId='" + tableId + '\'' +
                ", classId='" + classId + '\'' +
                ", subjects='" + subjects + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
