package leetcode.contests.contest_187;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsDiff {
    LongestContinuousSubarrayWithAbsDiff lcsad;

    @BeforeEach
    public void init() {
        lcsad = new LongestContinuousSubarrayWithAbsDiff();
    }

    @Test
    public void firstTest() {
        int[] in = new int[]{8, 2, 4, 7};
        int limit = 4;
        lcsad.longestSubarray(in, limit);
    }

    public int longestSubarray(int[] nums, int limit) {
        int start = 0;
        int end = 0;
        int res = 1;

        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Comparator.reverseOrder());

        while (start<=end && end<nums.length){
            min.add(nums[end]);
            max.add(nums[end]);

            int minNum=min.peek();
            int maxNum=max.peek();

            if(Math.abs(maxNum-minNum)<=limit){
                end++;
                res=Math.max(res,end-start);
            }else{
                min.remove(nums[start]);
                max.remove(nums[start]);
                end++;
                start++;
            }
        }
        return res;
    }
}
