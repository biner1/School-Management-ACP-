package main.java.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.model.StaffPayment;

public class StaffPaymentList {
    private ArrayList<StaffPayment> staffPayments;

    public StaffPaymentList() {

        staffPayments = new ArrayList<>();

        staffPayments.add(new StaffPayment(1, 1, 14000, "30-1-2022"));
        staffPayments.add(new StaffPayment(2, 2, 120000, "30-1-2022"));
        staffPayments.add(new StaffPayment(3, 3, 140000, "30-1-2022"));
        staffPayments.add(new StaffPayment(4, 4, 130000, "30-1-2022"));
        staffPayments.add(new StaffPayment(5, 1, 120000, "30-1-2022"));
    }


    public void addStaffPayment(StaffPayment staffPayment) {
        readFromFile();
        staffPayments.add(staffPayment);
        saveToFile();

    }

    public boolean deletestaffPayment(int id){
        readFromFile();
        int ind = findStaffPayment(id);
        if (ind == -1){
            System.out.println("there is no staff Payment with the name: "+id);
            return false;
        }
        staffPayments.remove(ind);
        System.out.println("staff: "+id+" was removed");
        saveToFile();
        return true;
    }

    public int findStaffPayment(int id){
        for(int i=0;i<staffPayments.size();i++){
            StaffPayment staffPayment = staffPayments.get(i);
            if (staffPayment.getPaymentId()==(id)){ return i;}
        }
        return -1;
    }

    public ArrayList<StaffPayment> getStaffPayments() {
        readFromFile();
        return staffPayments;
    }

    public ArrayList<StaffPayment> getStaffPaymentByDate(String date) {
        readFromFile();
        return staffPayments.stream().filter(g -> Objects.equals(g.getPaymentDate(), date)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<StaffPayment> getStaffPaymentBySalary(int salary) {
        readFromFile();
        return staffPayments.stream().filter(s -> s.getSalary() == (salary)).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getNumberOfStaffPayments(){
        readFromFile();
        return staffPayments.size();
    }

    public int getMaxId() {
        readFromFile();
        try {
            int id = staffPayments.stream().max(Comparator.comparing(StaffPayment::getPaymentId)).get().getPaymentId();
            return id;
        } catch (Exception e) {
            return 0;
        }
    }

    public void printStaffPayments(PrintWriter out) {
        readFromFile();
        if (staffPayments.isEmpty()) {
            out.println("there is no record of staff");
        } else {
            out.println("---------------------------------------------------------------\n" +
                    "payment Id|Staff Id|Salary|Payment Date");
            for (StaffPayment s : staffPayments) {
                out.println(s.getPaymentId() + "|" + s.getStaffId() + "|" + s.getSalary() + "|" + s.getPaymentDate());
            }
            out.println("================================================================");
        }
    }

    public void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/staffpayment.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            staffPayments = (ArrayList<StaffPayment>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("error with reading file");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }
    }

    public void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/staffpayment.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(staffPayments);
            oos.close();
        } catch (IOException e) {
            System.out.println("file output error");
        }
    }
}