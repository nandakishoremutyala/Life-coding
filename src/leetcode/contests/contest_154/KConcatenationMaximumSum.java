package leetcode.contests.contest_154;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KConcatenationMaximumSum {
    private KConcatenationMaximumSum kConcatenationMaximumSum;
    public static int mod = (int)(Math.pow(10, 9) + 7);
    @BeforeEach
    public void init() {
        kConcatenationMaximumSum = new KConcatenationMaximumSum();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{1, -2, 1};
        int k = 5;
        int output = kConcatenationMaximumSum.kConcatenationMaxSum(input, k);
        Assertions.assertEquals(2, output);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{-1, -2};
        int k = 7;
        int output = kConcatenationMaximumSum.kConcatenationMaxSum(input, k);
        Assertions.assertEquals(0, output);
    }

    @Test
    public void thirdTest() {
        int[] input = new int[]{1, 2};
        int k = 3;
        int output = kConcatenationMaximumSum.kConcatenationMaxSum(input, k);
        Assertions.assertEquals(9, output);
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        int[] newArr = new int[arr.length * k];
        int currPos = 0;
        while (k != 0) {
            for (int i = 0; i < arr.length; i++) {
                newArr[currPos] = arr[i];
                currPos++;
            }
            k--;
        }
        return findMaxSubarraySum(newArr);
    }

    private int findMaxSubarraySum(int[] newArr) {
        int max_so_far = 0;
        int start = 0;
        int end = 0;
        int max_end = 0;
        while (start <= end && end < newArr.length) {
            max_end = max_end + newArr[end];
            if (max_end > max_so_far)
                max_so_far = max_end;
            else if (max_end < 0) {
                start = end;
                max_end = 0;
            }
            end++;
        }
        return max_so_far%1000000007;
    }
}
