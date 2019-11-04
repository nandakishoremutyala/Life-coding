package leetcode;

import java.util.*;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            sum+=twoSum(nums,i+1, target-nums[i]);
        }
        return sum;
    }

    private int twoSum(int[] nums,int startIndex,int target){
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while(left<right){
            if(nums[left]+nums[right]<target){
                sum+=right-left;
                left++;
            }else{
                right--;
            }
        }
        return sum;
    }
}
