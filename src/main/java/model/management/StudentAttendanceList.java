package main.java.model.management;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.model.models.StudentAttendance;

public class StudentAttendanceList {

    private ArrayList<StudentAttendance> studentAttendances;

    public  StudentAttendanceList(){
        studentAttendances = new ArrayList<StudentAttendance>();

        studentAttendances.add(new StudentAttendance(1,1,"20-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(2,1,"10-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(3,1,"1-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(4,1,"5-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(5,2,"7-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(6,2,"4-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(7,2,"14-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(8,2,"19-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(9,3,"5-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(10,3,"9-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(11,3,"11-10-2022","absent"));
        studentAttendances.add(new StudentAttendance(12,3,"16-10-2022","absent"));

    }

    public void addStudentAttendance(StudentAttendance studentAttendance){
        studentAttendances.add(studentAttendance );
    }

    public ArrayList<StudentAttendance> getStudentAttendance(){
        return studentAttendances;
    }

    public ArrayList<StudentAttendance> getStudentAttendanceByStaffId(int id){
        return studentAttendances.stream().filter(g -> g.getStudentId() ==id).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<StudentAttendance> getStudentAttendanceByDate(String date){
        return studentAttendances.stream().filter(g -> Objects.equals(g.getDate(), date)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<StudentAttendance> getStudentAttendanceByStatus(String status){
        return studentAttendances.stream().filter(g -> Objects.equals(g.getStatus(), status)).collect(Collectors.toCollection(ArrayList::new));
    }
}
