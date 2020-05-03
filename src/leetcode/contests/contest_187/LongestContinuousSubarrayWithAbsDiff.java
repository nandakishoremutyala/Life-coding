package leetcode.contests.contest_187;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestContinuousSubarrayWithAbsDiff {
    LongestContinuousSubarrayWithAbsDiff lcsad;
    @BeforeEach
    public void init(){
        lcsad=new LongestContinuousSubarrayWithAbsDiff();
    }
    @Test
    public void firstTest(){
        int[] in=new int[]{8,2,4,7};
        int limit=4;
        lcsad.longestSubarray(in,limit);
    }

    public int longestSubarray(int[] nums, int limit) {

        int min=Integer.MAX_VALUE;
        int minPos=-1;
        int max=Integer.MIN_VALUE;
        int p=0;
        int longest=0;
        int start=0;
        while (start<nums.length){
            int cur=nums[start];
            if(cur<min) {
                min=cur;
                minPos=start;
            }
            if(cur>max){
                max=cur;
            }

            if(Math.abs(max-min)<=limit){
                longest=Math.max(longest,(start-p));
                start++;
            }else{
                start=minPos+1;
                p=start;
                max=cur;
            }

        }
        System.out.println(longest);
        return longest;

    }
}
