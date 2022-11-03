package main.java.view;

import main.java.model.Staff;

public class TeacherView {

    Staff loggedInTeacher;

    public TeacherView(Staff teacher){
        loggedInTeacher = teacher;
    }

    public void login(){
        System.out.println("successfully logged in as teacher: "+loggedInTeacher.getUserName());
    }
}
