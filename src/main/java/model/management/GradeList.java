package main.java.model.management;

import main.java.model.models.Grade;
import main.java.model.models.Student;

import java.util.ArrayList;

public class GradeList {

    public ArrayList<Grade> grades;

    public GradeList(){
        grades = new ArrayList<Grade>();

        grades.add(new Grade(1,"1A",2022));
        grades.add(new Grade(2,"2A",2022));
        grades.add(new Grade(3,"3A",2022));
        grades.add(new Grade(4,"4A",2022));
        grades.add(new Grade(5,"5A",2022));
        grades.add(new Grade(6,"6A",2022));
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }

    public ArrayList<Grade> getGradeList(){
        return grades;
    }
}
