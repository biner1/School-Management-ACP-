package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.ExamGrade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamGradeController {
    public static int addExamGrade(ExamGrade eg){
        String SQL = "INSERT INTO `exammark` (`examID`, `studentID`, `mark`) VALUES (?,?,?)";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, eg.getExamId());
            stm.setInt(2, eg.getStudentId());
            stm.setInt(3, eg.getMark());
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db ExamGradeController: addExamGrade()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db ExamGradeController: addExamGrade()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addExamGrade

    public static ResultSet getAllExamGrades() {
        String SQL = "SELECT * FROM exammark";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            return stm.executeQuery();
        }catch (SQLException e){
            System.err.println("SQLException in db ExamGradeController: getAllExamGrades()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db ExamGradeController: getAllExamGrades()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getAllExamGrades

    public static int deleteExamGrade(int id){
        String SQL = "DELETE FROM exammark WHERE id = ?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm;
            stm = conn.prepareStatement(SQL);
            stm.setInt(1, id);
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db ExamGradeController: deleteExamGrade()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db ExamGradeController: deleteExamGrade()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteExamGrade

}

