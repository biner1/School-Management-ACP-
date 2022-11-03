package main.java.model;

import java.io.Serializable;
import java.util.Objects;

public class Exam implements Serializable {

    private int examId;
    private int subjectId;
    private String examDesc;
    private String date;

    public Exam(int examId, int subjectId , String examDesc , String date){
        this.examId=examId;
        this.subjectId=subjectId;
        this.examDesc=examDesc;
        this.date=date;
    }

    public int getExamId(){
        return examId;
    }

    public void setExamId(int examId){
        this.examId=examId;
    }

    public int getSubjectId(){
        return subjectId;
    }

    public void setSubjectId(int subjectId){
        this.subjectId=subjectId;
    }

    public String getExamDesc(){
        return examDesc;
    }

    public void setExamDesc(String examDesc){
        this.examDesc=examDesc;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date=date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "ExamDesc='" + examDesc + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}


