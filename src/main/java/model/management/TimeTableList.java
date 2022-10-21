package main.java.model.management;

import main.java.model.models.TimeTable;

import java.util.ArrayList;
import java.util.Map;

public class TimeTableList {

    public static ArrayList<TimeTable> timeTables;



    public TimeTableList(){
        timeTables = new ArrayList<TimeTable>();

        Map<String,String> map = Map.of("math","8:00", "english","9:00", "kurdish","10:00","Arabic","11:00","science","12:00","art","01:00");
       timeTables.add(new TimeTable(1,map));
        Map<String,String> map1 = Map.of("math","8:00", "english","9:00", "kurdish","10:00","Arabic","11:00","science","12:00","art","01:00");
        timeTables.add(new TimeTable(2,map1));
        Map<String,String> map2 = Map.of("math","8:00", "english","9:00", "kurdish","10:00","Arabic","11:00","science","12:00","art","01:00");
        timeTables.add(new TimeTable(3,map2));
        Map<String,String> map3 = Map.of("math","8:00", "english","9:00", "kurdish","10:00","Arabic","11:00","science","12:00","art","01:00");
        timeTables.add(new TimeTable(4,map3));
        Map<String,String> map4 = Map.of("math","8:00", "english","9:00", "kurdish","10:00","Arabic","11:00","science","12:00","art","01:00");
        timeTables.add(new TimeTable(5,map4));
    }

    public void addTimeTable(TimeTable timeTable){
        timeTables.add(timeTable);
    }

}
