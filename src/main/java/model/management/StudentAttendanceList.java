package main.java.model.management;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.model.models.StudentAttendance;

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
}
