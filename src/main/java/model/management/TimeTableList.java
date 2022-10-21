package main.java.model.management;

import main.java.model.models.TimeTable;

import java.util.ArrayList;

public class TimeTableList {

    public static ArrayList<TimeTable> timeTables;

    public TimeTableList(){
        timeTables = new ArrayList<TimeTable>();
    }

    public void addTimeTable(TimeTable timeTable){
        timeTables.add(timeTable);
    }

}
