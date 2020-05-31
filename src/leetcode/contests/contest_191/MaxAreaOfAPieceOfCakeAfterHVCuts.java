package leetcode.contests.contest_191;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MaxAreaOfAPieceOfCakeAfterHVCuts {
    MaxAreaOfAPieceOfCakeAfterHVCuts maxAreaOfAPieceOfCakeAfterHVCuts;
    @BeforeEach
    public void init(){
        maxAreaOfAPieceOfCakeAfterHVCuts=new MaxAreaOfAPieceOfCakeAfterHVCuts();
    }
    @Test
    public void firstTest(){
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxH = findCandidate(horizontalCuts,h);
        int maxV = findCandidate(verticalCuts,w);
        int M = 1000000007;
        return (maxH*maxV)%M;
    }

    private int findCandidate(int[] cuts, int maxVal) {
        int len=cuts.length;
        if(len==1){
            int val=Math.max(Math.abs(-cuts[0]),Math.abs(cuts[0]-maxVal));
            return val;
        }

        Arrays.sort(cuts);
        int maxDiff=0;
        for (int i = 1; i <len ; i++) {
           maxDiff= Math.max((cuts[i]-cuts[i-1]),maxDiff);
        }
        maxDiff=Math.max(maxDiff,(cuts[0]));
        maxDiff=Math.max(maxDiff,(maxVal-cuts[len]));
        return maxDiff;
    }
}

