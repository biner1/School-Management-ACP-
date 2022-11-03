package main.java.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Map;

public class TimeTable implements Serializable {

    private int gradeId;
    private Map<String,String> subjects;

    public TimeTable(int gradeId, Map<String,String> subjects){
        this.gradeId = gradeId;
        this.subjects = subjects;
    }

    public int getGradeId(){
        return gradeId;
    }

    public void setGradeId(int id){
        this.gradeId = id;
    }

    public Map<String,String> getSubjects(){
        return  subjects;
    }

    public void setSubjects(Map<String,String> subjects){
        this.subjects = subjects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId);
    }

    public String toString(){
        return "TimeTable{" +
                " gradeId='" + gradeId + '\'' +
                ", subjects='" + subjects + '\'' +
                '}';
    }
}
