package leetcode.contests.contest_276;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinimumMovesToReachTarget {
    MinimumMovesToReachTarget minimumMovesToReachTarget;
    @BeforeEach
    public void init(){
        minimumMovesToReachTarget = new MinimumMovesToReachTarget();
    }
    @Test
    public void firstTest(){
        int res= minimumMovesToReachTarget.minMoves(10,4);
        System.out.println(res);
    }

    @Test
    public void secondTest(){
        int res= minimumMovesToReachTarget.minMoves(19,2);
        System.out.println(res);
    }
    public int minMoves(int target, int maxDoubles) {
        int jump=0;
        while (target>1){
            if(target%2!=0){
                jump+=1;
                target-=1;
            }
            else if(maxDoubles>0){
                jump+=1;
                target=target/2;
                maxDoubles-=1;
            }else if(maxDoubles==0){
                jump+=target-1;
                target=1;
            }
        }
        return jump;

    }
}
