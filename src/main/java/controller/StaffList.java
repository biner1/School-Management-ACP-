package main.java.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.*;

import main.java.model.Staff;
import main.java.model.StaffRole;


public class StaffList {

    private ArrayList<Staff> staffs;

    public StaffList(){

        staffs = new ArrayList<Staff>();

        staffs.add(new Staff(1, "biner", "male", "1-1-2000", "biner@biner.com", "halabja", "07501111111", StaffRole.ADMIN, 9000000, "password"));
        staffs.add(new Staff(3, "zeynab", "female", "2-2-2000", "zeynab@zeynab.com", "erbil", "07501111113", StaffRole.ACCOUNTANT, 7000000, "password"));
        staffs.add(new Staff(4, "darya", "female", "2-2-2002", "darya@darya.com", "erbil", "07501111114", StaffRole.TEACHER, 6000000, "password"));
        staffs.add(new Staff(5, "muhammed", "male", "21-2-2001", "muhammed@muhammed.com", "erbil", "07501111115", StaffRole.TEACHER, 5000000, "password"));
        staffs.add(new Staff(6, "naz", "female", "1-1-2001", "naz@naz.com", "erbil", "07501111116", StaffRole.TEACHER, 6000000, "password"));
        staffs.add(new Staff(2, "abdulla", "male", "2-2-2002", "abdulla@abdulla.com", "slemani", "07501111112", StaffRole.TEACHER, 5000000, "password"));
    }// StaffList

    public void addStaff(Staff staff){
        readFromFile();
        staffs.add(staff);
        saveToFile();
    }

    public ArrayList<Staff> getStaffs() {
        readFromFile();
        return staffs;
    }

    public Staff getStaffById(int id) {
        readFromFile();
        return staffs.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public  ArrayList<Staff> getStaffByUsername(String username){
        readFromFile();
        return staffs.stream().filter(s -> s.getUserName().toLowerCase().equals(username.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Staff> getStaffByGender(String gender){
        readFromFile();
        return staffs.stream().filter(s -> s.getGender().toLowerCase().equals(gender.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Staff> getStaffByBirthDate(String date){
        readFromFile();
        return staffs.stream().filter(s -> s.getBirthDate().toLowerCase().equals(date.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Staff> getStaffByAddress(String address){
        readFromFile();
        return staffs.stream().filter(s -> s.getAddress().toLowerCase().equals(address.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Staff> getStaffBySalary(int salary){
        readFromFile();
        return staffs.stream().filter(s -> s.getSalary()==(salary)).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getNumberOfStaffs(){
        readFromFile();
        return staffs.size();
    }

    public  Staff getStaffUsernamePassword(String username, String password){
        return staffs.stream().filter(s -> (s.getUserName().toLowerCase().equals(username.toLowerCase())) && s.getUserPassword().equals(password)).findAny().orElse(null);
    }

    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/staffs.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(staffs);
            oos.close();
        }
        catch (IOException e){
            System.out.println("file output error");
        }
    }

    public void readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/staffs.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            staffs = (ArrayList<Staff>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("error with reading file");
        }
    }

}
