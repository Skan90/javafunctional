package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Maria",
                "maria@email.com",
                "+0139999999",
                LocalDate.of(2011, 1, 1)
        );
//        Intellij In Line Shortcut -> Ctrl + Alt + N
//        CustomerValidatorService validatorService = new CustomerValidatorService();
//
//        validatorService.isValid(customer);
//

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // If valid we can store customer in DB

        // Using combinator patter to handle exceptions

        // Lazy code, it will only run after '.apply()' is called

        ValidationResult result = isEmailValid()
                .and(isPhoneValid())
                .and(isAnAdult())
                .apply(customer);

        out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
