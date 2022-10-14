package main.java.model;
import java.util.Objects;

public class ClassSubject {
    private int subjectId;
    private int classId;


    public ClassSubject(int subjectId, int classId){
        this.subjectId = subjectId;
        this.classId = classId;

    }


    public int getsubjectId(){
        return subjectId;
    }
    public void setsubjectId(int subjectId){
        this.subjectId = subjectId;
    }


    public int getclassId(){
        return classId;
    }
    public void setclassId(int classId){
        this.classId = classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId,classId);
    }


    @Override
    public String toString(){
        return "classSubject{" +
                "subjectId='" + subjectId + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}