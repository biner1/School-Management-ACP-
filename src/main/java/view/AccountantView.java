package main.java.view;

import main.java.controller.StaffPaymentList;
import main.java.controller.StudentPaymentList;
import main.java.model.Staff;
import main.java.model.StaffPayment;
import main.java.model.StudentPayment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AccountantView {

    Staff loggedInAccountant;
    StaffPaymentList staffPaymentList = new StaffPaymentList();
    StudentPaymentList studentPaymentList = new StudentPaymentList();

    public AccountantView(Staff accountant) {
        loggedInAccountant = accountant;
    }

    PrintWriter out = null;
    BufferedReader in = null;
    public void login(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in=in;

        out.println("successfully logged in as accountant: " + loggedInAccountant.getUserName());

        int choice;
        while (true) {
            out.println("_________enter Accountant choice__________");
            out.println("1.give staff salary \n2.take student payment\n3.display all staff Payment" +
                    " \n4.display all student Payment \n5.delete staff payment " +
                    "\n6.delete Student payment \n7.Number Of All Staff Payments" +
                    "\n8.Number Of All Student Payments \n0.exit the program");
            out.println("@r#");
            try {
                choice = Integer.parseInt(in.readLine());
                if (choice == 1) {
                    giveStaffSalary();
                } else if (choice == 2) {
                    takeStudentPayment();
                } else if (choice == 3) {
                    staffPaymentList.printStaffPayments(out);
                } else if (choice == 4) {
                    studentPaymentList.printStudentPayments(out);
                } else if (choice == 5) {
                    removeStaffPayment();
                } else if (choice == 6) {
                    removeStudentPayment();
                } else if (choice == 7) {
                    out.println("The Number of Staff Payment is: "+staffPaymentList.getNumberOfStaffPayments());
                } else if (choice == 8) {
                    out.println("The Number of Student Payment is: "+studentPaymentList.getNumberOfStudentPayments());
                }
            }catch (Exception e){
                out.println("invalid choice");
            }
        }// end of while
    }

    //____________________________Choice types______________________

    public void giveStaffSalary() {
//        Scanner sc = new Scanner(System.in);
        int paymentId, staffId, salary;
        String paymentDate;

        try {
            out.println("Enter staff ID");
            out.println("@r#");
            staffId = Integer.parseInt(in.readLine());
            out.println("Enter Staff Salary");
            out.println("@r#");
            salary = Integer.parseInt(in.readLine());
            out.println("Enter payment Date");
            out.println("@r#");
            paymentDate = in.readLine();


            paymentId = staffPaymentList.getMaxId() + 1;
            StaffPayment staffPayment = new StaffPayment(paymentId, staffId, salary, paymentDate);
            staffPaymentList.addStaffPayment(staffPayment);
            out.println("Staff Gets Money");

        } catch (Exception e) {
            out.println("invalid inputs");
        }
    }// end of giveStaffSalary()


    public void takeStudentPayment() {
//        Scanner sc = new Scanner(System.in);
        int paymentId, studentId, paymentAmount;
        String paymentDate;

        try {
            out.println("Enter Student ID");
            out.println("@r#");
            studentId = Integer.parseInt(in.readLine());
            out.println("Enter Amount Payment");
            out.println("@r#");
            paymentAmount =Integer.parseInt(in.readLine());
            out.println("Enter Payment Date");
            out.println("@r#");
            paymentDate = in.readLine();


            paymentId = studentPaymentList.getMaxId() + 1;
            StudentPayment studentPayment = new StudentPayment(paymentId, studentId, paymentAmount, paymentDate);
            studentPaymentList.addStudentPayment(studentPayment);
            out.println("money given from student");

        } catch (Exception e) {
            out.println("invalid inputs");
        }
    }// end of takeStudentPayment()

    public void removeStaffPayment() throws IOException {
//        Scanner sc = new Scanner(System.in);
        out.println("Enter Payment ID to remove");
        out.println("@r#");
        int id = Integer.parseInt(in.readLine());
        staffPaymentList.deletestaffPayment(id);
        out.println("staff: "+id +"was removed");
    } // end of removeStaffPayment()

    public void removeStudentPayment() throws IOException {
//        Scanner sc = new Scanner(System.in);
        out.println("Enter Payment ID to remove");
        out.println("@r#");
        int id = Integer.parseInt(in.readLine());
        studentPaymentList.deleteStudentPayment(id);
        out.println("Student: "+id +"was removed");
    }//end of removeStudentPayment()
}