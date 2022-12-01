package main.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import main.java.dbController.LoginController;



public class LoginView {

    public void login(PrintWriter out, BufferedReader in) throws IOException, SQLException {


        // login as who
        out.println("______________Login view__________________");

        String username;
        String password;
        //Staff staff = null;
        while (true) {
            out.println("Enter UserName");
            out.println("@r#");
            username = in.readLine();
            out.println("Enter Password");
            out.println("@r#");
            password = in.readLine();

            ResultSet staff = LoginController.checkLogin(username,password);

            HashMap<String,String> s =new HashMap<>();
            if (staff != null) {
                String role = staff.getString("role");
                s.put("username",username);
                s.put("role",role);

                switch (role) {
                    case "ADMIN" -> {
                        AdminView admin = new AdminView(s);
                        admin.login(out,in);
                    }
                    case "TEACHER" -> {
                        TeacherView teacher = new TeacherView(s);
                        teacher.login(out,in);
                    }
                    case "ACCOUNTANT" -> {
                        AccountantView accountant = new AccountantView(s);
                        accountant.login(out,in);
                    }
                } // end of switch
            } else {
                out.println("wrong user name or password");
            }
            staff =null;
        }
    }// end of login()
}
