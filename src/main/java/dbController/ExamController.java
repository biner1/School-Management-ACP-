package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamController{
    public static int addExam(Exam exam){
        String SQL = "INSERT INTO `exam` (`subjectID`, `examDesc`, `date`) VALUES (?,?,?)";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, exam.getSubjectId());
            stm.setString(2, exam.getExamDesc());
            stm.setString(3, exam.getDate());
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db ExamController: addExam()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db ExamController: addExam()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addExam

    public static ResultSet getExams() {
        String SQL = "SELECT * FROM exam";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        }catch (SQLException e){
            System.err.println("SQLException in db ExamController: getExams()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db ExamController: getExams()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getExams

    public static int deleteExam(int examId){
        String SQL = "DELETE FROM exam WHERE id = ?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, examId);
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db ExamController: deleteExam()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db ExamController: deleteExam()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteExam

}
