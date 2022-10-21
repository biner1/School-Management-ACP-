package main.java.model.management;

import main.java.model.models.Subject;

import java.util.ArrayList;

public class SubjectList {

    public ArrayList<Subject> subjects;

    public SubjectList(){
        subjects = new ArrayList<Subject>();

    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

}
