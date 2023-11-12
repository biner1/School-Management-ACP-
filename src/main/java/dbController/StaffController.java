package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffController {

    public static int addStaff(Staff s) {
        String SQL = "INSERT INTO `staff` (`username`, `gender`, `birthdate`, `email`, `address`, `phone`, `role`, `salary`, `password`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setString(1, s.getUserName());
            stm.setString(2, s.getGender());
            stm.setString(3, s.getBirthDate());
            stm.setString(4, s.getEmail());
            stm.setString(5, s.getAddress());
            stm.setString(6, s.getPhone());
            stm.setString(7, s.getRole());
            stm.setInt(8, s.getSalary());
            stm.setString(9, s.getUserPassword());

            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db StaffController: addStaff()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StaffController: addStaff()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addStaff

    public static ResultSet getStaffName(String username) {
        String SQL = "SELECT * FROM staff WHERE username=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, username);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        }catch (SQLException e){
            System.err.println("SQLException in db StaffController: getStaffName()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StaffController: getStaffName()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStaff

    public static ResultSet getStaffs() {
        String SQL = "SELECT * FROM staff";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        }catch (SQLException e){
            System.err.println("SQLException in db StaffController: getStaff()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StaffController: getStaff()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStaff

    public static int getStaffCount() {
        String SQL = "SELECT COUNT(*) FROM staff";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst.getInt(1);
            }
        }catch (SQLException e){
            System.err.println("SQLException in db StaffController: getStaffCount()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StaffController: getStaffCount()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of getStaffCount

    public static int deleteStaffUsername(String username) {
        String SQL = "DELETE FROM staff WHERE username=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, username);
            return stm.executeUpdate();
        }catch (SQLException e){
            System.err.println("SQLException in db StaffController: deleteStaff()");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db StaffController: deleteStaff()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteStaff
}
