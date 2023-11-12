package main.java.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.sql.ResultSetMetaData;

public class Utility {

    public static List<Map<String, String>> ResultSetToMap(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, String>> list = new ArrayList<>();

        String value;
        while (rs.next()) {
            Map<String, String> row = new HashMap<>(columns);

            for (int i = 1; i <= columns; ++i) {
                if (rs.getString(i) != null) {
                    value = rs.getString(i);
                } else {
                    value = rs.getInt(i) + "";
                }
                row.put(md.getColumnName(i), value);
            }
            list.add(row);
        }
        return list;
    }// end of ResultSetToMap()


//    public static List<Map<String, String>> studentResultSetToMap(ResultSet rs) throws SQLException {
//        ResultSetMetaData md = rs.getMetaData();
//        int columns = md.getColumnCount();
//        List<Map<String, String>> list = new ArrayList<>();
//        String value;
//        while (rs.next()) {
//            Map<String, String> row = new HashMap<>(columns);
//
//            for (int i = 1; i <= columns; ++i) {
//                if (rs.getString(i) != null) {
//                    value = rs.getString(i);
//                } else {
//                    value = rs.getInt(i) + "";
//                }
//                row.put(md.getColumnName(i), value);
//            }
//            list.add(row);
//        }
//        return list;
//    }// end of studentResultSetToMap()

}
