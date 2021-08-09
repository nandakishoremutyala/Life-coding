package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MinNumberOfRefuelingStops {
    MinNumberOfRefuelingStops minNumberOfRefuelingStops;
    @BeforeEach
    public void init(){
        minNumberOfRefuelingStops=new MinNumberOfRefuelingStops();
    }

    @Test
    public void firstTest(){
        int res= minNumberOfRefuelingStops.minRefuelStops(100,10,new int[][]{
                {10,60},{20,30},{30,30},{60,40}
        });
        System.out.println(res);
    }
    public int minRefuelStops(int target, int startFuel, int[][] st) {
        long[] dp=new long[st.length+1];
        dp[0]=startFuel;
        int N=st.length;
        // dp will store how much we can go with t number of times fueling

        for(int i=0;i<N;++i){
            for(int t=i;t>=0;--t){
                if(dp[t]>=st[i][0]){
                    dp[t+1]=Math.max((dp[t]+(long)st[i][1]),dp[t+1]);
                }
            }
        }

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}
