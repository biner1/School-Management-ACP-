package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.StaffAttendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffAttendanceController {

    public static int addStaffAttendance(StaffAttendance sa){
        String SQL = "INSERT INTO `staffattendance` (`staffID`, `date`, `status`) VALUES (?,?,?)";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, sa.getStaffId());
            stm.setString(2, sa.getDate());
            stm.setString(3, sa.getStatus());
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db StaffAttendanceController: addStaffAttendance()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StaffAttendanceController: addStaffAttendance()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addStaffAttendance

    public static ResultSet getAllStaffAttendance() {
        String SQL = "SELECT * FROM staffattendance";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        }catch (SQLException e){
            System.err.println("SQLException in db StaffAttendanceController: getStaffAttendance()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StaffAttendanceController: getStaffAttendance()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStaffAttendance

    public static ResultSet getStaffAttendance(String name){
        return null;
    }

    public static int deleteStaffAttendance(int id){
        String SQL = "DELETE FROM staffattendance WHERE staffID = ?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, id);
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db StaffAttendanceController: deleteStaffAttendance()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StaffAttendanceController: deleteStaffAttendance()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteStaffAttendance
}
