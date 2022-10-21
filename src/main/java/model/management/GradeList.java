package main.java.model.management;

import main.java.model.models.Grade;

import java.util.ArrayList;

public class GradeList {

    public ArrayList<Grade> grades;

    public GradeList(){
        grades = new ArrayList<Grade>();

        grades.add(new Grade(1,"1",2022));
        grades.add(new Grade(2,"2",2021));
        grades.add(new Grade(3,"3",2020));
        grades.add(new Grade(4,"4",2019));
        grades.add(new Grade(5,"5",2018));
        grades.add(new Grade(6,"6",2017));
        grades.add(new Grade(7,"7",2016));
        grades.add(new Grade(8,"8",2015));
        grades.add(new Grade(9,"9",2014));
        grades.add(new Grade(10,"10",2013));
        grades.add(new Grade(11,"11",2012));
        grades.add(new Grade(12,"12",2011));
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }
}
