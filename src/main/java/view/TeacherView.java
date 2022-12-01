package main.java.view;

import main.java.dbController.ExamGradeController;
import main.java.dbController.StudentAttendanceController;
import main.java.dbController.StudentController;
import main.java.model.Exam;
import main.java.model.ExamGrade;
import main.java.model.StudentAttendance;
import main.java.dbController.ExamController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class TeacherView {

    HashMap<String,String> loggedInTeacher;

    PrintWriter out = null;
    BufferedReader in = null;
    public TeacherView(HashMap<String,String> teacher){
        loggedInTeacher = teacher;
    }

    public void login(PrintWriter out, BufferedReader in) throws IOException {
        this.out = out;
        this.in=in;

        out.println("successfully logged in as teacher: "+loggedInTeacher.get("username"));

        int choice = -1;
        while(choice !=0){
            out.println("__________enter teacher choice___________");
            out.println("1.Student operations\n0.exit the program");
            out.println("@r#");
            choice = Integer.parseInt(in.readLine());
            if (choice ==1){
                studentOps();
            }else {
                out.println("pliz enter a given choice");
            }
        }// end of while
    }

    public void studentOps() throws IOException {

        int choice = -1;
        while(choice !=99){
            out.println("_______Student Operations________");
            out.println("1.Add exam\n2.print number of Students\n3.print exams\n4.add Student Attendance" +
                    "\n5.delete student attendance\n6.add grade exam\n7.delete exam\n0.back to main");
            out.println("@r#");
            choice = Integer.parseInt(in.readLine());
            if (choice == 1){
                addExam();
            }else if (choice ==2){
                out.println("the number of students is: "+ StudentController.getStudentCount());
            }else if (choice==3){
                printExams(ExamController.getExams());
            }else if (choice==4){
                addStudentAttendance();
            }else if (choice==5){
                deleteStudentAttendance();
            }else if (choice==6){
                addGradeExam();
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
            StudentAttendance studentAttendance = new StudentAttendance(1, studentId, date, status);
            int added = StudentAttendanceController.addStudentAttendance(studentAttendance);
            if (added==0){
                out.println("studentAttendance was not added");
            }
            else {
                out.println("studentAttendance was added");
            }

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
            out.println("Enter Exam Description");
            out.println("@r#");
            examDesc = in.readLine();
            out.println("Enter date");
            out.println("@r#");
            date = in.readLine();
            Exam exam = new Exam(1, subjectId,examDesc, date);
            int added = ExamController.addExam(exam);
            if (added==0){
                out.println("exam was not added");
            }
            else {
                out.println("exam was added\n" + "subject id:" +exam.getSubjectId()+", "
                        +"exam description: "+exam.getExamDesc()+" " +"exam date: "+exam.getDate());

            }
        }catch(Exception e){
            out.println("invalid inputs");
        }
    }

    public void printExams(ResultSet exm) {
        try {
            if (!exm.isBeforeFirst()) {
                out.println("there is no record of exams");
            } else {
                out.println("---------------------------------------------------------------\n" +
                        "examID|subjectID|examDesc|date");
                while (exm.next()) {
                    out.println(exm.getInt("id") + "|" + exm.getInt("subjectID") + "|" +
                            exm.getString("examDesc") + "|" + exm.getDate("date"));
                }
                out.println("================================================================");
            }
        }catch (SQLException e){
            System.err.println("SQL error in printing exams");
            System.err.println(e.getMessage());
        }
        catch (Exception e) {
            out.println("error in printing exams");
        }
    }

    public void addGradeExam(){

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
            ExamGrade examGrade = new ExamGrade(1, studentId,mark, examId);
            int added = ExamGradeController.addExamGrade(examGrade);
            if (added==0){
                out.println("examGrade was not added");
            }
            else {
                out.println("examGrade was added\n" + "examId: "+examGrade.getExamId()+", " +
                        "studentId: "+examGrade.getStudentId()+", " + "mark: "+examGrade.getMark());
            }

        }catch(Exception e){
            out.println("invalid inputs");
        }
    }

    public void deleteExam() {

        try {
            out.println("Enter Exam id to remove");
            out.println("@r#");
            int id = Integer.parseInt(in.readLine());
            int deleted = ExamController.deleteExam(id);
            if (deleted == 0) {
                out.println("exam was not deleted");
            } else {
                out.println("exam was deleted");
            }
        }catch(Exception e){
            System.err.println("exception in deleting exam");
            System.err.println(e.getMessage());
        }
    }// end of deleteExam()

    public void deleteStudentAttendance() throws IOException {

        out.println("Enter Student id to remove");
        out.println("@r#");
        int studentAttendanceId = Integer.parseInt(in.readLine());
        out.println("Enter the date");
        out.println("@r#");
        String date = in.readLine();
        int deleted = StudentAttendanceController.deleteStudentAttendance(studentAttendanceId,date);
        if (deleted==0){
            out.println("studentAttendance was not deleted");
        }
        else {
            out.println("studentAttendance was deleted");
        }
    }

}