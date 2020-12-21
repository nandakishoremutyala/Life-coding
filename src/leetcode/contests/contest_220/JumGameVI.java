package leetcode.contests.contest_220;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class JumGameVI {
    JumGameVI jumGameVI;

    @BeforeEach
    public void init() {
        jumGameVI = new JumGameVI();
    }

    @Test
    public void firstTest() {
        int[] nums = new int[]{1, -1, -2, 4, -7, 3};
        int k = 2;
        int result = jumGameVI.maxResult(nums, k);
        System.out.println(result);
    }

    @Test
    public void secondTest() {
        int[] nums = new int[]{10, -5, -2, 4, 0, 3};
        int k = 3;
        int result = jumGameVI.maxResult(nums, k);
        System.out.println(result);
    }

    @Test
    public void thirdTest() {
        int[] nums = new int[]{1, -5, -20, 4, -1, 3, -6, -3};
        int k = 2;
        int result = jumGameVI.maxResult(nums, k);
        System.out.println(result);
    }

    public int maxResult(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((int[] arr1, int[] arr2) -> arr2[0] - arr1[0]);
        maxHeap.add(new int[]{nums[0], 0});

        for (int i = 1; i < nums.length; i++) {
            // if any number is big and out of the boundary,
            // we have to remove it
            while (!maxHeap.isEmpty() &&
                    maxHeap.peek()[1] < i - k) {
                maxHeap.remove();
            }
            // next big element would be our target for that position
            System.out.println(maxHeap.peek()[0]);
            dp[i] = nums[i] + maxHeap.peek()[0];
            maxHeap.add(new int[]{dp[i], i});
        }
        return dp[nums.length - 1];
    }
}
