package main.java.view;

import main.java.model.Staff;

public class AccountantView {

    Staff loggedInAccountant;

    public AccountantView(Staff accountant){
        loggedInAccountant = accountant;
    }

    public void login(){
        System.out.println("successfully logged in as accountant: "+loggedInAccountant.getUserName());
    }
}
