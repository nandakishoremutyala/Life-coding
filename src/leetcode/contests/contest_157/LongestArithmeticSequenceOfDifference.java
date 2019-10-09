package leetcode.contests.contest_157;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestArithmeticSequenceOfDifference {
    LongestArithmeticSequenceOfDifference longestArithmeticSequenceOfDifference;

    @BeforeEach
    public void init() {
        longestArithmeticSequenceOfDifference = new LongestArithmeticSequenceOfDifference();
    }

    @Test
    public void firstTest() {
        int result = longestArithmeticSequenceOfDifference.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2);
        Assertions.assertEquals(4,result);
    }

    @Test
    public void secondTest() {
        int result = longestArithmeticSequenceOfDifference.longestSubsequence(new int[]{1, 2, 3, 4}, 1);
        Assertions.assertEquals(4,result);
    }

    @Test
    public void thirdTest() {
        int result = longestArithmeticSequenceOfDifference.longestSubsequence(new int[]{1, 3, 5, 7}, 1);
        Assertions.assertEquals(1,result);
    }

    @Test
    public void fourthTest() {
        int result = longestArithmeticSequenceOfDifference.longestSubsequence(new int[]{3,0,-3,4,-4,7,6}, 3);
        Assertions.assertEquals(2,result);
    }

    public int longestSubsequence(int[] arr, int difference) {
        int[] ones = new int[arr.length];
        Arrays.fill(ones, 1);

        int max = 1;
        for (int j = 1; j < arr.length; j++) {
            int temp = j - 1;
            while (temp >= 0) {
                if (arr[j]-arr[temp]==difference) {
                    ones[j] = Math.max(ones[temp] + 1, ones[j]);
                    break;
                }
                temp--;
            }
            max = Math.max(ones[j], max);
        }
        System.out.println(max);
        return max;
    }
}
