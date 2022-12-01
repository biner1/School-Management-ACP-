package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.StudentPayment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentPaymentController {
    public static int addStudentPayment(StudentPayment s) {
        String sql = "INSERT INTO `studentpayment`(`studentID`, `amount`, `date`) VALUES (?,?,?)";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, s.getStudentId());
            stmt.setDouble(2, s.getPaymentAmount());
            stmt.setString(3, s.getPaymentDate());
            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("SQLException in db StudentPaymentController: addStudentPayment()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentPaymentController: addStudentPayment()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addStudentPayment()

    public static ResultSet getStudentPayments(){
        String SQL = "SELECT * FROM studentpayment";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentPaymentController: getStudentPayments()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentPaymentController: getStudentPayments()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStudentPayments()

    public static ResultSet searchStudentPaymentId(String id) {
        String SQL = "SELECT * FROM studentpayment WHERE id=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, id);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentPaymentController: searchStudentPaymentId()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentPaymentController: searchStudentPaymentId()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of searchStudentPaymentId

    public static ResultSet getStudentPaymentStudentID(String id) {
        String SQL = "SELECT * FROM studentpayment WHERE studentID=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, id);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentPaymentController: getStudentPaymentStudentID()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentPaymentController: getStudentPaymentStudentID()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStudentPaymentStudentID

    public static int deleteStudentPayment(String id) {
        String SQL = "DELETE FROM studentpayment WHERE id=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, id);
            return stm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentPaymentController: deleteStudentPayment()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentPaymentController: deleteStudentPayment()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteStudentPayment

    public static int getStudentPaymentCount() {
        String SQL = "SELECT COUNT(*) FROM studentpayment";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentPaymentController: getStudentPaymentCount()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentPaymentController: getStudentPaymentCount()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of getStudentPaymentCount

}
