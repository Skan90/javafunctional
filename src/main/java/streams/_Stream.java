package streams;

import java.util.List;

// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.lang.System.*;
import static streams._Stream.Gender.*;


public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Rafael", MALE),
                new Person("Maria", FEMALE),
                new Person("Barbara", FEMALE),
                new Person("Sarah", FEMALE),
                new Person("John", TRANS_MAN),
                new Person("Yuan", NON_BINARY),
                new Person("Aisha", TRANS_WOMAN),
                new Person("Joyce", FEMALE),
                new Person("Jefferson", MALE)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet()) // toSet remove duplicates
                .forEach(out::println);

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet()) // toSet remove duplicates
                .forEach(out::println);

        // Extracting lambdas and reference methods to Functions from util to wrap the knowledge obtained so far

//        IntConsumer println = out::println;
//        ToIntFunction<String> length = String::length;
//        Function<Person, String> personStringFunction = person -> person.name;
//
//        people.stream()
//                .map(personStringFunction)
//                .mapToInt(length)
//                .forEach(println);


//        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
//        boolean containsOnlyFemales = people.stream()
//                .allMatch(personPredicate);
//
//        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
//        boolean containsAnyFemales = people.stream()
//                .anyMatch(personPredicate);

        Predicate<Person> personPredicate = person -> NON_BINARY.equals(person.gender);
        boolean doesNotContainsNonBinary = people.stream()
                .noneMatch(personPredicate);
        out.println(doesNotContainsNonBinary);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, TRANS_MAN, TRANS_WOMAN, NON_BINARY
    }
}
