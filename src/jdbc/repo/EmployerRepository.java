package jdbc.repo;

import jdbc.config.Dbconfig;
import jdbc.model.Employer;

import javax.security.auth.callback.CallbackHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

public class EmployerRepository {

    private Employer CachedEmployer;   // kasdaki employer obyekdidir
    private LocalDateTime LastTime;


    public Employer getEmployerMaxSalary() {


        if (CachedEmployer != null && LastTime != null) {

            Duration duration = Duration.between(LastTime, LocalDateTime.now());

            if (duration.toMinutes() < 1) {
                System.out.println("Melumat cachdan geeldi");
                return CachedEmployer;
            }
        }


        String query = "Select * from employer order by salary desc limit 1";

        try (var connection = Dbconfig.getconnetion();
             var preparestatement = connection.prepareStatement(query);
             ResultSet resultSet = preparestatement.executeQuery();
        ) {

            while (resultSet.next()) {

                Employer employer = Employer.builder().id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .salary(resultSet.getInt(3)).build();

//
                CachedEmployer = employer;
                LastTime = LocalDateTime.now();
                System.out.println("Melumat Databasedn geldi");

                return employer;

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
