package functionalinterface;
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Consumer.html
import java.util.function.Consumer;

import static java.lang.System.*;

public class _Consumer {

    public static void main(String[] args) {

        Customer maria = new Customer("Maria", "13131313");

        // Normal Java function
        greetCustomer(maria);

        // Consumer Functional interface
        greetCustomerConsumer.accept(maria);
    }

    static void greetCustomer(Customer customer){
        out.println("Hello "
                + customer.customerName
                + ", thanks for registering phone number "
                + customer.customerPhoneNumber
        );
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> out.println("Hello "
            + customer.customerName
            + ", thanks for registering phone number "
            + customer.customerPhoneNumber
    );
    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
