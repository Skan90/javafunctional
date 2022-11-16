package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {
        // Method reference
        // Function<String, String> upperCaseName = String::toUpperCase;

        Function<String, String> upperCaseName = name -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("Jefferson"));

        BiFunction<String, Integer, String> upperCasePersonNameAndGetAge = (name, age) -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCasePersonNameAndGetAge.apply("Joyce", 30));
    }
}
