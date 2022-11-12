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
            System.out.println("1.Add exam\n2.print number of Students\n3.print exams\n4.add Student Attendance \n5.delete student attendance \n6.add grade exam\n7.delete exam \n0.back to main");
            choice = scn.nextInt();
            if (choice == 1){
                addExam();
            }else if (choice ==2){
                System.out.println("the number of students is: "+studentList.getNumberOfStudents());
            }else if (choice==3){
                examList.printExam();
            }else if (choice==4){
                addStudentAttendance();
            }else if (choice==5){
                deleteStudentAttendance();
            }else if (choice==6){
                gradeExam();
            }else if (choice==7){
                deleteExam();
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

    public void addExam(){

        Scanner sc = new Scanner(System.in);
        int subjectId;
        String  examDesc, date;

        try {
            System.out.println("Enter SubjectId");
            subjectId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Exam name");
            examDesc = sc.nextLine();
            System.out.println("Enter date");
            date = sc.nextLine();
            int id = studentList.getMaxId()+1;
            Exam exam = new Exam(id, subjectId,examDesc, date);
            examList.addExam(exam);
            System.out.println("subject:"+examDesc +"date: "+date);
            sc.close();
        }catch(Exception e){
            System.out.println("invalid inputs");
        }
    }

    public void gradeExam(){

        Scanner sc = new Scanner(System.in);
        int studentId, mark, examId;

        try {
            System.out.println("Enter studentId");
            studentId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter mark");
            mark = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter examId");
            examId = sc.nextInt();
            int id = studentList.getMaxId()+1;
            ExamGrade examGrade = new ExamGrade(id, studentId,mark, examId);
            examGradeList.addExamGrade(examGrade);
            System.out.println("studentId:"+studentId +"mark: "+mark+"examId:"+examId);
            sc.close();
        }catch(Exception e){
            System.out.println("invalid inputs");
        }
    }

    public void deleteExam(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Exam name to remove");
        String examName = sc.nextLine();
        examList.deleteGrade(examName);
    }

    public void deleteStudentAttendance(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student id to remove");
        int studentAttendanceId = sc.nextInt();
        studentAttendanceList.deleteStudentAttendance(studentAttendanceId);
    }

}