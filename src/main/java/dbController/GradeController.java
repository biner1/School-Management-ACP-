package main.java.dbController;

import main.java.db.DBConnection;
import main.java.model.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeController {
    public static int addGrade(Grade g) {
        String sql = "INSERT INTO `grade`(`name`, `year`) VALUES (?,?)";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, g.getGradeName());
            stmt.setInt(2, g.getGradeYear());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLException in db GradeController: addGrade()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db GradeController: addGrade()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of addGrade()

    public static int deleteGrade(String name, int year) {
        String sql = "DELETE FROM `grade` WHERE `name`=? AND `year`=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, year);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLException in db GradeController: deleteGrade()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db GradeController: deleteGrade()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of deleteGrade()

    public static ResultSet getGrades() {
        String sql = "SELECT * FROM `grade`";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("SQLException in db GradeController: getGrades()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db GradeController: getGrades()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getGrades()

    public static ResultSet getGradeStudents(String name, int year) {
        String sql = "SELECT s.username, s.gender, s.phone, s.address, g.name\n" +
                "FROM student s\n" +
                "INNER JOIN grade g ON s.gradeID=g.id where name=? and year=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, year);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("SQLException in db GradeController: getGradeStudents()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db GradeController: getGradeStudents()");
            System.err.println(e.getMessage());
        }
        return null;
    }// end of getGradeStudents()

    public static int getGradeCount() {
        String sql = "SELECT COUNT(*) FROM `grade`";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("SQLException in db GradeController: getGradeCount()");
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException in db GradeController: getGradeCount()");
            System.err.println(e.getMessage());
        }
        return 0;
    }// end of getGradeCount()
}
