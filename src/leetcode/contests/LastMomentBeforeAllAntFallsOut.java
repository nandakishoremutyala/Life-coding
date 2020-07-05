package leetcode.contests.contest_196;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LastMomentBeforeAllAntFallsOut {
    LastMomentBeforeAllAntFallsOut lmaf;
    @BeforeEach
    public void init(){
        lmaf=new LastMomentBeforeAllAntFallsOut();
    }
    @Test
    public void firstTest(){
        int[] left=new int[]{};
        int[] right=new int[]{};
        int n=4;
        lmaf.getLastMoment(n,left,right);

    }
    @Test
    public void secondTest(){

    }
    @Test
    public void thirdTest(){

    }
    @Test
    public void fourthTest(){
        int[] left=new int[]{5};
        int[] right=new int[]{4};
        int n=9;
        int res= lmaf.getLastMoment(n,left,right);
        System.out.println(res);

    }
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);

        int farLeft=Integer.MIN_VALUE;
        int farRight=Integer.MIN_VALUE;
        if(left.length!=0)
             farLeft=left[left.length-1];

        if(right.length!=0)
            farRight=right[0];

        return Math.max(farLeft,n-farRight);

    }

}
