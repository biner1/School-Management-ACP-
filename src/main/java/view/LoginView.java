package main.java.view;

import java.util.Scanner;

public class LoginView {

    public void login(){
        // login as who
        String loginChoice = "1.Login as Principle\n2.Login as Teacher\n3.Login as Accountant";
        System.out.println(loginChoice);
        Scanner sc= new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println(choice);

    }
}
