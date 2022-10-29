package main.java.model.management;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.model.models.StaffPayment;
import main.java.model.models.Student;

public class StaffPaymentList {
    private ArrayList<StaffPayment> staffPayments;

    public StaffPaymentList(){

        staffPayments = new ArrayList<>();

        staffPayments.add(new StaffPayment(1, 1, 14000, "30-1-2022"));
        staffPayments.add(new StaffPayment(2, 2, 120000, "30-1-2022"));
        staffPayments.add(new StaffPayment(3, 3, 140000, "30-1-2022"));
        staffPayments.add(new StaffPayment(4, 4, 130000, "30-1-2022"));
        staffPayments.add(new StaffPayment(5, 1, 120000, "30-1-2022"));
    }



    public void addStaffPayment(StaffPayment staffPayment){
        readFromFile();
        staffPayments.add(staffPayment);
        saveToFile();

    }

    public ArrayList<StaffPayment> getStaffPayments(){
        return staffPayments;
    }

    public ArrayList<StaffPayment> getStaffPaymentByDate(String date){
        readFromFile();
        return staffPayments.stream().filter(g -> Objects.equals(g.getPaymentDate(), date)).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<StaffPayment> getStaffPaymentBySalary(int salary){
        readFromFile();
        return staffPayments.stream().filter(s -> s.getSalary() ==(salary)).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/students.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(staffPayments);
            oos.close();
            return true;
        }
        catch (IOException e){
            System.out.println("file output error");
            return false;
        }
    }

    public ArrayList<StaffPayment> readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/students.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            staffPayments = (ArrayList<StaffPayment>) ois.readObject();
            ois.close();
            return staffPayments;
        }catch (IOException e){
            System.out.println("error with reading file");
            return null;
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
            return null;
        }
    }


}
