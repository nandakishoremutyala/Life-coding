package leetcode.contests.contest_183;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSubsequenceInNonIncreasingOrder {
    MaximumSubsequenceInNonIncreasingOrder maximumSubsequenceInNonIncreasingOrder;

    @BeforeEach
    public void init() {
        maximumSubsequenceInNonIncreasingOrder = new MaximumSubsequenceInNonIncreasingOrder();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{1, 7, 4, 7, 1, 9, 4, 8, 8};
        maximumSubsequenceInNonIncreasingOrder.minSubsequence(input);

    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        int def = sum % 2;

        int pre = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (def == 0) {
                if (pre >= target) break;
            } else {
                if (pre > target) break;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = i; j < nums.length; j++) {
            result.add(nums[j]);
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
