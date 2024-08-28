package jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.CompactNumberFormat;

public class Dbconfig {

    public static Connection getconnetion() throws SQLException {

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var username = "postgres";
        var password = "hafiz.127";

        return DriverManager.getConnection(url, username, password);


    }

}
