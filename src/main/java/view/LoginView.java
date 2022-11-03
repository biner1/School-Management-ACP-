package main.java.view;

import java.util.Scanner;

import main.java.controller.StaffList;
import main.java.model.Staff;


public class LoginView {

    public void login() {

        StaffList staffList = new StaffList();
        // login as who
        System.out.println("______________Login view__________________");
        Scanner sc = new Scanner(System.in);

        Staff staff = null;
        while (staff == null) {
            System.out.println("Enter UserName");
            String username = sc.nextLine();

            System.out.println("Enter Password");
            String password = sc.nextLine();


            staff = staffList.getStaffUsernamePassword(username, password);
            if (staff != null) {
                String role = staff.getRole();
                switch (role) {
                    case "ADMIN" -> {
                        AdminView admin = new AdminView(staff);
                        admin.login();
                    }
                    case "TEACHER" -> {
                        TeacherView teacher = new TeacherView(staff);
                        teacher.login();
                    }
                    case "ACCOUNTANT" -> {
                        AccountantView accountant = new AccountantView(staff);
                        accountant.login();
                    }
                } // end of switch


            } else {
                System.out.println("wrong user name or password");
            }
        }
    }// end of login()
}
