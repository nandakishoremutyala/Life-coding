package leetcode.contests.contest_236;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.Arrays;

public class MinimumSideWayJump {
    MinimumSideWayJump minimumSideWayJump;
    @BeforeEach
    public void init(){
        minimumSideWayJump=new MinimumSideWayJump();
    }
    @Test
    public void firstTest(){
        int res=minimumSideWayJump.minSideJumps(new int[]{0,2,1,0,3,0});
        System.out.println(res);
    }

    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[]{1, 0, 1};
        for (int a: obstacles) {
            if (a > 0) //if there is an obstacle put inf into that location
                dp[a - 1] = 1000000;
            for (int i = 0; i < 3; ++i)
                if (a != i + 1)
                    dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
