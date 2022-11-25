package main.java.view;

import main.java.model.Staff;
import main.java.model.StaffRole;
import main.java.controller.StaffList;
import main.java.controller.StudentList;
import main.java.model.Student;
import main.java.controller.GradeList;
import main.java.model.Grade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdminView {

    Staff loggedInAdmin;
    StaffList staffList = new StaffList();
    StudentList studentList = new StudentList();
    GradeList gradeList = new GradeList();

    PrintWriter out = null;
    BufferedReader in = null;

    public AdminView(Staff admin){
        loggedInAdmin = admin;
    }

    public void login(PrintWriter out, BufferedReader in){
        this.out = out;
        this.in=in;

        out.println("You are logged in as admin: "+loggedInAdmin.getUserName());

        int choice;
        while(true){
            out.println("__________enter admin choice___________");
            out.println("\n1.Staff operations\n2.Student operations\n3.Grades operations\n0.exit the program");

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
                    out.println("Enter a valid choice");
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
                    out.println("the number of staffs is: " + staffList.getNumberOfStaffs());
                } else if (choice == 3) {
                    staffList.printStaffs(out);
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
                    2.print number of Students
                    3.Display all students
                    4.Display students by name
                    5.Delete student
                    0.back to main""");

            try {
                out.println("@r#");
                choice = Integer.parseInt(in.readLine());
                if (choice == 1) {
                    addStudent();
                } else if (choice == 2) {
                    out.println("the number of students is: " + studentList.getNumberOfStudents());
                } else if (choice == 3) {
                    printStudents(studentList.getStudents());
                } else if (choice == 4) {
                    DisplayStudentsByName();
                } else if (choice == 5) {
                    deleteStudent();
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
                    out.println("the number of grades are: " + gradeList.getNumberOfGrades());
                } else if (choice == 3) {
                    gradeList.printGrades(out);
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
            StaffRole role = StaffRole.valueOf(in.readLine().toUpperCase());
            out.println("Enter Salary");
            out.println("@r#");
            int salary = Integer.parseInt(in.readLine());
            out.println("Enter Password");
            out.println("@r#");
            password = in.readLine();
            int id = staffList.getMaxId()+1;
            Staff staff = new Staff(id, username, gender, date, email ,address, phone, role, salary, password);
            staffList.addStaff(staff);
            out.println(username +"added as: "+role);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        staffList.deleteStaff(username);
    }


    //____________________________________Student operations_________________________
    public void addStudent(){


        String username, gender, date, email, address, phone, password;

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
            int gradeId = Integer.parseInt(in.readLine());
            out.println("Enter Password");
            out.println("@r#");
            password = in.readLine();
            int id = studentList.getMaxId()+1;
            Student student = new Student(id, username, gender, date, email, address, phone, gradeId, password);
            studentList.addStudent(student);
            out.println("student "+username +" added to gradeId of "+gradeId);
        }catch(Exception e){
            out.println("invalid inputs");
        }
    }// end of addStudent()

    public void DisplayStudentsByName(){

        out.println("Enter Student username");
        String name = null;
        try {
            out.println("@r#");
            name = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Student> stList =  studentList.getStudentByUsername(name);
        if(stList.isEmpty()){
            out.println("There is no students with that username");
        }else {
            printStudents(stList);
        }
    }

    public void printStudents(ArrayList<Student> stList){
        // printing students with grade
        out.println("name|gender|phone|address|grade");
        stList.forEach(s-> {
            Optional<Grade> o=(gradeList.getGradeList().stream().filter(a->a.getGradeId()==s.getGradeId()).findAny());
            if(o.isPresent()){
                Grade r = o.get();
                if(s.getGradeId()==r.getGradeId()){
                    out.println(s.getUserName()+"|"+s.getGender()+"|"+s.getPhone()+"|"+s.getAddress()+"|"+r.getGradeName());
                }
            }else {
                out.println("students does not exist");
            }

        }); // end stList.forEach()
    }// end of printStudents(ArrayList<Student> stList)

    public void deleteStudent(){

        out.println("Enter student name to remove");
        out.println("@r#");
        String username = null;
        try {
            out.println("@r#");
            username = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        studentList.deleteStudent(username);
    }

    //____________________________________Grades operations__________________________

    public void addGrade(){

        int id,gradeYear;
        String gradeName;

        try {
            out.println("Enter gradeName");
            out.println("@r#");
            gradeName = in.readLine();
            out.println("Enter gradeYear");
            out.println("@r#");
            gradeYear = Integer.parseInt(in.readLine());
            id=gradeList.getMaxId()+1;
            Grade grade = new Grade(id,gradeName,gradeYear);
            gradeList.addGrade(grade);
            out.println("The Grade "+gradeName+" was added for year "+gradeYear);
        }catch (Exception e){
            out.println("invalid inputs");
        }
    }// end of addGrade()

    public void deleteGrade(){

        out.println("Enter Grade name to remove");

        String gradeName = null;
        try {
            out.println("@r#");
            gradeName = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gradeList.deleteGrade(gradeName);
    }//deleteGrade()

    public void printGradeStudents(){

        out.println("Enter Grade Name");
        String name = null;
        try {
            out.println("@r#");
            name = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        out.println("Enter Grade Year");
        int year = 0;
        try {
            out.println("@r#");
            year = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int gradeId = gradeList.getGradeByNameYear(name,year);
        if(gradeId == -1){
            out.println("There is no Grade with the name: "+name+" and year "+year);
        }
        else {
            ArrayList<Student> stList;
            stList = studentList.getStudents().stream().filter(s -> s.getGradeId() == gradeId).collect(Collectors.toCollection(ArrayList::new));
            if (!stList.isEmpty()) {
                out.println("name|email|gender\n------------------------------------");
                stList.forEach(s -> out.println(s.getUserName()+"|"+s.getEmail()+"|"+s.getGender()));
                out.println("=================================================");
            } else {
                out.println("there is no student in the grade: " + name);
            }
        }
    }//printGradeStudents()

}
