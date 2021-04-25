package leetcode.contests.contest_238;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MostFrequentElement {
    @Test
    public void firstTest(){
        maxFrequency(new int[]{1,2,4},5);
    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max=0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = findMax(nums, k, i);
            System.out.println(temp);
            max=Math.max(temp,max);
        }
        return max;
    }

    private int findMax(int[] nums, int k, int start) {
        int max = nums[start];
        int upperBound = start;
        int repetition = 0;
        while (start >= 0 && k >= 0 && nums[start]+k>=max) {
            k -= (max - nums[start]);
            start--;
        }
        return upperBound - start;
    }
}
