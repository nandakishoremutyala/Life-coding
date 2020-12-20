package leetcode.contests.contest_220;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MaximumEraseValue {

    MaximumEraseValue maximumEraseValue;

    @BeforeEach
    public void init() {
        maximumEraseValue = new MaximumEraseValue();
    }

    @Test
    public void firstTest() {
        int[] nums=new int[]{4,2,4,5,6};
        int res= maximumEraseValue.maximumUniqueSubarray(nums);
        System.out.println(res);
    }

    @Test
    public void secondTest() {
        int[] nums=new int[]{5,2,1,2,5,2,1,2,5};
        int res= maximumEraseValue.maximumUniqueSubarray(nums);
        System.out.println(res);
    }
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer,Integer> numToPositionMap=new HashMap<>();
        int start=0;
        int end=0;
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            if(numToPositionMap.containsKey(num) && numToPositionMap.get(num)>=start){
                int pos=numToPositionMap.get(num);
                numToPositionMap.put(num,i);
                int sum=findSum(start,i-1,nums);
                start=pos+1;
                result=Math.max(sum,result);
            }else {
                numToPositionMap.put(num,i);
            }
        }

        int finalS=findSum(start,nums.length-1,nums);
        return Math.max(result,finalS);
    }

    private int findSum(int start, int end, int[] nums) {
        int sum=0;
        for (int i = start; i <=end ; i++) {
            sum+=nums[i];
        }
        return sum;
    }
}
