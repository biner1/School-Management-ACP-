package main.java.model.management;

import main.java.model.models.StaffAttendance;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class StaffAttendanceList {

    private ArrayList<StaffAttendance> staffAttendances;

    public StaffAttendanceList() {
        staffAttendances = new ArrayList<StaffAttendance>();

        staffAttendances.add(new StaffAttendance(1, 1, "11/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(2, 1, "14/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(3, 1, "17/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(4, 1, "20/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(5, 2, "5/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(6, 2, "8/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(7, 2, "17/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(8, 2, "19/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(9, 3, "3/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(10, 3, "16/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(11, 4, "11/10/2020", "absent"));
        staffAttendances.add(new StaffAttendance(12, 4, "18/10/2020", "absent"));
    }

    public void addStaffAttendance(StaffAttendance staffAttendance) {
        readFromFile();
        staffAttendances.add(staffAttendance);
        saveToFile();
    }

    public ArrayList<StaffAttendance> getStaffAttendances() {
        readFromFile();
        return staffAttendances;
    }

    public ArrayList<StaffAttendance> getStaffAttendanceByStaffId(int id) {
        readFromFile();
        return staffAttendances.stream().filter(g -> g.getStaffId() == id).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<StaffAttendance> getStaffAttendanceByDate(String date) {
        readFromFile();
        return staffAttendances.stream().filter(g -> Objects.equals(g.getDate(), date)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<StaffAttendance> getStaffAttendanceByStatus(String status) {
        readFromFile();
        return staffAttendances.stream().filter(g -> Objects.equals(g.getStatus(), status)).collect(Collectors.toCollection(ArrayList::new));
    }

    public void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/staffAttendances.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(staffAttendances);
            oos.close();
        } catch (IOException e) {
            System.out.println("file output error");
        }
    }

    public void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/staffAttendances.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            staffAttendances = (ArrayList<StaffAttendance>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error with reading file");
        }
    }

}
