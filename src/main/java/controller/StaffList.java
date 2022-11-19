package main.java.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.io.*;

import main.java.model.Staff;
import main.java.model.StaffRole;


public class StaffList {

    private ArrayList<Staff> staffs;

    public StaffList(){

        staffs = new ArrayList<Staff>();

//        staffs.add(new Staff(1, "biner", "male", "1-1-2000", "biner@biner.com", "halabja", "07501111111", StaffRole.ADMIN, 9000000, "password"));
//        staffs.add(new Staff(3, "zeynab", "female", "2-2-2000", "zeynab@zeynab.com", "erbil", "07501111113", StaffRole.ACCOUNTANT, 7000000, "password"));
//        staffs.add(new Staff(4, "darya", "female", "2-2-2002", "darya@darya.com", "erbil", "07501111114", StaffRole.TEACHER, 6000000, "password"));
//        staffs.add(new Staff(5, "muhammed", "male", "21-2-2001", "muhammed@muhammed.com", "erbil", "07501111115", StaffRole.TEACHER, 5000000, "password"));
//        staffs.add(new Staff(6, "naz", "female", "1-1-2001", "naz@naz.com", "erbil", "07501111116", StaffRole.TEACHER, 6000000, "password"));
//        staffs.add(new Staff(2, "abdulla", "male", "2-2-2002", "abdulla@abdulla.com", "slemani", "07501111112", StaffRole.TEACHER, 5000000, "password"));
    }// StaffList

    public void addStaff(Staff staff){
        readFromFile();
        staffs.add(staff);
        saveToFile();
    }

    public boolean deleteStaff(String name){
        readFromFile();
       int ind = findStaff(name);
       if (ind == -1){
           System.out.println("there is no staff with the name: "+name);
           return false;
       }
       staffs.remove(ind);
       System.out.println("staff: "+name+" was removed");
       saveToFile();
       return true;
    }

    public int findStaff(String name){
        for(int i=0;i<staffs.size();i++){
            Staff staff = staffs.get(i);
            if (staff.getUserName().equals(name)){ return i;}
        }
        return -1;
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
        readFromFile();
        return staffs.stream().filter(s -> (s.getUserName().toLowerCase().equals(username.toLowerCase())) && s.getUserPassword().equals(password)).findAny().orElse(null);
    }

    public int getMaxId(){
        readFromFile();
        try{
            int id = staffs.stream().max(Comparator.comparing(Staff::getId)).get().getId();
            return id;
        }catch(Exception e){
            return 0;
        }
    }

    public void printStaffs(PrintWriter out){
        readFromFile();
        if(staffs.isEmpty()){
            out.println("there is no record of staff");
        }else{
            System.out.println("---------------------------------------------------------------\n" +
                    "id|name|birthdate|role|email|salary");
            for(Staff s:staffs){
                out.println(s.getId()+"|"+s.getUserName()+"|"+s.getBirthDate()+"|"+s.getRole()+"|"+s.getEmail()+s.getSalary());
            }
            out.println("================================================================");
        }
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
