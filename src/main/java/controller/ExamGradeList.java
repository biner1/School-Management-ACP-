package main.java.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.model.ExamGrade;



public class ExamGradeList {

    private ArrayList<ExamGrade> examGrades;

    public ExamGradeList(){
        examGrades = new ArrayList<>();
        //TODO delete id
        examGrades.add(new ExamGrade(1, 1, 78, 1));
        examGrades.add(new ExamGrade(2, 1, 80, 2));
        examGrades.add(new ExamGrade(3, 1, 88, 3));
        examGrades.add(new ExamGrade(4, 1, 70, 4));
        examGrades.add(new ExamGrade(5, 1, 90, 5));

    }

    public void addExamGrade(ExamGrade examG){
        readFromFile();
        examGrades.add(examG);
        saveToFile();
    }

    public ArrayList<ExamGrade> getExamGrades(){
        return examGrades;
    }

    public ExamGrade getExamGradeByExamId(int examId){
        readFromFile();
        return examGrades.stream().filter(g -> g.getExamId() ==examId).findAny().orElse(null);
    }

    public ArrayList<ExamGrade> getExamGradeByMark(int mark){
        readFromFile();
        return examGrades.stream().filter(s -> s.getMark() ==(mark)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<ExamGrade> getExamGradeByStudentId(int studentId){
        readFromFile();
        return examGrades.stream().filter(s -> s.getStudentId() ==(studentId)).collect(Collectors.toCollection(ArrayList::new));
    }




    public void saveToFile(){
        try {
            FileOutputStream zed = new FileOutputStream("src/main/java/datafile/ExamGrade.txt");
            ObjectOutputStream zee = new ObjectOutputStream(zed);
            zee.writeObject(examGrades);
            zee.close();
        }
        catch (IOException e){
            System.out.println("file output error");
        }
    }





    public ArrayList<ExamGrade> readFromFile(){
        try {
            FileInputStream zed = new FileInputStream("src/main/java/datafile/ExamGrade.txt");
            ObjectInputStream zee = new ObjectInputStream(zed);
            examGrades = (ArrayList<ExamGrade>) zee.readObject();
            zee.close();
            return examGrades;
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
