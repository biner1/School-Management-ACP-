package main.java.controller;

import main.java.model.Exam;
import main.java.model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ExamList{
    private ArrayList<Exam> exams;

    public ExamList(){
        exams = new ArrayList<>();

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

    public boolean deleteGrade(String name){
        readFromFile();
        int ind = findExam(name);
        if (ind == -1){
            System.out.println("there is no Grade with the name: "+name);
            return false;
        }
        exams.remove(ind);
        System.out.println("Grade: "+name+" was removed");
        saveToFile();
        return true;
    }

    public int findExam(String name){
        for(int i=0;i<exams.size();i++){
            Exam exam = exams.get(i);
            if (exam.getExamDesc().equals(name)){ return i;}
        }
        return -1;
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
            FileInputStream fis = new FileInputStream("src/main/java/datafile/Exams.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            exams = (ArrayList<Exam>) ois.readObject();
            ois.close();
        }catch (IOException e){
            System.out.println("error with reading file");
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
    }

    public int getMaxId(){
        readFromFile();
        try{
            int id = exams.stream().max(Comparator.comparing(Exam::getExamId)).orElseThrow().getExamId();
            return id;
        }catch(Exception e){
            return 0;
        }
    }

    public void printExam(PrintWriter out){
        readFromFile();
        if(exams.isEmpty()){
            out.println("there is no record of exams");
        }else{
            out.println("---------------------------------------------------------------\n" +
                    "id|desc|birthdate|subject id|email|date");
            for(Exam s:exams){
                out.println(s.getExamId()+"|"+s.getExamDesc()+"|"+"|"+s.getSubjectId()+"|"+s.getDate());
            }
            out.println("================================================================");
        }
    }

}
