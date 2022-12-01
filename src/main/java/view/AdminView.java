package main.java.view;

import main.java.dbController.StudentController;
import main.java.dbController.GradeController;
import main.java.dbController.StaffController;
import main.java.model.Staff;
import main.java.model.StaffRole;
import main.java.model.Student;
import main.java.model.Grade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AdminView {

    HashMap<String,String> loggedInAdmin;

    PrintWriter out = null;
    BufferedReader in = null;

    public AdminView(HashMap<String,String> admin){
        loggedInAdmin = admin;
    }

    public void login(PrintWriter out, BufferedReader in){
        this.out = out;
        this.in=in;

        out.println("You are logged in as admin: "+loggedInAdmin.get("username"));

        int choice;
        while(true){
            out.println("__________enter admin choice___________");
            out.println("\n1.Staff operations\n2.Student operations\n3.Grades operations\n0.LogOut");

            try {
                out.println("@r#");
                choice = Integer.parseInt(in.readLine());

                if (choice == 1){
                    staffOps();
                }else if (choice ==2){
                    studentOps();
                } else if (choice == 3) {
                    gradeOps();
                }else if (choice ==0){ break;}
                else {
                    out.println("please enter a given choice");
                }
            }catch (Exception e){
                out.println("invalid input");
            }
        }// end of while
    }

    //____________________________Choice types______________________

    public void staffOps(){

        int choice;
        while(true){
            out.println("\n_______Staff Operations________");
            out.println("""
                    1.Add Staff
                    2.Print number of Staffs
                    3.Display all staff
                    4.Delete Staff
                    0.back to main""");

            try {
                out.println("@r#");
                choice = Integer.parseInt(in.readLine());
                if (choice == 1) {
                    addStaff();
                } else if (choice == 2) {
                    out.println("the number of staffs is: " + StaffController.getStaffCount());
                } else if (choice == 3) {
                    ResultSet rs = StaffController.getStaffs();
                    if(rs!=null){
                        printStaffs(rs);
                    }else {
                        out.println("no staffs found");
                    }
                } else if (choice == 4) {
                    deleteStaff();
                } else if (choice == 0) {
                    break;
                } else {
                    out.println("Enter a valid choice");
                }
            }catch (Exception e){
                out.println("invalid choice");
            }
        }// end of while
    }

    public void studentOps(){

        int choice;
        while(true){
            out.println("\n_______Student Operations________");
            out.println("""
                    1.Add Student
                    2.Print number of Students
                    3.Display all students
                    4.Display students by name
                    5.Delete student by name
                    6.Delete student by id
                    0.back to main""");

            try {
                out.println("@r#");
                choice = Integer.parseInt(in.readLine());
                if (choice == 1) {
                    addStudent();
                } else if (choice == 2) {
                    out.println("the number of students is: " + StudentController.getStudentCount());
                } else if (choice == 3) {
                    ResultSet rs = StudentController.getStudents();
                    printStudents(rs);
                } else if (choice == 4) {
                    displayStudentsByName();
                } else if (choice == 5) {
                    deleteStudentUsername();
                }else if (choice == 6){
                    deleteStudentId();
                } else if (choice == 0) {
                    break;
                } else {
                    out.println("Enter a valid choice");
                }
            } catch (IOException e) {
                out.println("invalid choice");
            }
        }// end of while
    }

    public void gradeOps(){

        int choice;
        while(true){
            out.println("\n_______Grade Operations________");
            out.println("""
                    1.Add Grade
                    2.print number of Grades
                    3.Display all Grades
                    4.Display all students of a grade
                    5.Delete Grade
                    0.back to main""");
            try {
                out.println("@r#");
                choice = Integer.parseInt(in.readLine());
                if (choice == 1) {
                    addGrade();
                } else if (choice == 2) {
                    out.println("the number of grades are: " + GradeController.getGradeCount());
                } else if (choice == 3) {
                    ResultSet rs = GradeController.getGrades();
                    if (rs != null) {
                        printGrades(rs);
                    }else {
                        out.println("No grades found");
                    }
                } else if (choice == 4) {
                    printGradeStudents();
                } else if (choice == 5) {
                    deleteGrade();
                } else if (choice == 0) {
                    break;
                } else {
                    out.println("Enter a valid choice");
                }
            }catch (Exception e){
                out.println("invalid input");
            }
        }// end of while
    }


    // ___________________________Staff Operations_________________________________
    public void addStaff(){

        String username, gender, date, email, address, phone, password;
        StaffRole role;
        try {
            out.println("Enter Username");
            out.println("@r#");
            username = in.readLine();
            out.println("Enter Gender");
            out.println("@r#");
            gender = in.readLine();
            out.println("Enter Birthdate");
            out.println("@r#");
            date = in.readLine();
            out.println("Enter Email");
            out.println("@r#");
            email = in.readLine();
            out.println("Enter Address");
            out.println("@r#");
            address = in.readLine();
            out.println("Enter Phone");
            out.println("@r#");
            phone = in.readLine();
            out.println("Enter Role");
            out.println("@r#");
            role = StaffRole.valueOf(in.readLine().toUpperCase());
            out.println("Enter Salary");
            out.println("@r#");
            int salary = Integer.parseInt(in.readLine());
            out.println("Enter Password");
            out.println("@r#");
            password = in.readLine();
            Staff staff = new Staff(1, username, gender, date, email ,address, phone, role, salary, password);
            int added = StaffController.addStaff(staff);
            if(added == 0)
                out.println("staff "+username +" not added");
            else
                out.println("staff "+username +" added with role of "+role);
        }catch(Exception e){
            out.println("invalid inputs");
        }
    }// end of addStaff()

    public void deleteStaff(){

        out.println("Enter Staff name to remove");
        String username = null;
        try {
            out.println("@r#");
            username = in.readLine();
            int rs = StaffController.deleteStaffUsername(username);
            if(rs == 0)
                out.println("staff "+username +" not deleted");
            else
                out.println("staff "+username +" deleted");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printStaffs(ResultSet stfList){
        try {
            out.println("id|username|gender|birthdate|email|address|phone|role|salary");
            while (stfList.next()) {
                out.println(stfList.getInt("id") + "|" + stfList.getString("username") + "|" +
                        stfList.getString("gender")+ "|" + stfList.getString("birthdate") + "|" +
                        stfList.getString("email") + "|" + stfList.getString("address") + "|" +
                        stfList.getString("phone") + "|" + stfList.getString("role")+ "|" +
                        stfList.getString("salary"));
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    //____________________________________Student operations_________________________
    public void addStudent(){

        String username, gender, date, email, address, phone,password;
        int gradeId;
        try {
            out.println("Enter Username");
            out.println("@r#");
            username = in.readLine();
            out.println("Enter Gender");
            out.println("@r#");
            gender = in.readLine();
            out.println("Enter Birthdate");
            out.println("@r#");
            date = in.readLine();
            out.println("Enter Email");
            out.println("@r#");
            email = in.readLine();
            out.println("Enter Address");
            out.println("@r#");
            address = in.readLine();
            out.println("Enter Phone");
            out.println("@r#");
            phone = in.readLine();
            out.println("Enter gradeId");
            out.println("@r#");
            gradeId = Integer.parseInt(in.readLine());
            out.println("Enter Password");
            out.println("@r#");
            password = in.readLine();
            Student student = new Student(1, username, gender, date, email, address, phone, gradeId, password);
            int added = StudentController.addStudent(student);
            if(added != 0)
                out.println("student "+username +" added to gradeId of "+gradeId);
            else
                out.println("student "+username +" not added");
        }catch(Exception e){
            out.println("invalid inputs");
        }
    }// end of addStudent()

    public void displayStudentsByName(){
        out.println("Enter Student username");
        String name = null;
        try {
            out.println("@r#");
            name = in.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        ResultSet rs = StudentController.getStudentUsername(name);
        if (rs != null) {
            printStudents(rs);
        } else {
            out.println("There is no students with that username");
        }

    }

    public void printStudents(ResultSet stList){

        try {
            if (stList != null) {
                out.println("id|username|gender|birthdate|email|address|phone|gradeId");
                while (stList.next()) {
                    out.println(stList.getInt("id") + "|" + stList.getString("username") + "|" +
                            stList.getString("gender")+ "|" + stList.getString("birthdate") + "|" +
                            stList.getString("email") + "|" + stList.getString("address") + "|" +
                            stList.getString("phone") + "|" + stList.getInt("gradeId"));
                }
            }else {
                out.println("No students found");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }// end of printStudents(ResultSet)

    public void deleteStudentUsername(){

        out.println("Enter student username to remove");
        String username = null;
        try {
            out.println("@r#");
            username = in.readLine();
            int rs = StudentController.deleteStudentUsername(username);
            if(rs==0)
                out.println("student "+username +" not deleted");
            else
                out.println("student "+username +" deleted");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteStudentId(){

        out.println("Enter student id to remove");
        int id = 0;
        try {
            out.println("@r#");
            id = Integer.parseInt(in.readLine());
            int rs = StudentController.deleteStudentId(id);
            if(rs==0)
                out.println("student "+id +" not deleted");
            else
                out.println("student "+id +" deleted");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    //____________________________________Grades operations__________________________

    public void addGrade(){

        int gradeYear;
        String gradeName;

        try {
            out.println("Enter gradeName");
            out.println("@r#");
            gradeName = in.readLine();
            out.println("Enter gradeYear");
            out.println("@r#");
            gradeYear = Integer.parseInt(in.readLine());
            Grade grade = new Grade(1,gradeName,gradeYear);

            int gradeAdded = GradeController.addGrade(grade);
            if(gradeAdded == 0)
                out.println("grade "+gradeName +" not added");
            else
                out.println("grade "+gradeName +" added");
        }catch (Exception e){
            out.println("invalid inputs");
        }
    }// end of addGrade()

    public void deleteGrade(){

        String gradeName = null;
        int year = 0;
        try {
            out.println("Enter Grade name to remove");
            out.println("@r#");
            gradeName = in.readLine();
            out.println("Enter Grade year to remove");
            out.println("@r#");
            year = Integer.parseInt(in.readLine());
            int rs = GradeController.deleteGrade(gradeName,year);
            if(rs == 0)
                out.println("grade "+gradeName +" not deleted");
            else
                out.println("grade "+gradeName +" deleted");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//deleteGrade()

    public void printGrades(ResultSet grList){

        try {
            out.println("id|gradeName|gradeYear");
            while (grList.next()) {
                out.println(grList.getInt("id") + "|" + grList.getString("name") + "|" +
                        grList.getInt("year"));
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }// end of printGrades(ResultSet)

    public void printGradeStudents(){

        String name = null;
        int year = 0;
        try {
            out.println("Enter Grade Name");
            out.println("@r#");
            name = in.readLine();
            out.println("Enter Grade Year");
            out.println("@r#");
            year = Integer.parseInt(in.readLine());
            ResultSet stList = GradeController.getGradeStudents(name,year);
            if(stList == null) {
                out.println("There is no students in this grade");
            }
            else {
                while(stList.next()){
                    out.println(stList.getString("username") + "|" + stList.getString("gender")+ "|" +
                            stList.getString("address") + "|" + stList.getString("phone") + "|" +
                            stList.getString("name"));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }catch (SQLException e){
            System.err.println("SQLException in printGradeStudents()");
            System.err.println(e.getMessage());
        }

    }//printGradeStudents()

}
