package leetcode.contests.contest_191;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.Arrays;

public class MaxProductOfTwoElementsInArray {
    MaxProductOfTwoElementsInArray maxProductOfTwoElementsInArray;
    @BeforeEach
    public void init(){
        maxProductOfTwoElementsInArray=new MaxProductOfTwoElementsInArray();
    }
    @Test
    public void firstTest(){
        int[] arr=new int[]{1,5,4,5};
        int res=maxProductOfTwoElementsInArray.maxProduct(arr);
        Assertions.assertEquals(16,res);
    }
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}
