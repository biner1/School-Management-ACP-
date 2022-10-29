package main.java.model.management;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.model.models.ExamGrade;
import main.java.model.models.Student;


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
        readFromFile();
        ExamGrades.add(examG);
        saveToFile();
    }

    public ArrayList<ExamGrade> getExamGrades(){
        return ExamGrades;
    }

    public ExamGrade getExamGradeByExamId(int examId){
        readFromFile();
        return ExamGrades.stream().filter(g -> g.getExamId() ==examId).findAny().orElse(null);
    }

    public ArrayList<ExamGrade> getExamGradeByMark(int mark){
        readFromFile();
        return ExamGrades.stream().filter(s -> s.getMark() ==(mark)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<ExamGrade> getExamGradeByStudentId(int studentId){
        readFromFile();
        return ExamGrades.stream().filter(s -> s.getStudentId() ==(studentId)).collect(Collectors.toCollection(ArrayList::new));
    }




    public boolean saveToFile(){
        try {
            FileOutputStream zed = new FileOutputStream("src/main/java/datafile/ExamGrade.txt");
            ObjectOutputStream zee = new ObjectOutputStream(zed);
            zee.writeObject(ExamGrades);
            zee.close();
            return true;
        }
        catch (IOException e){
            System.out.println("file output error");
            return false;
        }
    }





    public ArrayList<ExamGrade> readFromFile(){
        try {
            FileInputStream zed = new FileInputStream("src/main/java/datafile/ExamGrade.txt");
            ObjectInputStream zee = new ObjectInputStream(zed);
            ExamGrades = (ArrayList<ExamGrade>) zee.readObject();
            zee.close();
            return ExamGrades;
        }catch (IOException e){
            System.out.println("error with reading file");
            return null;
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
            return null;
        }
    }


}
