package main.java.controller;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.io.*;

import main.java.model.Student;

public class StudentList {

    private ArrayList<Student> students;

    public StudentList(){
        students = new ArrayList<>();

        students.add(new Student(1, "Muhammed", "male", "22-2-2022", "hama@hama.com", "halabja", "07502222222", 1));
        students.add(new Student(2, "Karwan", "male", "22-2-2022", "karwan@karwan.com", "slemani", "07502222223", 1));
        students.add(new Student(3, "Rebaz", "male", "22-2-2022", "rebaz@rebaz.com", "erbil", "07502222224", 1));
        students.add(new Student(4, "Ali", "male", "22-2-2022", "ali@ali.com", "halabja", "07502222225", 1));
        students.add(new Student(5, "Sarmad", "male", "22-2-2022", "sarmad@sarmad.com", "slemani", "07502222226", 1));
        students.add(new Student(6, "Kamaran", "male", "22-2-2022", "kamaran@kamaran.com", "kalar", "07502222227", 2));
        students.add(new Student(7, "Dilshad", "male", "22-2-2022", "dlshad@dlshad.com", "erbil", "07502222228", 2));
    }

    public void addStudent(Student student){
        readFromFile();
        students.add(student);
        saveToFile();
    }

    public boolean deleteStudent(String name){
        readFromFile();
        int ind = findStudent(name);
        if (ind == -1){
            System.out.println("there is no student with the name: "+name);
            return false;
        }
        students.remove(ind);
        System.out.println("staff: "+name+" was removed");
        saveToFile();
        return true;
    }

    public int findStudent(String name){
        for(int i=0;i<students.size();i++){
            Student student = students.get(i);
            if (student.getUserName().equals(name)){ return i;}
        }
        return -1;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public Student getStudentById(int id){
        readFromFile();
        return students.stream().filter(s -> s.getId() ==id).findAny().orElse(null);

    }

    public  ArrayList<Student> getStudentByUsername(String username){
        readFromFile();
        return students.stream().filter(s -> s.getUserName().toLowerCase().equals(username.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Student> getStudentByGender(String gender){
        readFromFile();
        return students.stream().filter(s -> s.getGender().toLowerCase().equals(gender.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Student> getStudentByBirthDate(String date){
        readFromFile();
        return students.stream().filter(s -> s.getBirthDate().equals(date.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Student> getStudentByAddress(String address){
        readFromFile();
        return students.stream().filter(s -> s.getAddress().toLowerCase().equals(address.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Student> getStudentByGradeId(int id){
        readFromFile();
        return students.stream().filter(s -> s.getGradeId() ==(id)).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getNumberOfStudents(){
        readFromFile();
        return students.size();
    }

    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/students.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
        }
        catch (IOException e){
            System.out.println("file output error");
        }
    }

    public void readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/students.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
        }catch (IOException e){
            System.out.println("error with reading file");
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
    }

    public void printStudents(){
        readFromFile();
        if(students.isEmpty()){
            System.out.println("there is no record of student");
        }else{
            System.out.println("---------------------------------------------------------------\n" +
                    "id|name|birthdate|email|address");
            for(Student s:students){
                System.out.println(s.getId()+"|"+s.getUserName()+"|"+s.getBirthDate()+"|"+s.getEmail()+"|"+s.getAddress());
            }
            System.out.println("================================================================");
        }
    }

    public int getMaxId(){
        readFromFile();
        try{
            return students.stream().max(Comparator.comparing(Student::getId)).orElseThrow().getId();
        }catch(Exception e){
            return 0;
        }
    }

}

