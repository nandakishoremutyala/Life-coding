package leetcode.contests.contest_158;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SplitStringInABalancedString {
    SplitStringInABalancedString splitStringInABalancedString;

    @BeforeEach
    public void init() {
        splitStringInABalancedString = new SplitStringInABalancedString();
    }

    @Test
    public void firstTest() {
        String s = "RLRRLLRLRL";
        int result = splitStringInABalancedString.balancedStringSplit(s);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void secondTest() {
        String s = "RLLLLRRRLR";
        int result = splitStringInABalancedString.balancedStringSplit(s);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void thirdTest() {
        String s = "LLLLRRRR";
        int result = splitStringInABalancedString.balancedStringSplit(s);
        Assertions.assertEquals(1, result);
    }

    public int balancedStringSplit(String s) {
        int nR = 0;
        int nL = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L')
                nL++;
            else
                nR++;

            if (nL == nR) {
                count++;
                nL = 0;
                nR = 0;
            }
        }
        return count;
    }
}
