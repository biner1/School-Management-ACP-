package main.java.model.management;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.model.models.Subject;

public class SubjectList {

    private ArrayList<Subject> subjects;

    public SubjectList(){
        subjects = new ArrayList<Subject>();

        subjects.add(new Subject(1,"ACP",3));
        subjects.add(new Subject(2,"OOP",3));
        subjects.add(new Subject(3,"DataBase",3));
        subjects.add(new Subject(4,"OS",3));
        subjects.add(new Subject(5,"English",1));
        subjects.add(new Subject(6,"Network",1));
        subjects.add(new Subject(7,"Web",1));
        subjects.add(new Subject(8,"Mobile",2));
        subjects.add(new Subject(9,"Software",2));
        subjects.add(new Subject(10,"Computer Arch",2));
        subjects.add(new Subject(11,"AI",4));
        subjects.add(new Subject(12,"security",4));
    }

    public void addSubject(Subject subject){
        readFromFile();
        subjects.add(subject);
        saveToFile();
    }

    public ArrayList<Subject> getSubjects(){
        readFromFile();
        return subjects;
    }

    public  ArrayList<Subject> getSubjectByName(String name){
        readFromFile();
        return subjects.stream().filter(s -> s.getSubjectName().toLowerCase().equals(name.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Subject> getSubjectByGradeId(int id){
        readFromFile();
        return subjects.stream().filter(s -> s.getGradeId() ==(id)).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Subject> getSubjectByTeacherId(int id){
        readFromFile();
        return subjects.stream().filter(s -> s.getTeacherId() ==(id)).collect(Collectors.toCollection(ArrayList::new));
    }


    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/subjects.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(subjects);
            oos.close();
        }
        catch (IOException e){
            System.out.println("file output error");
        }
    }

    public void readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/subjects.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            subjects = (ArrayList<Subject>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("error with reading file");
        }
    }
}
