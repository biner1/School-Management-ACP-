package main.java.model.management;
import main.java.model.models.ExamGrade;
import java.util.ArrayList;


public class ExamGradeList {

    private ArrayList<ExamGrade> ExamGrades;

    public ExamGradeList(){
        ExamGrades = new ArrayList<>();

        ExamGrades.add(new ExamGrade(1, 1, 78, 1));
        ExamGrades.add(new ExamGrade(2, 1, 80, 2));
        ExamGrades.add(new ExamGrade(3, 1, 88, 3));
        ExamGrades.add(new ExamGrade(4, 1, 70, 4));
        ExamGrades.add(new ExamGrade(5, 1, 90, 5));

    }

    public void addExamGrade(ExamGrade examG){

        ExamGrades.add(examG);
    }

    public ArrayList<ExamGrade> getExamGrades(){
        return ExamGrades;
    }





}
