package main.java.view;

import main.java.controller.ExamGradeList;
import main.java.controller.ExamList;
import main.java.controller.StudentAttendanceList;
import main.java.controller.StudentList;
import main.java.model.Exam;
import main.java.model.ExamGrade;
import main.java.model.Staff;
import main.java.model.StudentAttendance;

import java.util.Scanner;

public class TeacherView {

    Staff loggedInTeacher;
    StudentList studentList = new StudentList();
    ExamList examList = new ExamList();
    StudentAttendanceList studentAttendanceList = new StudentAttendanceList();
    ExamGradeList examGradeList = new ExamGradeList();

    public TeacherView(Staff teacher){
        loggedInTeacher = teacher;
    }

    public void login(){
        System.out.println("successfully logged in as teacher: "+loggedInTeacher.getUserName());
        Scanner scn = new Scanner(System.in);

        int choice = -1;
        while(choice !=0){
            System.out.println("__________enter teacher choice___________");
            System.out.println("1.Student operations\n0.exit the program");
            choice = scn.nextInt();
            if (choice ==1){
                studentOps();
            }
        }// end of while
    }

    public void studentOps(){
        Scanner scn = new Scanner(System.in);

        int choice = -1;
        while(choice !=99){
            System.out.println("_______Student Operations________");
            System.out.println("1.Add exam\n2.print number of Students\n3.print exams \n0.back to main");
            choice = scn.nextInt();
            if (choice == 1){
//                addExam();
            }else if (choice ==2){
                System.out.println("the number of students is: "+studentList.getNumberOfStudents());
            }else if (choice==3){
                examList.printExam();
            }else if (choice==4){
                addStudentAttendance();
            }else if (choice==5){
//                gradeExam();
            }else if (choice ==0){ break;}
        }// end of while
    }

    public void addStudentAttendance(){

        Scanner sc = new Scanner(System.in);
        int studentId;
        String  date, status;

        try {
            System.out.println("Enter StudentId");
            studentId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter date");
            date = sc.nextLine();
            System.out.println("Enter status");
            status = sc.nextLine();
            int id = studentAttendanceList.getMaxId()+1;
            StudentAttendance studentAttendance = new StudentAttendance(id, studentId,status, date);
            studentAttendanceList.addStudentAttendance(studentAttendance);
            System.out.println("StudentId: "+studentId +"Date: "+date+"Status: " +status);
            sc.close();
        }catch(Exception e){
            System.out.println("invalid inputs");
        }
    }

}