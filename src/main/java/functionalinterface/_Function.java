package functionalinterface;

// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html
import java.util.function.Function;
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/BiFunction.html
import java.util.function.BiFunction;

import static java.lang.System.*;

public class _Function {
    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);

        out.println(addBy1AndThenMultiplyBy10.apply(4));

        // BiFunction takes 2 arguments and produces 1 result
        out.println(incrementByOneAndMultiply(4, 100));

        out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static  Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOne(int number) {
        return number + 1;
    }
    static int incrementByOneAndMultiply (int number, int numberToMultiplyBy) {
        return (number + 1) * numberToMultiplyBy;
    }
}
