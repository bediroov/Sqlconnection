package task.repo;

import jdbc.config.Dbconfig;
import task.model.Student;

import java.sql.*;

public class StudentRepository {

    public void addStudent(Student student) {

        String query = "Insert into student (name,surname,age) values (?,?,?)";

        try (Connection connection = Dbconfig.getconnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getAge());

            preparedStatement.execute();

            try (var generatedkeys = preparedStatement.getGeneratedKeys()) {
                if (generatedkeys.next()) {
                    student.setId(generatedkeys.getLong(1));
                    System.out.println("Yeni elave olunan telebebn id-si budur: " + student.getId());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public Student getStudentbyId(Long id) {
        String query = "Select * from student where id=?";

        Student student = null;
        try (Connection connection = Dbconfig.getconnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {

            student = new Student();
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }


    public void updateStudent(Student student) {

        String query = "Update student set name = ?,surname = ?,age = ? where id = ?";

        try (Connection connection = Dbconfig.getconnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, student.getId());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteStudent(Integer id) {

        String query = "Delete from student where id = ?";

        try (Connection connection = Dbconfig.getconnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
