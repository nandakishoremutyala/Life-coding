package leetcode.contests.contest_278;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class KeepMulFoundValuesByTwo {
    KeepMulFoundValuesByTwo keepMulFoundValuesByTwo;
    @BeforeEach
    public void init(){
        keepMulFoundValuesByTwo = new KeepMulFoundValuesByTwo();
    }
    @Test
    public void firstTest(){
        int result= keepMulFoundValuesByTwo.findFinalValue(new int[]{8,19,4,2,15,3},
        2);
        Assertions.assertEquals(16,result);
    }
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        while (set.contains(original)){
            original=original<<1;
        }
        return original;
    }
}
