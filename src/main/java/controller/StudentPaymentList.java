package main.java.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.model.StudentPayment;


public class StudentPaymentList {
    private ArrayList<StudentPayment>studentPayments;

    public StudentPaymentList(){

        studentPayments = new ArrayList<>();

        studentPayments.add(new StudentPayment(1, 1, 10000, "4-1-2022"));
        studentPayments.add(new StudentPayment(2, 2, 10000, "10-1-2022"));
        studentPayments.add(new StudentPayment(3, 3, 10000, "5-1-2022"));
        studentPayments.add(new StudentPayment(4, 4, 10000, "13-1-2022"));
        studentPayments.add(new StudentPayment(5, 2, 10000, "7-1-2022"));
    }

    public void addStudentPayment(StudentPayment studentPayment){
        readFromFile();
        studentPayments.add(studentPayment);
        saveToFile();
    }

    public boolean deleteStudentPayment(int id){
        readFromFile();
        int ind = findStudentPayment(id);
        if (ind == -1){
            System.out.println("there is no staff with the name: "+id);
            return false;
        }
        studentPayments.remove(ind);
        System.out.println("staff: "+id+" was removed");
        saveToFile();
        return true;
    }

    public int findStudentPayment(int id){
        for(int i=0;i<studentPayments.size();i++){
            StudentPayment studentPayment = studentPayments.get(i);
            if (studentPayment.getPaymentId()==(id)){ return i;}
        }
        return -1;
    }

    public ArrayList<StudentPayment> getStudentPayments(){
        readFromFile();
        return studentPayments;
    }


    public ArrayList<StudentPayment> getStudentPaymentByDate(String date){
        readFromFile();
        return studentPayments.stream().filter(g -> Objects.equals(g.getPaymentDate(), date)).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<StudentPayment> getStaffPaymentByAmount(int amount){
        readFromFile();
        return studentPayments.stream().filter(s -> s.getPaymentAmount() ==(amount)).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getNumberOfStudentPayments(){
        readFromFile();
        return studentPayments.size();
    }

    public int getMaxId(){
        readFromFile();
        try{
            int id = studentPayments.stream().max(Comparator.comparing(StudentPayment::getPaymentId)).get().getPaymentId();
            return id;
        }catch(Exception e){
            return 0;
        }
    }

    public void printStudentPayments(PrintWriter out){
        readFromFile();
        if(studentPayments.isEmpty()){
            out.println("there is no record of staff");
        }else{
            out.println("---------------------------------------------------------------\n" +
                    "payment Id|Student Id|Amount Payment|Payment Date");
            for(StudentPayment s:studentPayments){
                out.println(s.getPaymentId()+"|"+s.getStudentId()+"|"+s.getPaymentAmount()+"|"+s.getPaymentDate());
            }
            out.println("================================================================");
        }
    }

    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/studentpayment.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentPayments);
            oos.close();
        }
        catch (IOException e){
            System.out.println("file output error");
        }
    }

    public ArrayList<StudentPayment> readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/studentpayment.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentPayments = (ArrayList<StudentPayment>) ois.readObject();
            ois.close();
            return studentPayments;
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