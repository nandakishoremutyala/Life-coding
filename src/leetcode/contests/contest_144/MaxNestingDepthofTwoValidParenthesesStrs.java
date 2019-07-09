package leetcode.contests.contest_144;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxNestingDepthofTwoValidParenthesesStrs {
    MaxNestingDepthofTwoValidParenthesesStrs mMaxNestingDepthofTwoValidParenthesesStrs;

    @BeforeEach
    public void init() {
        mMaxNestingDepthofTwoValidParenthesesStrs = new MaxNestingDepthofTwoValidParenthesesStrs();
    }

    @Test
    public void firstTest() {
        String input = "(()())";
        int[] result = mMaxNestingDepthofTwoValidParenthesesStrs.maxDepthAfterSplit(input);
        Assertions.assertArrayEquals(new int[]{1, 0, 1, 1, 1, 0}, result);
    }

    public int[] maxDepthAfterSplit(String seq) {
        int A = 0, B = 0, n = seq.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            if (seq.charAt(i) == '(') {
                if (A < B) {
                    ++A;
                } else {
                    ++B;
                    res[i] = 1;
                }
            } else {
                if (A > B) {
                    --A;
                } else {
                    --B;
                    res[i] = 1;
                }
            }
        }
        return res;
    }

}
