package leetcode.contests.contest_193;

import org.junit.jupiter.api.BeforeEach;

public class RunningSumOfArray {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i <nums.length ; i++) {
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;
    }
}
