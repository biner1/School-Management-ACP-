package main.java.model.management;

import java.util.ArrayList;

import main.java.model.models.Subject;

public class SubjectList {

    private ArrayList<Subject> subjects;

        public SubjectList(){
        subjects = new ArrayList<Subject>();

        subjects.add(new Subject(1,"ACP",3));
        subjects.add(new Subject(2,"OOP",3));
        subjects.add(new Subject(3,"DataBase",3));
        subjects.add(new Subject(4,"OS",3));
        subjects.add(new Subject(5,"English",1));
        subjects.add(new Subject(6,"Network",1));
        subjects.add(new Subject(7,"Web",1));
        subjects.add(new Subject(8,"Mobile",2));
        subjects.add(new Subject(9,"Software",2));
        subjects.add(new Subject(10,"Computer Arch",2));
        subjects.add(new Subject(11,"AI",4));
        subjects.add(new Subject(12,"security",4));
    }

    public void addSubject(Subject subject){
            subjects.add(subject);
        }

    public ArrayList<Subject> getSubjects(){
        return subjects;
    }
}
