package jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.CompactNumberFormat;

public class Dbconfig {

   public static Connection getconnetion() {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var username = "postgres";
        var password = "hafiz.127";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




   public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
