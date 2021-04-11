package leetcode.contests.contest_236;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WinnerOfCircularGame {
    WinnerOfCircularGame winnerOfCircularGame;
    @BeforeEach
    public void init(){
        winnerOfCircularGame=new WinnerOfCircularGame();
    }
    @Test
    public void firstTest(){
        winnerOfCircularGame.findTheWinner(5,2);
    }

    public int findTheWinner(int n, int k) {
        LinkedList<Integer> circle=new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            circle.addLast(i);
        }
        
        while(circle.size()>1){
            int count=1;
            while(count<=k){
                if(count==k){
                    //int target=circle.getFirst();
                    circle.remove(0);
                }else{
                    int num=circle.getFirst();
                    circle.addLast(num);
                    circle.removeFirst();
                }
                count++;
            }
        }

        return circle.removeFirst();
    }
}
