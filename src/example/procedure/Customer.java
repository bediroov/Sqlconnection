    package example.procedure;

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



    }
