package main.java.model.management;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.model.models.StudentPayment;


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
