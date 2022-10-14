package main.java.model;
import java.util.Objects;
public class Class {
    private int classId;
    private String Class;
    private int classYear;

    public Class(int classId, String Class, int classYear){
        this.classId = classId;
        this.Class = Class;
        this.classYear = classYear;
    }


    public int getclassId(){
        return classId;
    }
    public void setclassId(int classId){
        this.classId = classId;
    }


    public String getclass(){
        return Class;
    }
    public void setclass(String Class){
        this.Class = Class;
    }



    public int getclassYear(){
        return classYear;
    }
    public void setclassYear(int classYear){
        this.classYear = classYear;
    }


    @Override
    public int hashCode() {
        return Objects.hash(classId);
    }



    @Override
    public String toString(){
        return "Class{" +
                "classId='" + classId + '\'' +
                ", Class='" + Class + '\'' +
                ", classYear='" + classYear + '\'' +
                '}';
    }
}