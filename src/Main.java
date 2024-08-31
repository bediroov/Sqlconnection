import jdbc.model.Employer;
import jdbc.repo.EmployerRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmployerRepository employerRepository = new EmployerRepository();

        Employer employer1 = employerRepository.getEmployerMaxSalary();
        System.out.println(employer1);



    }
}