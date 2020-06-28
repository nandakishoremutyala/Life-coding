package leetcode.contests.contest_195;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PairsDivisibleByK {
    PairsDivisibleByK pairsDivisibleByK;
    @BeforeEach
    public void init(){
        pairsDivisibleByK=new PairsDivisibleByK();
    }
    @Test
    public void firstTest(){
        boolean res =pairsDivisibleByK.canArrange(new int[]{1,2,3,4,5,10,6,7,8,9},5);
    }
    public boolean canArrange(int[] arr, int k) {

        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            sum=sum%k;
        }

        if(sum==0) return true;
        return false;
    }
}
