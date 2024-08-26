package jdbc.repo;

import jdbc.model.Customer;

public class TestCrud {


    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();

        Customer customerbyid = customerRepository.getCustomerbyid(24);
        System.out.println(customerbyid);


    }


}
