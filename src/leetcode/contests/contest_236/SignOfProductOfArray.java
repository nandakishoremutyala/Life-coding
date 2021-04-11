package leetcode.contests.contest_236;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SignOfProductOfArray {
    SignOfProductOfArray signOfProductOfArray;
    @BeforeEach
    public void init(){
        signOfProductOfArray=new SignOfProductOfArray();
    }
    @Test
    public void firstTest(){
        int res= signOfProductOfArray.arraySign(new int[]{-1,-2,-3,-4,3,2,1});
        Assertions.assertEquals(1,res);
    }
    public int arraySign(int[] nums) {
        int negNumber=0;
        for(int x:nums){
            if(x<0)
                negNumber++;
            if(x==0)
                return 0;
        }
        if(negNumber%2==0)return 1;
        return -1;
    }
}
