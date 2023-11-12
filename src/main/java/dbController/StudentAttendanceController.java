package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.StudentAttendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAttendanceController {

    public static int addStudentAttendance(StudentAttendance sa){
        String SQL = "INSERT INTO `studentattendance` (`studentID`, `date`, `status`) VALUES (?,?,?)";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, sa.getStudentId());
            stm.setString(2, sa.getDate());
            stm.setString(3, sa.getStatus());
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db StudentAttendanceController: addStudentAttendance()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StudentAttendanceController: addStudentAttendance()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addStudentAttendance

    public static void getAllStudentAttendances() {
        String SQL = "SELECT * FROM studentattendance";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.executeQuery();
        }catch (SQLException e){
            System.err.println("SQLException in db StudentAttendanceController: getStudentAttendances()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StudentAttendanceController: getStudentAttendances()");
            System.err.println(e.getMessage());
        }
    }// end of getStudentAttendances

    public static int deleteStudentAttendance(int id, String date){
        String SQL = "DELETE FROM studentattendance WHERE studentID = ? and date = ?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, id);
            stm.setString(1, date);
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db StudentAttendanceController: deleteStudentAttendance()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StudentAttendanceController: deleteStudentAttendance()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteStudentAttendance

    public static ResultSet getStudentAttendance(String name){
        return null;
    }
}
