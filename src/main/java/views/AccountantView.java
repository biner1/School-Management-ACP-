package main.java.views;

import main.java.dbController.StaffPaymentController;
import main.java.dbController.StudentPaymentController;
import main.java.model.StaffPayment;
import main.java.model.StudentPayment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.sql.ResultSet;


public class AccountantView {

    HashMap<String, String> loggedInAccountant;

    public AccountantView(HashMap<String, String> accountant) {
        loggedInAccountant = accountant;
    }

    PrintWriter out = null;
    BufferedReader in = null;

    public void login(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;

        out.println("successfully logged in as accountant: " + loggedInAccountant.get("username"));

        int choice;
        while (true) {
            out.println("_________enter Accountant choice__________");
            out.println("1.give staff salary \n2.take student payment\n3.display all staff Payment" +
                    " \n4.display all student Payment \n5.delete staff payment " +
                    "\n6.delete Student payment \n7.Number Of All Staff Payments" +
                    "\n8.Number Of All Student Payments \n0.LogOut");
            out.println("@r#");
            try {
                choice = Integer.parseInt(in.readLine());
                if (choice == 1) {
                    giveStaffSalary();
                } else if (choice == 2) {
                    takeStudentPayment();
                } else if (choice == 3) {
                    printStaffPayments(StaffPaymentController.getStaffPayments());
                } else if (choice == 4) {
                    printStudentPayments(StudentPaymentController.getStudentPayments());
                } else if (choice == 5) {
                    removeStaffPayment();
                } else if (choice == 6) {
                    removeStudentPayment();
                } else if (choice == 7) {
                    out.println("The Number of Staff Payment is: " + StaffPaymentController.getStaffPaymentCount());
                } else if (choice == 8) {
                    out.println("The Number of Student Payment is: " + StaffPaymentController.getStaffPaymentCount());
                } else if (choice == 0) {
                    break;
                } else {
                    out.println("pliz enter a given choice");
                }
            } catch (Exception e) {
                out.println("invalid choice");
            }
        }// end of while
    }

    //____________________________StaffPayment Operations______________________

    public void giveStaffSalary() {
//        Scanner sc = new Scanner(System.in);
        int staffId, salary;
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

            StaffPayment staffPayment = new StaffPayment(1, staffId, salary, paymentDate);
            int added = StaffPaymentController.addStaffPayment(staffPayment);
            if (added != 0) {
                out.println("Staff Payment Added Successfully");
            } else {
                out.println("Staff Payment Not Added");
            }
        } catch (Exception e) {
            out.println("invalid inputs");
        }
    }// end of giveStaffSalary()

    public void removeStaffPayment() {

        int id = 0;
        try {
            out.println("Enter Payment ID to remove");
            out.println("@r#");
            id = Integer.parseInt(in.readLine());

            int deleted = StaffPaymentController.deleteStaffPayment(id);
            if (deleted != 0) {
                out.println("Staff Payment Deleted Successfully");
            } else {
                out.println("Staff Payment Not Deleted");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of removeStaffPayment()

    public void printStaffPayments(ResultSet stfP) {

        try {
            if (stfP != null) {
                out.println("ID|Staff ID|Salary|Payment Date");

                while (stfP.next()) {
                    out.println(stfP.getInt("id") + "|" + stfP.getInt("staffID") + "|" +
                            stfP.getInt("salary") + "|" + stfP.getString("date"));
                }
                out.println("____________________________________________________");
            } else {
                out.println("No Staff Payments");
            }
        } catch (Exception e) {
            out.println("error in printing staff payments");
        }

    }

    //____________________________StudentPayment Operations______________________
    public void takeStudentPayment() {
        int studentId, paymentAmount;
        String paymentDate;

        try {
            out.println("Enter Student ID");
            out.println("@r#");
            studentId = Integer.parseInt(in.readLine());
            out.println("Enter Amount Payment");
            out.println("@r#");
            paymentAmount = Integer.parseInt(in.readLine());
            out.println("Enter Payment Date");
            out.println("@r#");
            paymentDate = in.readLine();

            StudentPayment studentPayment = new StudentPayment(1, studentId, paymentAmount, paymentDate);
            int added = StudentPaymentController.addStudentPayment(studentPayment);
            if (added != 0) {
                out.println("Student Payment Added Successfully");
            } else {
                out.println("Student Payment Not Added");
            }

        } catch (Exception e) {
            out.println("invalid inputs");
        }
    }// end of takeStudentPayment()

    public void removeStudentPayment() {

        int id = 0;
        try {
            out.println("Enter Payment ID to remove");
            out.println("@r#");
            id = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            System.err.println("exception in removeStudentPayment(): accountantView"+e.getMessage());
        }
        ;
    }//end of removeStudentPayment()

    public void printStudentPayments(ResultSet stdP) {

        try {
            if (stdP != null) {
                out.println("ID|Student ID|Amount|Payment Date");
                while (stdP.next()) {
                    out.println(stdP.getInt("id") + "|" + stdP.getInt("studentID") + "|" +
                            stdP.getInt("amount") + "|" + stdP.getString("date"));
                }
            } else {
                out.println("No Student Payments");
            }
            out.println("____________________________________________________");
        } catch (Exception e) {
            out.println("error in printing student payments");
        }

    }
}