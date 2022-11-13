package imperative;
// Documentation for Java util:
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/package-summary.html
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Rafael", MALE),
            new Person("Maria", FEMALE),
            new Person("Barbara", FEMALE),
            new Person("Sarah", FEMALE),
            new Person("Joyce", FEMALE),
            new Person("Jefferson", MALE)
        );

        out.println("// Imperative approach");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            out.println(female);
        }

        out.println("\n// Declarative approach");

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .toList();
//                .collect(Collectors.toList());
//                .forEach(out::println);
        females2.forEach(out::println);
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
        MALE, FEMALE
    }
}
