package leetcode.contests.contest_138;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrumpyBookstoreOwner {
    GrumpyBookstoreOwner grumpyBookstoreOwner;

    @BeforeEach
    public void init() {
        grumpyBookstoreOwner = new GrumpyBookstoreOwner();
    }

    @Test
    public void simpleFirstTest() {
        int maxSatifiedCustomers = grumpyBookstoreOwner.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
        Assertions.assertEquals(16, maxSatifiedCustomers);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int start = 0;
        int end = start + X;
        int[] consecutiveMin = findMaxConsecutiveMintoSatisfyCustomers(start, customers, grumpy, X);
        System.out.println(consecutiveMin[0] + "," + consecutiveMin[1] + "customer: " + consecutiveMin[2]);


        int firstStart = 0;
        int firstEnd = consecutiveMin[0];

        int cust = consecutiveMin[2];
        for (int i = firstStart; i < firstEnd; i++) {
            if (grumpy[i] == 1)
                cust += customers[i];
        }

        int secondStart = consecutiveMin[1];
        int secondEnd = customers.length;
        if (secondStart < secondEnd) {
            for (int i = secondStart; i < secondEnd; i++) {
                if (grumpy[i] == 1)
                    cust += customers[i];
            }
        }

        return cust;
    }

    private int[] findMaxConsecutiveMintoSatisfyCustomers(int start, int[] customers, int[] grumpy, int X) {
        int max = 0;
        int tempStart = start;
        for (int i = start; i < customers.length - X + 1; i++) {
            int tempMax = 0;

            for (int j = i; j < i + X; j++) {
                tempMax += customers[j];
            }
            if (tempMax > max) {
                max = tempMax;
                tempStart = i;
            }


        }
        return new int[]{tempStart, tempStart + X - 1, max};
    }
}
