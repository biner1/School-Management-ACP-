package main.java.controller;

import main.java.model.Exam;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ExamList{
    private ArrayList<Exam> exams;

    public ExamList(){
        exams = new ArrayList<>();

        //TODO delete examId
        exams.add(new Exam(1, 1 , "informatics", "1-2-2022"));
        exams.add(new Exam(2, 2 , "Software", "2-2-2022"));
        exams.add(new Exam(3, 3 , "Math", "3-2-2022"));
        exams.add(new Exam(4, 4 , "Analysis", "4-2-2022"));
        exams.add(new Exam(5, 5 , "AI", "5-2-2022"));

    }

    public void addExam(Exam exam){
        readFromFile();
        exams.add(exam);
        saveToFile();
    }

    public ArrayList<Exam> getExams(){
        return exams;
    }


    public  ArrayList<Exam> getExamByName(String name){
        readFromFile();
        return exams.stream().filter(s -> s.getExamDesc().toLowerCase().equals(name.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Exam> getExamGradeBySubjectId(int id){
        readFromFile();
        return exams.stream().filter(s -> s.getSubjectId() ==(id)).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Exam> getExamGradeByDate(String date){
        readFromFile();
        return exams.stream().filter(s -> s.getDate().toLowerCase().equals(date.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }



    public void saveToFile(){
        try {
            FileOutputStream zed = new FileOutputStream("src/main/java/datafile/Exams.txt");
            ObjectOutputStream zee = new ObjectOutputStream(zed);
            zee.writeObject(exams);
            zee.close();
        }
        catch (IOException e){
            System.out.println("file output error");
        }
    }




    public void readFromFile(){
        try {
            FileInputStream zed = new FileInputStream("src/main/java/datafile/Exams.txt");
            ObjectInputStream zee = new ObjectInputStream(zed);
            exams = (ArrayList<Exam>) zee.readObject();
            zee.close();
        }catch (IOException e){
            System.out.println("error with reading file");
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
    }


}
