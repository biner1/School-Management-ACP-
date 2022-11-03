package main.java.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import main.java.model.TimeTable;

public class TimeTableList {

    public ArrayList<TimeTable> timeTables;



    public TimeTableList(){
        timeTables = new ArrayList<TimeTable>();

        Map<String,String> map = Map.of("english","8:00", "math","9:00", "Arabic","10:00","art","11:00","science","12:00","kurdish","01:00");
        timeTables.add(new TimeTable(1,map));
        Map<String,String> map1 = Map.of("english","8:00", "math","9:00", "Arabic","10:00","art","11:00","science","12:00","kurdish","01:00");
        timeTables.add(new TimeTable(2,map1));
        Map<String,String> map2 = Map.of("Arabic","8:00", "kurdish","9:00", "english","10:00","math","11:00","science","12:00","sport","01:00");
        timeTables.add(new TimeTable(3,map2));
        Map<String,String> map3 = Map.of("Arabic","8:00", "kurdish","9:00", "english","10:00","math","11:00","science","12:00","sport","01:00");
        timeTables.add(new TimeTable(4,map3));
        Map<String,String> map4 = Map.of("math","8:00", "english","9:00", "kurdish","10:00","Arabic","11:00","science","12:00","art","01:00");
        timeTables.add(new TimeTable(5,map4));
    }

    public void addTimeTable(TimeTable timeTable){
        readFromFile();
        timeTables.add(timeTable);
        saveToFile();
    }

    public ArrayList<TimeTable> getTimeTableList(){
        readFromFile();
        return timeTables;
    }

    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/datafile/timetables.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(timeTables);
            oos.close();
        }
        catch (IOException e){
            System.out.println("file output error");
        }
    }

    public void readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("src/main/java/datafile/timetables.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            timeTables = (ArrayList<TimeTable>) ois.readObject();
            ois.close();
        }catch (IOException e){
            System.out.println("error with reading file");
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
    }

}