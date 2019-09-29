package leetcode.contests.contest_156;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EqualSubstringWithinBudget {
    EqualSubstringWithinBudget equalSubstringWithinBudget;

    @BeforeEach
    public void init() {
        equalSubstringWithinBudget = new EqualSubstringWithinBudget();
    }

    @Test
    public void firstTest() {
        String str1 = "abcd";
        String str2 = "bcdf";
        int maxCost = 3;
        int result = equalSubstringWithinBudget.equalSubstring(str1, str2, maxCost);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void secondTest() {
        String str1 = "abcd";
        String str2 = "cdef";
        int maxCost = 3;
        int result = equalSubstringWithinBudget.equalSubstring(str1, str2, maxCost);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void thirdTest() {
        String str1 = "abcd";
        String str2 = "acde";
        int maxCost = 0;
        int result = equalSubstringWithinBudget.equalSubstring(str1, str2, maxCost);
        Assertions.assertEquals(1, result);
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(), i = 0, j;
        for (j = 0; j < n; ++j) {
            maxCost -= Math.abs(s.charAt(j) - t.charAt(j));
            if (maxCost < 0) {
                maxCost += Math.abs(s.charAt(i) - t.charAt(i));
                ++i;
            }
        }
        return j - i;
    }
}
