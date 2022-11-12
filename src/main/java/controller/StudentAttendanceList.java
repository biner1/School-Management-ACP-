package main.java.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.model.Exam;
import main.java.model.Student;
import main.java.model.StudentAttendance;

public class StudentAttendanceList {

    private ArrayList<StudentAttendance> studentAttendances;

    public StudentAttendanceList() {
        studentAttendances = new ArrayList<StudentAttendance>();

        studentAttendances.add(new StudentAttendance(1, 1, "20-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(2, 1, "10-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(3, 1, "1-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(4, 1, "5-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(5, 2, "7-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(6, 2, "4-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(7, 2, "14-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(8, 2, "19-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(9, 3, "5-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(10, 3, "9-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(11, 3, "11-10-2022", "absent"));
        studentAttendances.add(new StudentAttendance(12, 3, "16-10-2022", "absent"));

    }


    public boolean deleteStudentAttendance(int id){
        readFromFile();
        int ind = findAttendance(id);
        if (ind == -1){
            System.out.println("there is no Grade with the name: "+id);
            return false;
        }
        studentAttendances.remove(ind);
        System.out.println("Grade: "+id+" was removed");
        saveToFile();
        return true;
    }

    public int findAttendance(int id){
        for(int i=0;i<studentAttendances.size();i++){
            StudentAttendance studentAttendance = studentAttendances.get(i);
            if (studentAttendance.getStudentId() == id){ return i;}
        }
        return -1;
    }


    public void addStudentAttendance(StudentAttendance studentAttendance) {
        readFromFile();
        studentAttendances.add(studentAttendance);
        saveToFile();
    }

    public ArrayList<StudentAttendance> getStudentAttendance() {
        readFromFile();
        return studentAttendances;
    }

    public ArrayList<StudentAttendance> getStudentAttendanceByStudentId(int id) {
        readFromFile();
        return studentAttendances.stream().filter(g -> g.getStudentId() == id).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<StudentAttendance> getStudentAttendanceByDate(String date) {
        readFromFile();
        return studentAttendances.stream().filter(g -> Objects.equals(g.getDate(), date)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<StudentAttendance> getStudentAttendanceByStatus(String status) {
        readFromFile();
        return studentAttendances.stream().filter(g -> Objects.equals(g.getStatus(), status)).collect(Collectors.toCollection(ArrayList::new));
    }

    public void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/studentAttendances.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentAttendances);
            oos.close();
        } catch (IOException e) {
            System.out.println("file output error");
        }
    }

    public void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/studentAttendances.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentAttendances = (ArrayList<StudentAttendance>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error with reading file");
        }
    }

    public void printStudents(){
        readFromFile();
        if(studentAttendances.isEmpty()){
            System.out.println("there is no record of student");
        }else{
            System.out.println("---------------------------------------------------------------\n" +
                    "id|studentId|date|class|status");
            for(StudentAttendance s:studentAttendances){
                System.out.println(s.getId()+"|"+s.getStudentId()+"|"+s.getDate()+"|"+s.getClass()+"|"+s.getStatus());
            }
            System.out.println("================================================================");
        }
    }

    public int getMaxId(){
        readFromFile();
        try{
            return studentAttendances.stream().max(Comparator.comparing(StudentAttendance::getId)).orElseThrow().getId();
        }catch(Exception e){
            return 0;
        }
    }
}