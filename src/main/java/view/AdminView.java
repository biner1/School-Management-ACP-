package main.java.view;

import main.java.model.Staff;

public class AdminView {

    Staff loggedInAdmin;

    public AdminView(Staff admin){
        loggedInAdmin = admin;
    }

    public void login(){
        System.out.println("successfully logged in as admin: "+loggedInAdmin.getUserName());
    }

}
