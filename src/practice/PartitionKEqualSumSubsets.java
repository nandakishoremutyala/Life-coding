package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class PartitionKEqualSumSubsets {
    PartitionKEqualSumSubsets partitionKEqualSumSubsets;

    @BeforeEach
    public void init() {
        partitionKEqualSumSubsets = new PartitionKEqualSumSubsets();
    }

    @Test
    public void firstTest() {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        Assertions.assertEquals(true,partitionKEqualSumSubsets.canPartitionKSubsets(nums, k));
    }
    int n;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        if (n < k) return false;
        int total=Arrays.stream(nums).sum();
        if (total % k != 0) return false; // Cannot be divided by k, then return false
        int sum = total / k; // The sum of every single subarray
        boolean[] visited = new boolean[n];
        return dfs(nums, 0, visited, k, sum, sum);
    }

    private boolean dfs(int[] nums, int start, boolean[] visited, int k, int rem, int sum) {
        if (rem < 0) return false;
        if (rem == 0) {
            --k;
            rem = sum;
            start = 0;// why start from the beginning, because you did not visit all the numbers yet
        } // Restart from index 0
        if (k == 0) return true;
        for (int i = start; i < n; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            if (dfs(nums, i, visited, k, rem - nums[i], sum)) return true;
            visited[i] = false;// backtrack here
        }
        return false;
    }
}

