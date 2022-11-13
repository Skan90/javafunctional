package functionalinterface;

// https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html

import java.util.function.Function;

import static java.lang.System.*;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);

        out.println(addBy1AndThenMultiplyBy10.apply(4));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static  Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }
}
