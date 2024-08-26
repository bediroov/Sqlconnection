package jdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;



@Data
//@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private int id;
    private String name;
    private String surname;
    private int age;
    private LocalDateTime registrationDate;
    private int groupCustomer;


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public LocalDateTime getRegistrationDate() {
//        return registrationDate;
//    }
//
//    public void setRegistrationDate(LocalDateTime registrationDate) {
//        this.registrationDate = registrationDate;
//    }
//
//    public int getGroupCustomer() {
//        return groupCustomer;
//    }
//
//    public void setGroupCustomer(int groupCustomer) {
//        this.groupCustomer = groupCustomer;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", age=" + age +
//                ", registrationDate=" + registrationDate +
//                ", groupCustomer=" + groupCustomer +
//                '}';
//    }

}
