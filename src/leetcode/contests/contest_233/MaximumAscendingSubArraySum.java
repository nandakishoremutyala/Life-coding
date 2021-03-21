package leetcode.contests.contest_233;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaximumAscendingSubArraySum {
    MaximumAscendingSubArraySum maximumAscendingSubArraySum;

    @BeforeEach
    public void init() {
        maximumAscendingSubArraySum = new MaximumAscendingSubArraySum();
    }

    @Test
    public void firstTest() {
        int res = maximumAscendingSubArraySum.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50});
        Assertions.assertEquals(65, res);
    }

    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int start = 0;
        int end = start;

        while (start<=end && end < nums.length) {
            int temp = nums[start];
            end=start+1;
            while (end<nums.length && nums[start] < nums[end]) {
                temp += nums[end];
                start++;
                end++;
            }

            max=Math.max(temp,max);
            start++;
        }

        return max;
    }
}
