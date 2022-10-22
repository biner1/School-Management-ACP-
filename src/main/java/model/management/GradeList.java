package main.java.model.management;

import main.java.model.models.Grade;
import java.util.ArrayList;

public class GradeList {

    public static ArrayList<Grade> grades;

    public GradeList(){
        grades = new ArrayList<Grade>();

        grades.add(new Grade(1,"1A",2022));
        grades.add(new Grade(2,"1B",2022));
        grades.add(new Grade(3,"2A",2022));
        grades.add(new Grade(4,"2B",2022));
        grades.add(new Grade(5,"3A",2022));
        grades.add(new Grade(6,"3B",2022));
        grades.add(new Grade(7,"4A",2022));
        grades.add(new Grade(8,"4B",2022));
        grades.add(new Grade(9,"5A",2022));
        grades.add(new Grade(10,"5B",2022));
        grades.add(new Grade(11,"6A",2022));
        grades.add(new Grade(12,"6B",2022));
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }

    public ArrayList<Grade> getGradeList(){
        return grades;
    }
}

