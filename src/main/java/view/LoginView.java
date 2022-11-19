package main.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import main.java.controller.StaffList;
import main.java.model.Staff;


public class LoginView {

    public void login(PrintWriter out, BufferedReader in) throws IOException {

        StaffList staffList = new StaffList();
        // login as who
        out.println("______________Login view__________________");

        String username;
        String password;
        Staff staff = null;
        while (true) {
            out.println("Enter UserName");
            out.println("@r#");
            username = in.readLine();
            out.println("Enter Password");
            out.println("@r#");
            password = in.readLine();

            staff = staffList.getStaffUsernamePassword(username, password);
            if (staff != null) {
                String role = staff.getRole();
                switch (role) {
                    case "ADMIN" -> {
                        AdminView admin = new AdminView(staff);
                        admin.login(out,in);
                    }
                    case "TEACHER" -> {
                        TeacherView teacher = new TeacherView(staff);
                        teacher.login(out,in);
                    }
                    case "ACCOUNTANT" -> {
                        AccountantView accountant = new AccountantView(staff);
                        accountant.login(out,in);
                    }
                } // end of switch
            } else {
                out.println("wrong user name or password");
            }
        }
    }// end of login()
}
