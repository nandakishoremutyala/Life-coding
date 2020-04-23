package practice.mordern_java_recipes.streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LazyStream {
    public static void main(String[] args) {
        /** Streams are lazy. code below seems waste like
         1. why generating all the numbers
         2. multiply by two
         3 then verify the division

         Streams are lazy, it would not process until a terminal condition found and
         then process element by element
         */
        OptionalInt result = IntStream.range(100, 200)
                .map(num -> num * 2)
                .filter(num -> num % 3 == 0)
                .findFirst();
        System.out.println(result);
    }
}
