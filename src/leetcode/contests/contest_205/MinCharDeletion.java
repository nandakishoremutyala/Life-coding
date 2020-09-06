package leetcode.contests.contest_205;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinCharDeletion {
    MinCharDeletion minCharDeletion;

    @BeforeEach
    public void init() {
        minCharDeletion = new MinCharDeletion();
    }

    @Test
    public void firstTest() {
        int res = minCharDeletion.minCost("abaac", new int[]{1, 2, 3, 4, 5});
        System.out.println(res);
        Assertions.assertEquals(3, res);
    }

    @Test
    public void secondTest() {
        int res = minCharDeletion.minCost("abc", new int[]{1, 2, 3});
        System.out.println(res);
        Assertions.assertEquals(0, res);
    }

    @Test
    public void thirdTest() {
        int res = minCharDeletion.minCost("aabaa", new int[]{1, 2, 3, 4, 1});
        System.out.println(res);
        Assertions.assertEquals(2, res);
    }

    public int minCost(String s, int[] cost) {
        if (cost.length != s.length()) return 0;
        int gSum = 0, maxSum = 0, n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                ans += gSum - maxSum;
                gSum = 0;
                maxSum = 0;
            }
            gSum += cost[i];
            maxSum = Math.max(maxSum, cost[i]);
        }
        ans += gSum - maxSum;

        return ans;
    }
}
