package main.java.model.management;
import main.java.model.models.StudentPayment;
import java.util.ArrayList;

public class StudentPaymentList {
    private ArrayList<StudentPayment>StudentPayments;

    public StudentPaymentList(){
        StudentPayments.add(new StudentPayment(1, 1, 10000, "4-1-2022"));
        StudentPayments.add(new StudentPayment(2, 2, 10000, "10-1-2022"));
        StudentPayments.add(new StudentPayment(3, 3, 10000, "5-1-2022"));
        StudentPayments.add(new StudentPayment(4, 4, 10000, "13-1-2022"));
        StudentPayments.add(new StudentPayment(5, 2, 10000, "7-1-2022"));
    }

    public void addStudentPayment(StudentPayment studentPayment){
        StudentPayments.add(studentPayment);
    }

    public ArrayList<StudentPayment> getStudentPayments(){
        return StudentPayments;
    }

}