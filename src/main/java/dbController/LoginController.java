package main.java.dbController;

import main.java.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    public static ResultSet checkLogin(String username, String password) {

        String SQL = "SELECT username,password,role FROM staff WHERE username=? AND password=?";
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setObject(1, username);
            stm.setObject(2, password);
            ResultSet rst = stm.executeQuery();

            if (rst.next()) {
                if (!rst.getString("username").equals(username)) {
                    return null;
                }
                String pwd = rst.getString("password");
                rst.getString("password");
                if (pwd.equals(password)) {
                    return rst;
                }
            }

        }catch (SQLException e){
            System.err.println("SQLException in db loginController");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.err.println("ClassNotFoundException in db loginController");
            System.err.println(e.getMessage());
        }

        return null;
    }// end of checkLogin
}