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
                studentOps();
            } else if (choice == 3) {
                gradeOps();
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

    public void studentOps(){
        Scanner scn = new Scanner(System.in);

        int choice;
        while(true){
            System.out.println("_______Student Operations________");
            System.out.println("""
                    1.Add Student
                    2.print number of Students
                    3.Display all students
                    4.Display students by name
                    5.Delete student
                    0.back to main""");
            choice = scn.nextInt();
            if (choice == 1){
                addStudent();
            }else if (choice ==2){
                System.out.println("the number of students is: "+studentList.getNumberOfStudents());
            }else if(choice == 3){
                printStudents(studentList.getStudents());
            }else if(choice == 4){
                DisplayStudentsByName();
            }else if(choice == 5){
                deleteStudent();
            } else if (choice ==0){ break;}
            else {
                System.out.println("Enter a valid choice");
            }
        }// end of while
    }

    public void gradeOps(){
        Scanner scn = new Scanner(System.in);

        int choice;
        while(true){
            System.out.println("_______Grade Operations________");
            System.out.println("""
                    1.Add Grade
                    2.print number of Grades
                    3.Display all Grades
                    4.Display all students of a grade
                    5.Delete Grade
                    0.back to main""");
            choice = scn.nextInt();
            if (choice == 1){
                addGrade();
            }else if (choice ==2){
                System.out.println("the number of grades are: "+gradeList.getNumberOfGrades());
            }else if(choice == 3){
                gradeList.printGrades();
            }else if(choice == 4){
                printGradeStudents();
            } else if (choice == 5) {
                deleteGrade();
            } else if (choice ==0){ break;}
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


    //____________________________________Student operations_________________________
    public void addStudent(){

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
            System.out.println("Enter gradeId");
            int gradeId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Password");
            password = sc.nextLine();
            int id = studentList.getMaxId()+1;
            Student student = new Student(id, username, gender, date, email, address, phone, gradeId, password);
            studentList.addStudent(student);
            System.out.println("student "+username +" added to gradeId of "+gradeId);
        }catch(Exception e){
            System.out.println("invalid inputs");
        }
    }// end of addStudent()

    public void DisplayStudentsByName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student username");
        String name = sc.nextLine();
        ArrayList<Student> stList =  studentList.getStudentByUsername(name);
        if(stList.isEmpty()){
            System.out.println("There is no students with that username");
        }else {
            printStudents(stList);
        }
    }

    public void printStudents(ArrayList<Student> stList){
        // printing students with grade
        System.out.println("name|gender|phone|address|grade");
        stList.forEach(s-> {
            Optional<Grade> o=(gradeList.getGradeList().stream().filter(a->a.getGradeId()==s.getGradeId()).findAny());
            if(o.isPresent()){
                Grade r = o.get();
                if(s.getGradeId()==r.getGradeId()){
                    System.out.println(s.getUserName()+"|"+s.getGender()+"|"+s.getPhone()+"|"+s.getAddress()+"|"+r.getGradeName());
                }
            }else {
                System.out.println("students does not exist");
            }

        }); // end stList.forEach()
    }// end of printStudents(ArrayList<Student> stList)

    public void deleteStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name to remove");
        String username = sc.nextLine();
        studentList.deleteStudent(username);
    }

    //____________________________________Grades operations__________________________

    public void addGrade(){
        Scanner sc = new Scanner(System.in);
        int id,gradeYear;
        String gradeName;

        try {
            System.out.println("Enter gradeName");
            gradeName = sc.nextLine();
            System.out.println("Enter gradeYear");
            gradeYear = sc.nextInt();
            sc.nextLine();
            id=gradeList.getMaxId()+1;
            Grade grade = new Grade(id,gradeName,gradeYear);
            gradeList.addGrade(grade);
            System.out.println("The Grade "+gradeName+" was added for year "+gradeYear);
        }catch (Exception e){
            System.out.println("invalid inputs");
        }
    }// end of addGrade()

    public void deleteGrade(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Grade name to remove");
        String gradeName = sc.nextLine();
        gradeList.deleteGrade(gradeName);
    }//deleteGrade()

    public void printGradeStudents(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Grade Name");
        String name = sc.nextLine();
        System.out.println("Enter Grade Year");
        int year = sc.nextInt();
        sc.nextLine();
        int gradeId = gradeList.getGradeByNameYear(name,year);
        if(gradeId == -1){
            System.out.println("There is no Grade with the name: "+name+" and year "+year);
        }
        else {
            ArrayList<Student> stList;
            stList = studentList.getStudents().stream().filter(s -> s.getGradeId() == gradeId).collect(Collectors.toCollection(ArrayList::new));
            if (!stList.isEmpty()) {
                System.out.println("name|email|gender\n------------------------------------");
                stList.forEach(s -> System.out.println(s.getUserName()+"|"+s.getEmail()+"|"+s.getGender()));
                System.out.println("=================================================");
            } else {
                System.out.println("there is no student in the grade: " + name);
            }
        }
    }//printGradeStudents()

}
