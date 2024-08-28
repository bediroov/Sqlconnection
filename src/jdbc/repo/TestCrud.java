package jdbc.repo;

import jdbc.model.Student;

public class TestCrud {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

        // Telebe elave etmek
        Student newstudent = new Student();
        newstudent.setName("Amir");
        newstudent.setSurname("Qenberli099");
        newstudent.setAge(25);
        studentRepository.addStudent(newstudent);

//        // reading
        Student student = studentRepository.getStudentbyId(2L);
        System.out.println("Cagrilan Sagird:" + student);


        newstudent.setName("Qedir");
        studentRepository.updateStudent(newstudent);

//         Update olunmus telebeni oxyag
        Student updatedStudent = studentRepository.getStudentbyId(newstudent.getId());
        System.out.println("Güncellenmiş tələbə: " + updatedStudent);


        // Telebe silmek
        studentRepository.deleteStudent(39);


    }


}
