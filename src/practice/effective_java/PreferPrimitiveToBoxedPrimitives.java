package practice.effective_java;

import java.util.Comparator;

public class PreferPrimitiveToBoxedPrimitives {
    public static void main(String[] args) {
        int result = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result);

        int resultCorrection = naturalOrderCorrect.compare(new Integer(42), new Integer(42));
        System.out.println(resultCorrection);
    }

    /**
     * It has flaw. Never use '==' comparator for boxed primitives
     */
    static Comparator<Integer> naturalOrder = (first, second) -> first < second ? -1 : (first == second ? 0 : 1);

    static Comparator<Integer> naturalOrderCorrect = (first, second) -> {
        int a = first.intValue();
        int b = second.intValue();
        return a < b ? -1 : (a == b ? 0 : 1);
    };
}
