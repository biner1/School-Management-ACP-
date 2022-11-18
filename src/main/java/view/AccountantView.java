package main.java.view;

import main.java.controller.StaffPaymentList;
import main.java.controller.StudentPaymentList;
import main.java.model.Staff;
import main.java.model.StaffPayment;
import main.java.model.StudentPayment;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        System.out.println("successfully logged in as accountant: " + loggedInAccountant.getUserName());
        Scanner scn = new Scanner(System.in);

        int choice = -1;
        while (choice != 0) {
            System.out.println("_________enter Accountant choice__________");
            System.out.println("1.give staff salary \n2.take student payment\n3.display all staff Payment" +
                    " \n4.display all student Payment \n5.delete staff payment " +
                    "\n6.delete Student payment \7.Number Of All Staff Payments" +
                    "\n8.Number Of All Student Payments \n0.exit the program");

            choice = scn.nextInt();
            if (choice == 1) {
                giveStaffSalary();
            } else if (choice == 2) {
                takeStudentPayment();
            } else if (choice == 3) {
                staffPaymentList.printStaffPayments();
            } else if (choice == 4) {
                studentPaymentList.printStudentPayments();
            } else if (choice == 5) {
                removeStaffPayment();
            } else if (choice == 6) {
                removeStudentPayment();
            } else if (choice == 7) {
                staffPaymentList.getNumberOfStaffPayments();
            } else if (choice == 8) {
                studentPaymentList.getNumberOfStudentPayments();
            }// end of while
        }
    }

    //____________________________Choice types______________________

    public void giveStaffSalary() {
        Scanner sc = new Scanner(System.in);
        int paymentId, staffId, salary;
        String paymentDate;

        try {
            System.out.println("Enter staff ID");
            staffId = sc.nextInt();
            System.out.println("Enter Staff Salary");
            salary = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter payment Date");
            paymentDate = sc.nextLine();


            paymentId = staffPaymentList.getMaxId() + 1;
            StaffPayment staffPayment = new StaffPayment(paymentId, staffId, salary, paymentDate);
            staffPaymentList.addStaffPayment(staffPayment);
            System.out.println("Staff Gets Money");

        } catch (Exception e) {
            System.out.println("invalid inputs");
        }
    }// end of giveStaffSalary()


    public void takeStudentPayment() {
        Scanner sc = new Scanner(System.in);
        int paymentId, studentId, paymentAmount;
        String paymentDate;

        try {
            System.out.println("Enter Student ID");
            studentId = sc.nextInt();
            System.out.println("Enter Amount Payment");
            paymentAmount = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Payment Date");
            paymentDate = sc.nextLine();


            paymentId = studentPaymentList.getMaxId() + 1;
            StudentPayment studentPayment = new StudentPayment(paymentId, studentId, paymentAmount, paymentDate);
            studentPaymentList.addStudentPayment(studentPayment);
            System.out.println("money given from student");

        } catch (Exception e) {
            System.out.println("invalid inputs");
        }
    }// end of takeStudentPayment()

    public void removeStaffPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Payment ID to remove");
        int id = sc.nextInt();
        staffPaymentList.deletestaffPayment(id);
    } // end of removeStaffPayment()

    public void removeStudentPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Payment ID to remove");
        int id = sc.nextInt();
        studentPaymentList.deleteStudentPayment(id);
    }//end of removeStudentPayment()
}