package main.java.model;

import java.io.Serializable;
import java.util.Objects;

public class Grade implements Serializable {
    private int gradeId;
    private String gradeName;
    private int gradeYear;

    public Grade(int gradeId, String gradeName, int gradeYear){
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.gradeYear = gradeYear;
    }


    public int getGradeId(){
        return gradeId;
    }

    public void setGradeId(int gradeId){
        this.gradeId = gradeId;
    }

    public String getGradeName(){
        return gradeName;
    }

    public void setGradeName(String grade){
        this.gradeName = gradeName;
    }

    public int getGradeYear(){
        return gradeYear;
    }

    public void setGradeYear(int gradeYear){
        this.gradeYear = gradeYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId);
    }

    @Override
    public String toString(){
        return "grade{" +
                "gradeId='" + gradeId + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", gradeYear='" + gradeYear + '\'' +
                '}';
    }
}