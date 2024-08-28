package example.procedure;

import jdbc.config.Dbconfig;

import java.sql.*;

public class CustomerRepository {
    Customer ReadCustomerbyid(Integer id) {

        Customer customer = null;
        String query = "SELECT * from customers where id=?";


        try (var connection = Dbconfig.getconnetion();
             var preparedStatement = connection.prepareStatement(query)) {

            customer = new Customer();
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setAge(resultSet.getInt("age"));
                customer.setRegistrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime());
                customer.setGroupCustomer(resultSet.getInt("group_customer"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }


}
