package leetcode.contests.contest_285;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HillsAndValleyInArray {
    HillsAndValleyInArray hillsAndValleyInArray;
    @BeforeEach
    public void init(){
        hillsAndValleyInArray=new HillsAndValleyInArray();
    }
    @Test
    public void firstTest(){
        hillsAndValleyInArray.countHillValley(new int[]{6,6,5,5,4,1});
    }
    public int countHillValley(int[] nums) {
        int count=0;
        if(nums.length<3) return count;
        for (int i = 1; i <nums.length-1 ; i++) {
            int left=i;
            int right=i;

            if(nums[i]==nums[i-1]) continue;
            while(left>=0 && right<nums.length && (nums[i]==nums[left] || nums[i]==nums[right])){

                if(left>=0 && nums[i]==nums[left]){
                    left--;
                }
                if(right<nums.length && nums[i]==nums[right]){
                    right++;
                }
            }
            if(left>=0 && right<nums.length && (nums[left]>nums[i] && nums[right]>nums[i])){
                // vallley
                count++;

            }
            if(left>=0 && right<nums.length && (nums[left]<nums[i] && nums[right]<nums[i])){
                // hills
                count++;

            }

        }
        System.out.println(count);
        return count;
    }
}
