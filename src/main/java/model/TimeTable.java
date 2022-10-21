package main.java.model;

import java.util.Objects;
import java.util.Set;

public class TimeTable {

    private int gradeId;
    private Set<String> subjects;
    private String time;

    public TimeTable(int classId, Set<String> subjects, String time){
        this.gradeId = gradeId;
        this.subjects = subjects;
        this.time = time;
    }


    public int getGradeId(){
        return gradeId;
    }

    public void setGradeId(int id){
        this.gradeId = id;
    }

    public Set<String> getSubjects(){
        return  subjects;
    }

    public void setSubjects(Set<String> subjects){
        this.subjects = subjects;
    }

    public String getTime(){
        return  time;
    }

    public void setTime(String time){
        this.time = time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId);
    }

    public String toString(){
        return "TimeTable{" +
                ", gradeId='" + gradeId + '\'' +
                ", subjects='" + subjects + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
