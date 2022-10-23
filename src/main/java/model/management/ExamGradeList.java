package main.java.model.management;

import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.model.models.ExamGrade;


public class ExamGradeList {

    private ArrayList<ExamGrade> ExamGrades;

    public ExamGradeList(){
        ExamGrades = new ArrayList<>();
        //TODO delete id
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

    public ExamGrade getExamGradeByExamId(int examId){
        return ExamGrades.stream().filter(g -> g.getExamId() ==examId).findAny().orElse(null);
    }

    public ArrayList<ExamGrade> getExamGradeByMark(int mark){
        return ExamGrades.stream().filter(s -> s.getMark() ==(mark)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<ExamGrade> getExamGradeByStudentId(int studentId){
        return ExamGrades.stream().filter(s -> s.getStudentId() ==(studentId)).collect(Collectors.toCollection(ArrayList::new));
    }


}
