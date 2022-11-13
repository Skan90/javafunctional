package functionalinterface;

import java.util.List;

// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Supplier.html
import java.util.function.Supplier;

import static java.lang.System.*;

public class _Supplier {

    public static void main(String[] args) {
        out.println(getDBConnectionUrl());
        out.println(getDBConnectionUrlSupplier.get());
        out.println(getListOfDBConnectionUrlsSupplier.get());
    }

    static String getDBConnectionUrl () {
        return "jdbc://localhost:5432/users";
    }
    static Supplier<String> getDBConnectionUrlSupplier = ()
            -> "jdbc://localhost:5432/users";
    static Supplier<List<String>> getListOfDBConnectionUrlsSupplier = ()
            -> List.of("jdbc://localhost:5432/users",
            "jdbc://localhost:5432/customer");
}
