import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class LoginView {

    public void login(ObjectOutputStream out, ObjectInputStream in) throws IOException {
        final HashMap<String, HashMap<String,String>> yourMap=new HashMap<String, HashMap<String,String>>();
        // login as who
        System.out.println("______________Login view__________________");
//        mapOutputStream.writeObject(yourMap);
        String username;
        String password;

        yourMap.put("request",new HashMap<String, String>() {{
                put("resource", "login");
            }});
        final HashMap<String,String> values=new HashMap<String,String>();
        values.put("password","password");
        values.put("username","admin");
        yourMap.put("values",values);
        System.out.println(yourMap.get("request").get("resource"));
        out.writeObject(yourMap);


        //Staff staff = null;
//        while (true) {
//            System.out.println("Enter UserName");
//            System.out.println("@r#");
//            username = in.readLine();
//            System.out.println("Enter Password");
//            System.out.println("@r#");
//            password = in.readLine();
//            yourMap.put("request",new HashMap<String, String>() {{
//                put("resource", "login");
//            }};);
//
//
//            ResultSet staff = LoginController.checkLogin(username,password);
//
//            HashMap<String,String> s =new HashMap<>();
//            if (staff != null) {
//                String role = staff.getString("role");
//                s.put("username",username);
//                s.put("role",role);
//
//                switch (role) {
//                    case "ADMIN" -> {
//                        AdminView admin = new AdminView(s);
//                        admin.login(out,in);
//                    }
//                    case "TEACHER" -> {
//                        TeacherView teacher = new TeacherView(s);
//                        teacher.login(out,in);
//                    }
//                    case "ACCOUNTANT" -> {
//                        AccountantView accountant = new AccountantView(s);
//                        accountant.login(out,in);
//                    }
//                } // end of switch
//            } else {
//                System.out.println("wrong user name or password");
//            }
//            staff =null;
//        }
    }// end of login()


}
