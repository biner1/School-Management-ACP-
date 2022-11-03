package main.java.model;

import java.util.Objects;
import java.io.Serializable;


public class Subject implements  Serializable{

    private String subjectName;
    private int teacherId;
    private int gradeId;


    public Subject(int teacherId, String subjectName ,int gradeId){
        this.teacherId=teacherId;
        this.subjectName=subjectName;
        this.gradeId=gradeId;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
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
        return Objects.hash(teacherId);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "Subject='" + subjectName + '\'' +
                '}';
    }
}
