package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentController {

    public static int addStudent(Student s) {
        String sql = "INSERT INTO `student`(`username`, `gender`, `birthdate`, `email`, `address`, `phone`, `gradeID`, `password`) VALUES (?,?,?,?,?,?,?,?)";
        try {
             Connection conn = DBConnection.getDBConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, s.getUserName());
             stmt.setString(2, s.getGender());
             stmt.setString(3, s.getBirthDate());
             stmt.setString(4, s.getEmail());
             stmt.setString(5, s.getAddress());//TODO: change to address from email
             stmt.setString(6, s.getPhone());
             stmt.setInt(7, s.getGradeId());
             stmt.setString(8, s.getUserPassword());
             return stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("SQLException in db StudentController: addStudent()"+e.getMessage());
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentController: addStudent()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addStudent()

    public static ResultSet searchStudentId(String id) {
        String SQL = "SELECT * FROM student WHERE id=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, id);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentController: searchStudentId()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentController: searchStudentId()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of searchStudentId

    public static ResultSet getStudentUsername(String name) {
        String SQL = "SELECT * FROM student WHERE username=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, name);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentController: searchStudentName()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentController: searchStudentName()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of searchStudentName

    public static ResultSet getStudents() {
        String SQL = "SELECT * FROM student";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.isBeforeFirst()) {
                return rst;
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentController: getStudents()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentController: getStudents()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getStudents()

    public static int getStudentCount() {
        String SQL = "SELECT COUNT(*) FROM student";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return rst.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentController: getStudentCount()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentController: getStudentCount()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of getStudentCount()

    public static int deleteStudentUsername(String username) {
        String SQL = "DELETE FROM student WHERE username=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, username);
            return stm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentController: deleteStudentUserName()");
            System.err.println(e.getMessage());
            return 0;
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentController: deleteStudentUserName()");
            System.err.println(e.getMessage());
            return 0;
        }

    }// end of deleteStudentUserName()

    public static int deleteStudentId(int id) {
        String SQL = "DELETE FROM student WHERE id=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, id);
            return stm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLException in db StudentController: deleteStudentId()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db StudentController: deleteStudentId()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteStudentId()
}
