package functionalinterface;
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Consumer.html
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static java.lang.System.*;

public class _Consumer {

    public static void main(String[] args) {

        Customer maria = new Customer("Maria", "13131313");

        out.println("Normal Java function");
        greetCustomer(maria);
        greetCustomerV2(maria, false);


        out.println("Consumer Functional interface");
        greetCustomerConsumer.accept(maria);

        greetCustomerBiConsumerV2.accept(maria, true);
        greetCustomerBiConsumerV2.accept(maria, false);
    }

    // Normal Java
    static void greetCustomer(Customer customer){
        out.println("Hello "
                + customer.customerName
                + ", thanks for registering phone number "
                + customer.customerPhoneNumber
        );
    }
    static void greetCustomerV2(Customer customer, boolean showPhoneNumber){
        out.println("Hello "
                + customer.customerName
                + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "**********")
        );
    }

    // Using Functions
    static Consumer<Customer> greetCustomerConsumer = customer -> out.println("Hello "
            + customer.customerName
            + ", thanks for registering phone number "
            + customer.customerPhoneNumber
    );
    static BiConsumer<Customer, Boolean> greetCustomerBiConsumerV2 =
            (customer, showPhoneNumber) -> out.println("Hello "
            + customer.customerName
            + ", thanks for registering phone number "
            + (showPhoneNumber ? customer.customerPhoneNumber : "**********")
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
