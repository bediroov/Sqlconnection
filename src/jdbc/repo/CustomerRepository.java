package jdbc.repo;

import jdbc.config.Dbconfig;
import jdbc.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerRepository {

    Customer getCustomerbyid(Integer id) {

        Customer customer = null;
        Connection connection = Dbconfig.getconnetion();

        String query = "Select * from customers where id = ?";

        try (var preparestatement = connection.prepareStatement(query);
        ) {
            preparestatement.setInt(1,id);
            var resultSet = preparestatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer();

                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setAge(resultSet.getInt("age"));
                customer.setRegistrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime());
                customer.setGroupCustomer(resultSet.getInt("group_customer"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }





}
