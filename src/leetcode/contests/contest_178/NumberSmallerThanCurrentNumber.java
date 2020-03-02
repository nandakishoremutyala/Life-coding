package leetcode.contests.contest_178;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.TreeMap;

public class NumberSmallerThanCurrentNumber {
    NumberSmallerThanCurrentNumber numberSmallerThanCurrentNumber;
    @BeforeEach
    public void init(){
        numberSmallerThanCurrentNumber=new NumberSmallerThanCurrentNumber();
    }
    @Test
    public void firstTest(){
        int[] expected=new int[]{4,0,1,1,3};
        int[] input=new int[]{8,1,2,2,3};
        int[] result= numberSmallerThanCurrentNumber.smallerNumbersThanCurrent(input);
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void secondTest(){
        int[] expected=new int[]{2,1,0,3};
        int[] input=new int[]{6,5,4,8};
        int[] result= numberSmallerThanCurrentNumber.smallerNumbersThanCurrent(input);
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void thirdTest(){
        int[] expected=new int[]{0,0,0,0};
        int[] input=new int[]{7,7,7,7};
        int[] result= numberSmallerThanCurrentNumber.smallerNumbersThanCurrent(input);
        Assertions.assertArrayEquals(expected,result);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        TreeMap<Integer,Integer> count=new TreeMap<>();
        for(int i:nums){
            count.compute(i,(k,v)->v==null?1:v+1);
        }
        System.out.println(count);

        int[] smaller=new int[101];

        for (int i = 0; i <=100 ; i++) {
            if(i==0)
                smaller[i]=0;
            else if(i==1){
                smaller[i]=smaller[i-1]+(count.get(i-1)==null?0:count.get(i-1));
            }else{
                smaller[i]=smaller[i-1]+(count.get(i-1)==null?0:count.get(i-1));
            }
        }

        int[] result=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            result[i]=smaller[num];
        }
        return result;
    }
}
