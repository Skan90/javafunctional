package finalsection;

import java.util.function.Consumer;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        hello("Rafael", null, value -> {
            out.println("No lastName provided for " + value);
        });

        hello2("Rafael",
                null,
                () -> out.println("No lastName provided.")
        );
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        out.println(firstName);
        if (lastName != null) {
            out.println(lastName);
        } else {
            callback.accept((firstName));
        }

    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        out.println(firstName);
        if (lastName != null) {
            out.println(lastName);
        } else {
            callback.run();
        }

    }

    // Function in JavaScript

//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName);
//        } else {
//            callback();
//        }
//    }
//
//    hello("Rafael", null, function() {console.log("No lastName provided");})
}
