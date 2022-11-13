package optionals;

import java.util.Optional;
import java.util.function.Supplier;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "Default value");

        Object valueIfNotNullSupplier = Optional.ofNullable("Some value here")
                .orElseGet(() -> "Default value");
        
        Optional.ofNullable("rafael@email.com")
                .ifPresentOrElse(
                        email -> out.println("Sending e-mail to "  + email),
                        () -> out.println("Cannot send e-mail"));

//        Supplier<IllegalStateException> exeption = () -> new IllegalStateException("Exeption");
//        Object valueExeption = Optional.ofNullable(null)
//                .orElseThrow(exeption);


        out.println(value);
        out.println(valueIfNotNullSupplier);
    }
}
