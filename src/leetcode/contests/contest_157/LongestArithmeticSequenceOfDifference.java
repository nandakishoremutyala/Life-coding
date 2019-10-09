package leetcode.contests.contest_157;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestArithmeticSequenceOfDifference {
    LongestArithmeticSequenceOfDifference longestArithmeticSequenceOfDifference;

    @BeforeEach
    public void init() {
        longestArithmeticSequenceOfDifference = new LongestArithmeticSequenceOfDifference();
    }

    @Test
    public void firstTest() {
        int result = longestArithmeticSequenceOfDifference.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2);
        Assertions.assertEquals(4,result);
    }

    @Test
    public void secondTest() {
        int result = longestArithmeticSequenceOfDifference.longestSubsequence(new int[]{1, 2, 3, 4}, 1);
        Assertions.assertEquals(4,result);
    }

    @Test
    public void thirdTest() {
        int result = longestArithmeticSequenceOfDifference.longestSubsequence(new int[]{1, 3, 5, 7}, 1);
        Assertions.assertEquals(1,result);
    }

    @Test
    public void fourthTest() {
        int result = longestArithmeticSequenceOfDifference.longestSubsequence(new int[]{3,0,-3,4,-4,7,6}, 3);
        Assertions.assertEquals(2,result);
    }

    public int longestSubsequence(int[] arr, int difference) {
        // a[i]-a[j]=difference
        // a[i]-difference=a[j]
        Map<Integer,Integer> map=new HashMap<>();
        int max = 1;
        for (int i = 0; i <arr.length ; i++) {
            int target=arr[i]-difference;
            if(map.containsKey(target))
                map.put(arr[i],map.get(target)+1);
            else{
                map.put(arr[i],1);
            }
            max=Math.max(max,map.get(arr[i]));
        }
        return max;
    }
}
