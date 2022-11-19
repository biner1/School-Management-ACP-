package main.java.view;

import main.java.controller.ExamGradeList;
import main.java.controller.ExamList;
import main.java.controller.StudentAttendanceList;
import main.java.controller.StudentList;
import main.java.model.Exam;
import main.java.model.ExamGrade;
import main.java.model.Staff;
import main.java.model.StudentAttendance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TeacherView {

    Staff loggedInTeacher;
    StudentList studentList = new StudentList();
    ExamList examList = new ExamList();
    StudentAttendanceList studentAttendanceList = new StudentAttendanceList();
    ExamGradeList examGradeList = new ExamGradeList();

    PrintWriter out = null;
    BufferedReader in = null;
    public TeacherView(Staff teacher){
        loggedInTeacher = teacher;
    }

    public void login(PrintWriter out, BufferedReader in) throws IOException {
        this.out = out;
        this.in=in;

        out.println("successfully logged in as teacher: "+loggedInTeacher.getUserName());

        int choice = -1;
        while(choice !=0){
            out.println("__________enter teacher choice___________");
            out.println("1.Student operations\n0.exit the program");
            out.println("@r#");
            choice = Integer.parseInt(in.readLine());
            if (choice ==1){
                studentOps();
            }
        }// end of while
    }

    public void studentOps() throws IOException {

        int choice = -1;
        while(choice !=99){
            out.println("_______Student Operations________");
            out.println("1.Add exam\n2.print number of Students\n3.print exams\n4.add Student Attendance \n5.delete student attendance \n6.add grade exam\n7.delete exam \n0.back to main");
            out.println("@r#");
            choice = Integer.parseInt(in.readLine());
            if (choice == 1){
                addExam();
            }else if (choice ==2){
                out.println("the number of students is: "+studentList.getNumberOfStudents());
            }else if (choice==3){
                examList.printExam(out);
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

        int studentId;
        String  date, status;

        try {
            out.println("Enter StudentId");
            out.println("@r#");
            studentId = Integer.parseInt(in.readLine());
            out.println("Enter date");
            out.println("@r#");
            date = in.readLine();
            out.println("Enter status");
            out.println("@r#");
            status = in.readLine();
            int id = studentAttendanceList.getMaxId()+1;
            StudentAttendance studentAttendance = new StudentAttendance(id, studentId,status, date);
            studentAttendanceList.addStudentAttendance(studentAttendance);
            out.println("StudentId: "+studentId +"Date: "+date+"Status: " +status);
        }catch(Exception e){
            out.println("invalid inputs");
        }
    }

    public void addExam(){

        int subjectId;
        String  examDesc, date;

        try {
            out.println("Enter SubjectId");
            out.println("@r#");
            subjectId = Integer.parseInt(in.readLine());
            out.println("Enter Exam name");
            out.println("@r#");
            examDesc = in.readLine();
            out.println("Enter date");
            out.println("@r#");
            date = in.readLine();
            int id = studentList.getMaxId()+1;
            Exam exam = new Exam(id, subjectId,examDesc, date);
            examList.addExam(exam);
            out.println("subject:"+examDesc +"date: "+date);
        }catch(Exception e){
            out.println("invalid inputs");
        }
    }

    public void gradeExam(){

        int studentId, mark, examId;

        try {
            out.println("Enter studentId");
            out.println("@r#");
            studentId = Integer.parseInt(in.readLine());
            out.println("Enter mark");
            out.println("@r#");
            mark = Integer.parseInt(in.readLine());
            out.println("Enter examId");
            out.println("@r#");
            examId = Integer.parseInt(in.readLine());
            int id = studentList.getMaxId()+1;
            ExamGrade examGrade = new ExamGrade(id, studentId,mark, examId);
            examGradeList.addExamGrade(examGrade);
            out.println("studentId:"+studentId +"mark: "+mark+"examId:"+examId);
        }catch(Exception e){
            out.println("invalid inputs");
        }
    }

    public void deleteExam() throws IOException {

        out.println("Enter Exam name to remove");
        out.println("@r#");
        String examName = in.readLine();
        examList.deleteGrade(examName);
    }

    public void deleteStudentAttendance() throws IOException {

        out.println("Enter Student id to remove");
        out.println("@r#");
        int studentAttendanceId = Integer.parseInt(in.readLine());
        studentAttendanceList.deleteStudentAttendance(studentAttendanceId);
    }

}