package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.StaffPayment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffPaymentController {

    public static int addStaffPayment(StaffPayment s) {
        String sql = "INSERT INTO `staffpayment`(`staffID`, `salary`, `date`) VALUES (?,?,?)";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, s.getStaffId());
            stmt.setDouble(2, s.getSalary());
            stmt.setString(3, s.getPaymentDate());
            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("SQLException in db StaffPaymentController: addStaffPayment()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StaffPaymentController: addStaffPayment()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addStaffPayment()

    public static int deleteStaffPayment(int id) {
        String sql = "DELETE FROM `staffpayment` WHERE `id`=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("SQLException in db StaffPaymentController: deleteStaffPayment()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StaffPaymentController: deleteStaffPayment()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteStaffPayment()

    public static ResultSet getStaffPayments(){
        String SQL = "SELECT * FROM staffpayment";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StaffPaymentController: getStaffPayments()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StaffPaymentController: getStaffPayments()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStaffPayments()

    public static ResultSet searchStaffPaymentId(String id) {
        String SQL = "SELECT * FROM staffpayment WHERE id=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, id);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StaffPaymentController: searchStaffPaymentId()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StaffPaymentController: searchStaffPaymentId()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of searchStaffPaymentId

    public static ResultSet getStaffPaymentStaffID(String id) {
        String SQL = "SELECT * FROM staffpayment WHERE staffID=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, id);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StaffPaymentController: getStaffPaymentStaffID()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StaffPaymentController: getStaffPaymentStaffID()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStaffPaymentStaffID

    public static ResultSet getStaffPaymentDate(String date) {
        String SQL = "SELECT * FROM staffpayment WHERE date=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, date);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StaffPaymentController: getStaffPaymentDate()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StaffPaymentController: getStaffPaymentDate()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStaffPaymentDate

    public static int getStaffPaymentCount() {
        String SQL = "SELECT COUNT(*) FROM staffpayment";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StaffPaymentController: getStaffPaymentCount()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StaffPaymentController: getStaffPaymentCount()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of getStaffPaymentCount

}

