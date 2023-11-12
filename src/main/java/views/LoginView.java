package main.java.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import main.java.dbController.LoginController;
import main.java.utility.ConnectionStream;


public class LoginView {

    public static void login(Map<String, String> values) {

        HashMap<String, Map<String, String>> response = new HashMap<>();
        Gson g = new Gson();
        String username, password;

        username = values.get("username");
        password = values.get("password");

        try (ResultSet staff = LoginController.checkLogin(username, password)) {

            if (staff != null) {
                String role = staff.getString("role");
                values = Map.of("username", username, "role", role);
                response.put("header", Map.of("status", "success"));
                response.put("values", values);
                String jsn = g.toJson(response);
                ConnectionStream.send(jsn);
            }
            else {
                response.put("header", Map.of("status", "failed"));
                String jsn = g.toJson(response);
                ConnectionStream.send(jsn);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    } // end of login()

}
