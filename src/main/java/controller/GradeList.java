package main.java.controller;
import main.java.model.Grade;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GradeList {

    public ArrayList<Grade> grades;

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
        readFromFile();
        grades.add(grade);
        saveToFile();
    }


    public boolean deleteGrade(String name){
        readFromFile();
        int ind = findGrade(name);
        if (ind == -1){
            System.out.println("there is no Grade with the name: "+name);
            return false;
        }
        grades.remove(ind);
        System.out.println("Grade: "+name+" was removed");
        saveToFile();
        return true;
    }

    public int findGrade(String name){
        for(int i=0;i<grades.size();i++){
            Grade grade = grades.get(i);
            if (grade.getGradeName().equals(name)){ return i;}
        }
        return -1;
    }

    public ArrayList<Grade> getGradeList(){
        readFromFile();
        return grades;
    }

    public ArrayList<Grade> getStudentByGradeYear(int year){
        readFromFile();
        return grades.stream().filter(s -> s.getGradeYear() ==(year)).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Grade> getStudentByUsername(String username){
        readFromFile();
        return grades.stream().filter(s -> s.getGradeName().toLowerCase().equals(username.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getGradeByNameYear(String name, int year) {
        readFromFile();
        try {
            int tmpGrade = grades.stream().filter(s -> (s.getGradeName().toLowerCase().equals(name.toLowerCase())) && (s.getGradeYear() == year)).findAny().get().getGradeId();
            return tmpGrade;
        }
        catch (Exception e){
            return -1;
        }
    }

    public int getNumberOfGrades(){
        readFromFile();
        return grades.size();
    }

    public int getMaxId(){
        readFromFile();
        try{
            int id = grades.stream().max(Comparator.comparing(Grade::getGradeId)).get().getGradeId();
            return id;
        }catch(Exception e){
            return 0;
        }
    }

    public void printGrades(PrintWriter out){
        readFromFile();
        if(grades.isEmpty()){
            out.println("there is no record of Grades");
        }else{
            out.println("---------------------------------------------------------------\n" +
                    "id|name|year|");
            for(Grade g:grades){
                out.println(g.getGradeId()+"|"+g.getGradeName()+"|"+g.getGradeYear());
            }
            out.println("================================================================");
        }
    }

    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/grades.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(grades);
            oos.close();
        }
        catch (IOException e){
            System.out.println("file output error");
        }
    }

    public void readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/grades.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            grades = (ArrayList<Grade>) ois.readObject();
            ois.close();
        }catch (IOException e){
            System.out.println("error with reading file");
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
    }
}