package main.java.views;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import main.java.dbController.GradeController;
import main.java.dbController.StaffController;
import main.java.dbController.StudentController;
import main.java.model.Grade;
import main.java.utility.ConnectionStream;
import main.java.model.Staff;
import main.java.model.Student;
import main.java.model.StaffRole;
import main.java.utility.Utility;


public class AdminViews {

    private static final Gson gson = new Gson();


    // staff related requests
    public static void getAllStaffs() {
        HashMap<String, Map<String, String>> response = new HashMap<>();
        ResultSet staffsRs = StaffController.getStaffs();
        if (staffsRs == null) {
            response.put("header", Map.of("status", "success", "message", "No staffs found"));
            String jsn = gson.toJson(response);
            ConnectionStream.send(jsn);
            return;
        }

        try {
            List<Map<String, String>> staffsMap = Utility.ResultSetToMap(staffsRs);
            String staffList = gson.toJson(staffsMap);
            System.out.println("staffList: " + staffList);
            response.put("header", Map.of("status", "success", "message", "List of staffs"));
            response.put("values", Map.of("staffs", staffList));
            System.out.println(response);
        } catch (Exception e) {
            response.put("header", Map.of("status", "failed"));
        } finally {
            String jsn = gson.toJson(response);
            ConnectionStream.send(jsn);
        }

    }

    public static void getStaffCount() {
        HashMap<String, Map<String, String>> response = new HashMap<>();

        Map<String, String> values = Map.of("count", StaffController.getStaffCount() + "");
        response.put("header", Map.of("status", "success"));
        response.put("values", values);
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);
    }

    public static void addStaff(Map<String, String> values) {
        HashMap<String, Map<String, String>> response = new HashMap<>();
        StaffRole role;
        role = StaffRole.valueOf(values.get("role").toUpperCase());
        Staff staff = new Staff(1, values.get("username"), values.get("gender"),
                values.get("date"), values.get("email"), values.get("address"), values.get("phone"),
                role, Integer.parseInt(values.get("salary")), values.get("password"));

        int added = StaffController.addStaff(staff);
        if (added == 0) {
            response.put("values", Map.of("count", "0"));
        } else {
            response.put("values", Map.of("count", added + ""));
        }
        response.put("header", Map.of("status", "success"));
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);
    }

    public static void deleteStaff(Map<String, String> values) {
        HashMap<String, Map<String, String>> response = new HashMap<>();

        String username = values.get("username");
        int deleted = StaffController.deleteStaffUsername(username);
        if (deleted == 0) {
            response.put("header", Map.of("status", "success", "message", "No staff deleted"));

        } else {
            response.put("header", Map.of("status", "success", "message", "Staff " + username + " deleted"));
        }
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);

    }

    // student related requests

    public static void addStudent(Map<String, String> values) {
        HashMap<String, Map<String, String>> response = new HashMap<>();
        int gradeId = Integer.parseInt(values.get("gradeId"));
        Student student = new Student(1, values.get("username"), values.get("gender"),
                values.get("date"), values.get("email"), values.get("address"),
                values.get("phone"), gradeId, values.get("password"));

        int added = StudentController.addStudent(student);
        if (added == 0) {
            response.put("values", Map.of("count", "0"));
        } else {
            response.put("values", Map.of("count", added + ""));
        }
        response.put("header", Map.of("status", "success"));
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);

    }

    public static void getAllStudents() {
        HashMap<String, Map<String, String>> response = new HashMap<>();
        ResultSet studentsRs = StudentController.getStudents();
        if (studentsRs == null) {
            response.put("header", Map.of("status", "success", "message", "No students found"));
            String jsn = gson.toJson(response);
            ConnectionStream.send(jsn);
            return;
        }

        try {
            List<Map<String, String>> studentsMap = Utility.ResultSetToMap(studentsRs);
            String studentList = gson.toJson(studentsMap);
            System.out.println("studentList: " + studentList);
            response.put("header", Map.of("status", "success", "message", "List of students"));
            response.put("values", Map.of("students", studentList));
            System.out.println(response);
        } catch (Exception e) {
            response.put("header", Map.of("status", "failed"));
        } finally {
            String jsn = gson.toJson(response);
            ConnectionStream.send(jsn);
        }
    }// end of getAllStudents()

    public static void getStudentCount() {
        HashMap<String, Map<String, String>> response = new HashMap<>();

        Map<String, String> values = Map.of("count", StudentController.getStudentCount() + "");
        response.put("header", Map.of("status", "success"));
        response.put("values", values);
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);
    }// end of getStudentCount()

    public static void deleteStudentUsername(Map<String, String> values) {
        HashMap<String, Map<String, String>> response = new HashMap<>();

        String username = values.get("username");
        int deleted = StudentController.deleteStudentUsername(username);
        if (deleted == 0) {
            response.put("header", Map.of("status", "success", "message", "No student deleted"));

        } else {
            response.put("header", Map.of("status", "success", "message", "Student " + username + " deleted"));
        }
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);

    }// end of deleteStudentUsername()

    public static void deleteStudentId(Map<String, String> values) {
        HashMap<String, Map<String, String>> response = new HashMap<>();

        int id = Integer.parseInt(values.get("id"));
        int deleted = StudentController.deleteStudentId(id);
        if (deleted == 0) {
            response.put("header", Map.of("status", "success", "message", "No student deleted"));

        } else {
            response.put("header", Map.of("status", "success", "message", "Student ID: " + id + " deleted"));
        }
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);
    }// end of deleteStudentId()

    public static void getStudentUsername(Map<String, String> values) {
        HashMap<String, Map<String, String>> response = new HashMap<>();
        String username = values.get("username");
        ResultSet studentRs = StudentController.getStudentUsername(username);
        if (studentRs == null) {
            response.put("header", Map.of("status", "success", "message", "No student found with username: " + username));
            String jsn = gson.toJson(response);
            ConnectionStream.send(jsn);
            return;
        }

        try {
            List<Map<String, String>> studentMap = Utility.ResultSetToMap(studentRs);
            String studentList = gson.toJson(studentMap);
            System.out.println("studentList: " + studentList);
            response.put("header", Map.of("status", "success", "message", "student with username: " + username));
            response.put("values", Map.of("students", studentList));
            System.out.println(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("header", Map.of("status", "failed"));
        } finally {
            String jsn = gson.toJson(response);
            ConnectionStream.send(jsn);
        }
    }// end of getStudentUsername()

    // grade related requests

    public static void addGrade(Map<String, String> values) {
        HashMap<String, Map<String, String>> response = new HashMap<>();
         Grade grade = new Grade(1, values.get("gradeName"), Integer.parseInt(values.get("gradeYear")));
        int added = GradeController.addGrade(grade);
        if (added == 0) {
            response.put("values", Map.of("count", "0"));
        } else {
            response.put("values", Map.of("count", added + ""));
        }
        response.put("header", Map.of("status", "success"));
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);
    }// end of addGrade()

    public static void getGradeCount() {
        HashMap<String, Map<String, String>> response = new HashMap<>();

        Map<String, String> values = Map.of("count", GradeController.getGradeCount() + "");
        response.put("header", Map.of("status", "success"));
        response.put("values", values);
        String jsn = gson.toJson(response);
        ConnectionStream.send(jsn);
    }// end of getGradeCount()

    public static void getAllGrades() {
        HashMap<String, Map<String, String>> response = new HashMap<>();
        ResultSet gradesRs = GradeController.getGrades();
        if (gradesRs == null) {
            response.put("header", Map.of("status", "success", "message", "No grades found"));
            String jsn = gson.toJson(response);
            ConnectionStream.send(jsn);
            return;
        }

        try {
            List<Map<String, String>> gradesMap = Utility.ResultSetToMap(gradesRs);
            String gradeList = gson.toJson(gradesMap);
            System.out.println("gradeList: " + gradeList);
            response.put("header", Map.of("status", "success", "message", "List of grades"));
            response.put("values", Map.of("grades", gradeList));
            System.out.println(response);
        } catch (Exception e) {
            response.put("header", Map.of("status", "failed"));
        } finally {
            String jsn = gson.toJson(response);
            ConnectionStream.send(jsn);
        }
    }// end of getAllGrades()

    public static void deleteGrade(Map<String, String> values) {
        HashMap<String, Map<String, String>> response = new HashMap<>();
        System.out.println("values: " + values);

        String gradeName = values.get("gradeName");
        int gradeYear = Integer.parseInt(values.get("gradeYear"));
        int deleted = GradeController.deleteGrade(gradeName, gradeYear);
        if (deleted == 0) {
            response.put("header", Map.of("status", "success", "message", "No grade deleted"));
        } else {
            response.put("header", Map.of("status", "success", "message", "Grade Name: " + gradeName + " deleted"));
        }
        String jsn = gson.toJson(response);
        System.out.println(jsn +"this is jsn");
        ConnectionStream.send(jsn);
    }// end of deleteGrade()
}
