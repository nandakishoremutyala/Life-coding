package prep_2021.epj;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BiggestMinusOneProduct {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(-1);
        list.add(4);
        int result= findBiggestMinusOneProduct(list);
        System.out.println(result);
    }

    public static int findBiggestMinusOneProduct(List<Integer> A) {
        int leastNonNegativeIdx = -1;// negative or zero
        int numberOfNegatives = 0;
        int greatestNegativeIndex = -1;
        int leastNegativeIndex = -1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < 0) {
                numberOfNegatives++;
                if (leastNegativeIndex == -1 ||
                        A.get(leastNegativeIndex) < A.get(i)) {
                    leastNegativeIndex = i;
                }
                if (greatestNegativeIndex == -1 || A.get(greatestNegativeIndex) > A.get(i)) {
                    greatestNegativeIndex = i;
                }

            } else if (A.get(i) >= 0) {
                if (leastNonNegativeIdx == -1 ||
                        A.get(i) < A.get(leastNonNegativeIdx)) {
                    leastNonNegativeIdx = i;
                }
            }
        }

        int indexToSkip = (numberOfNegatives % 2) != 0 ? leastNegativeIndex :
                (leastNonNegativeIdx != -1) ? leastNegativeIndex : greatestNegativeIndex;
        return IntStream.range(0, A.size())
                .filter(i -> i != indexToSkip)
                .reduce(1, (product, i) -> product * A.get(i));
    }

}
