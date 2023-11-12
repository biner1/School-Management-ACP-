package main.java.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import main.java.utility.ConnectionStream;
import main.java.views.LoginView;
import main.java.views.AdminViews;


public class Router {

    public static void route() throws IOException {

        Map<String, Map<String, String>> request;
        HashMap<String, Map<String, String>> response = new HashMap<>();

        String json;
        ObjectMapper objectMapper = new ObjectMapper();

        int i = 0;
        Gson g = new Gson();
        String endpoint;
        String method;
        while ((json = ConnectionStream.receive()) != null) {
            System.out.println("this is i: " + ++i + "\n json: " + json);
            request = objectMapper.readValue(json, Map.class);
            method = request.get("header").get("method");
            endpoint = request.get("header").get("resource");

            if (method.equals("GET")) {
                switch (endpoint) {
                    case "getstaffcount" -> AdminViews.getStaffCount();
                    case "allstaff" -> AdminViews.getAllStaffs();
                    case "getstudentcount" -> AdminViews.getStudentCount();
                    case "allstudent" -> AdminViews.getAllStudents();
                    case "studentusername" -> AdminViews.getStudentUsername(request.get("values"));
                    case "getgradecount" -> AdminViews.getGradeCount();
                    case "allgrade" -> AdminViews.getAllGrades();
                    default -> {
                        response.put("header", Map.of("status", "failed"));
                        String jsn = g.toJson(response);
                        ConnectionStream.send(jsn);
                    }

                }// end of switch(endpoint)
            }// end of method.equals("GET")

            else if(method.equals("POST")){
                switch (endpoint) {
                    case "login" -> LoginView.login(request.get("values"));
                    case "staff" -> AdminViews.addStaff(request.get("values"));
                    case "student" -> AdminViews.addStudent(request.get("values"));
                    case "grade" -> AdminViews.addGrade(request.get("values"));
                }
            }// end of method.equals("POST")

            else if (method.equals("DELETE")) {
                switch (endpoint) {
                    case "staff" -> AdminViews.deleteStaff(request.get("values"));
                    case "studentusername" -> AdminViews.deleteStudentUsername(request.get("values"));
                    case "studentid" -> AdminViews.deleteStudentId(request.get("values"));
                    case "grade" -> AdminViews.deleteGrade(request.get("values"));
                }
            }// end of method.equals("delete")

        }// end of while
    } // end of route()

}
