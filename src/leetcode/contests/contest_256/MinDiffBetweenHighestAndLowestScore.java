package leetcode.contests.contest_256;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinDiffBetweenHighestAndLowestScore {
    MinDiffBetweenHighestAndLowestScore minDiffBetweenHighestAndLowestScore;

    @BeforeEach
    public void init() {
        minDiffBetweenHighestAndLowestScore = new MinDiffBetweenHighestAndLowestScore();
    }

    @Test
    public void firstTest() {
        minDiffBetweenHighestAndLowestScore.minimumDifference(new int[]{9, 4, 1, 7}, 2);
    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i+k <= nums.length; i++) {
            min = Math.min(min, (nums[i+k-1] - nums[i]));
        }
        return min;
    }
}
