package main.java.model.management;
import main.java.model.models.Exam;


import java.util.ArrayList;

public class ExamList{
    private ArrayList<Exam> Exams;

    public ExamList(){
        Exams = new ArrayList<>();

        Exams.add(new Exam(1, 1 , "informatics", "1-2-2022"));
        Exams.add(new Exam(2, 2 , "Software", "2-2-2022"));
        Exams.add(new Exam(3, 3 , "Math", "3-2-2022"));
        Exams.add(new Exam(4, 4 , "Analysis", "4-2-2022"));
        Exams.add(new Exam(5, 5 , "AI", "5-2-2022"));

    }

    public void addExam(Exam exam){

        Exams.add(exam);
    }

    public ArrayList<Exam> getExams(){
        return Exams;
    }




}