package functionalinterface;
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Predicate.html
import java.util.function.Predicate;

import static java.lang.System.*;

public class _Predicate {

    public static void main(String[] args) {
        out.println("Without Predicate");
        out.println(isPhoneNumberValid("0130000000"));
        out.println(isPhoneNumberValid("0110000000"));
        out.println(isPhoneNumberValid("013000000011"));

        out.println("\nWith Predicate");
        out.println(isPhoneNumberValidPredicate.test("0130000000"));
        out.println(isPhoneNumberValidPredicate.test("0530000000"));
        out.println(isPhoneNumberValidPredicate.test("013000000022"));
        out.println("\nChained Predicates with AND");
        out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("0130000000"));
        out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("0530000000"));
        out.println("\nChained Predicates with OR");
        out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("013000000022"));

    }

    // Normal Java
    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("013") && phoneNumber.length() == 10;
    }

    // Predicate Function interface

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("013") && phoneNumber.length() == 10;

    static  Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
