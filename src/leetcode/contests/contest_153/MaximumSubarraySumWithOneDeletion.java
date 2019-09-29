package leetcode.contests.contest_153;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaximumSubarraySumWithOneDeletion {
    MaximumSubarraySumWithOneDeletion maximumSubarraySumWithOneDeletion;

    @BeforeEach
    public void init() {
        maximumSubarraySumWithOneDeletion = new MaximumSubarraySumWithOneDeletion();
    }

    @Test
    public void firstTest() {
        int[] arr = new int[]{1, -2, 0, 3};
        Assertions.assertEquals(4, maximumSubarraySumWithOneDeletion.maximumSum(arr));
    }
    @Test
    public void secondTest() {
        int[] arr = new int[]{1,-2,-2,3};
        Assertions.assertEquals(3, maximumSubarraySumWithOneDeletion.maximumSum(arr));
    }
    @Test
    public void thirdTest() {
        int[] arr = new int[]{-1, -1, -1, -1};
        Assertions.assertEquals(-1, maximumSubarraySumWithOneDeletion.maximumSum(arr));
    }

    public int maximumSum(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int swd = 0;                // sum with deletion
        int swnd = arr[0];      // sum with non deletion
        int ans = arr[0];        // required answer
        for(int i = 1 ; i < arr.length ; i++){
            swd = Math.max(swd + arr[i] , swnd);
            swnd = Math.max(swnd + arr[i] , arr[i]);
            ans = Math.max(ans , Math.max(swd , swnd));
        }return ans;
    }
}
