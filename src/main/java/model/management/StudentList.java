package main.java.model.management;

import main.java.model.models.Student;

import java.util.stream.Collectors;
import java.util.ArrayList;

public class StudentList {

    private ArrayList<Student> students;

    public StudentList(){
        students = new ArrayList<>();

        students.add(new Student(1, "muhammed", "male", "22-2-2022", "hama@hama.com", "halabja", "07502222222", 1));
        students.add(new Student(2, "karwan", "male", "22-2-2022", "karwan@karwan.com", "slemani", "07502222223", 1));
        students.add(new Student(3, "rebaz", "male", "22-2-2022", "rebaz@rebaz.com", "erbil", "07502222224", 1));
        students.add(new Student(4, "ali", "male", "22-2-2022", "ali@ali.com", "halabja", "07502222225", 1));
        students.add(new Student(5, "sarmad", "male", "22-2-2022", "sarmad@sarmad.com", "slemani", "07502222226", 1));
        students.add(new Student(6, "kamaran", "male", "22-2-2022", "kamaran@kamaran.com", "kalar", "07502222227", 2));
        students.add(new Student(7, "dlshad", "male", "22-2-2022", "dlshad@dlshad.com", "erbil", "07502222228", 2));
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public Student getStudentById(int id){
        Student student;
        return (Student) students.stream().filter(s -> s.getId() ==id).findAny().orElse(null);

    }

    public  ArrayList<Student> getStudentByUsername(String username){
        return students.stream().filter(s -> s.getUserName().toLowerCase().equals(username.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getSizeOfStudents(){
        return students.size();
    }

}

