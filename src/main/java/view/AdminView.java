package main.java.view;

import main.java.model.Staff;
import main.java.model.StaffRole;
import main.java.controller.StaffList;
import main.java.controller.StudentList;
import main.java.model.Student;
import main.java.controller.GradeList;
import main.java.model.Grade;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminView {

    Staff loggedInAdmin;
    StaffList staffList = new StaffList();
    StudentList studentList = new StudentList();
    GradeList gradeList = new GradeList();

    public AdminView(Staff admin){
        loggedInAdmin = admin;
    }

    public void login(){
        System.out.println("You are logged in as admin: "+loggedInAdmin.getUserName());
        Scanner scn = new Scanner(System.in);

        int choice;
        while(true){
            System.out.println("__________enter admin choice___________");
            System.out.println("1.Staff operations\n2.Student operations\n3.Grades operations\n0.exit the program");
            choice = scn.nextInt();
            if (choice == 1){
                staffOps();
            }else if (choice ==2){
              //  studentOps();
            } else if (choice == 3) {
              //  gradeOps();
            }else if (choice ==0){ break;}
            else {
                System.out.println("Enter a valid choice");
            }
        }// end of while
    }

    //____________________________Choice types______________________

    public void staffOps(){
        Scanner scn = new Scanner(System.in);

        int choice;
        while(true){
            System.out.println("_______Staff Operations________");
            System.out.println("""
                    1.Add Staff
                    2.Print number of Staffs
                    3.Display all staff
                    4.Delete Staff
                    0.back to main""");
            choice = scn.nextInt();
            if (choice == 1){
                addStaff();
            }else if (choice ==2){
                System.out.println("the number of staffs is: "+staffList.getNumberOfStaffs());
            }else if (choice==3){
                staffList.printStaffs();
            }else if(choice == 4){
                deleteStaff();
            }else if (choice ==0){break;}
            else {
                System.out.println("Enter a valid choice");
            }
        }// end of while
    }


    // ___________________________Staff Operations_________________________________
    public void addStaff(){
        Scanner sc = new Scanner(System.in);
        String username, gender, date, email, address, phone, password;

        try {
            System.out.println("Enter Username");
            username = sc.nextLine();
            System.out.println("Enter Gender");
            gender = sc.nextLine();
            System.out.println("Enter Birthdate");
            date = sc.nextLine();
            System.out.println("Enter Email");
            email = sc.nextLine();
            System.out.println("Enter Address");
            address = sc.nextLine();
            System.out.println("Enter Phone");
            phone = sc.nextLine();
            System.out.println("Enter Role");
            StaffRole role = StaffRole.valueOf(sc.nextLine().toUpperCase());
            System.out.println("Enter Salary");
            int salary = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Password");
            password = sc.nextLine();
            int id = staffList.getMaxId()+1;
            Staff staff = new Staff(id, username, gender, date, email, address, phone, role, salary, password);
            staffList.addStaff(staff);
            System.out.println(username +"added as: "+role);
        }catch(Exception e){
            System.out.println("invalid inputs");
        }
    }// end of addStaff()

    public void deleteStaff(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Staff name to remove");
        String username = sc.nextLine();
        staffList.deleteStaff(username);
    }


}
