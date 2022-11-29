package main.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{

    private final String URL= "jdbc:mysql://localhost/sm_system";
    private final String USER= "root";
    private final String PASSWORD= "";
    private final Connection conn;
    private static DBConnection dbConnection;

    private DBConnection()throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection(URL,USER,PASSWORD);
    }
    public Connection getConnection(){

        return conn;
    }
    public static DBConnection getDBConnection()throws ClassNotFoundException,SQLException{
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }

}
