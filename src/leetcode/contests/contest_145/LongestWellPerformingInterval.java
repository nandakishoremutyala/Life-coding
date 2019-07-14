package leetcode.contests.contest_145;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestWellPerformingInterval {
    LongestWellPerformingInterval mLongestWellPerformingInterval;
    @BeforeEach
    public void init(){
        mLongestWellPerformingInterval=new LongestWellPerformingInterval();
    }

    @Test
    public void firstTest(){
        int[] hours=new int[]{9,9,6,1,6,6,9};
        int result= mLongestWellPerformingInterval.longestWPI(hours);
        Assertions.assertEquals(3,result);
    }

    @Test
    public void secondTest(){
        int[] hours=new int[]{6,6,9};
        int result= mLongestWellPerformingInterval.longestWPI(hours);
        Assertions.assertEquals(1,result);
    }

    @Test
    public void thirdTest(){
        int[] hours=new int[]{6,6,6};
        int result= mLongestWellPerformingInterval.longestWPI(hours);
        Assertions.assertEquals(0,result);
    }
    public int longestWPI(int[] hours) {
        int[][] traker=new int[hours.length][2];
        if(hours[0]>8){
            traker[0]=new int[]{1,0};
        }else{
            traker[0]=new int[]{0,1};
        }

        for (int i=1;i<hours.length;i++){
            int pos=traker[i-1][0];
            int neg=traker[i-1][1];
            if(hours[i]>8){
                traker[i]=new int[]{pos+1,neg};
            }else{
                traker[i]=new int[]{pos,neg+1};
            }
        }

        System.out.println(traker);

        int start=0;
        int max=0;
        for (int i=0;i<traker.length;i++){
            if(traker[i][0]>traker[i][1]){
                start=i;
                while (i<traker.length && traker[i][0]>traker[i][1] ){
                    i++;
                }
                max=Math.max(max,i-start+1);
            }

        }
        return max;
    }

}
