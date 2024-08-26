package jdbc;

import java.sql.*;

public class Connectiontestdb {


    public static void main(String[] args) {

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var username = "postgres";
        var password = "hafiz.127";


        try(var connection = DriverManager.getConnection(url,username,password);
           var preparedStatement = connection.prepareStatement("SELECT type from contact");
            var resultSet = preparedStatement.executeQuery();
        ) {

            while (resultSet.next()){
                String name = resultSet.getString("type");
                System.out.println(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




//
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             Statement statement = connection.createStatement();
//             ResultSet resultSet= statement.executeQuery("SELECT name from test.bose")
//             ) {
//
//
//            while (resultSet.next()){
//                String name = resultSet.getString("name");
//                System.out.println(name);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
}
