package main.java.model.management;
import main.java.model.models.Grade;

import java.io.*;
import java.util.ArrayList;
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