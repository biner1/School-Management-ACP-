package main.java.model.management;

import main.java.model.models.Grade;

import java.util.ArrayList;

public class GradeList {

    public ArrayList<Grade> grades;

    public GradeList(){
        grades = new ArrayList<Grade>();
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }
}
