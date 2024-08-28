package example.procedure;

import jdbc.config.Dbconfig;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CustomerProcedur {

    public static void createGetCustomerByIdProcedure() {
        String procedure = """
                CREATE OR REPLACE PROCEDURE get_customer_by_id(
                    IN p_id INT,
                    OUT p_name VARCHAR,
                    OUT p_surname VARCHAR,
                    OUT p_age INT,
                    OUT p_registration_date TIMESTAMP,
                    OUT p_group_customer INT)
                AS $$
                BEGIN
                    SELECT name, surname, age, registration_date, group_customer
                    INTO p_name, p_surname, p_age, p_registration_date, p_group_customer
                    FROM customers
                    WHERE id = p_id;
                END;
                $$ LANGUAGE plpgsql;
                """;

        try (Connection connection = Dbconfig.getconnetion();
             Statement statement = connection.createStatement()) {

            statement.execute(procedure);
            System.out.println("Procedure 'get_customer_by_id' created successfully.");

        } catch (SQLException e) {
            throw new RuntimeException("Failed to create procedure: " + e.getMessage(), e);
        }
    }
}
