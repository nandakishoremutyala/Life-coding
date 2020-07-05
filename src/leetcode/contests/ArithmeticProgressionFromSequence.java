package leetcode.contests.contest_196;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArithmeticProgressionFromSequence {
    ArithmeticProgressionFromSequence aps;
    @BeforeEach
    public void init(){
        aps=new ArithmeticProgressionFromSequence();
    }
    @Test
    public void firstTest(){

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff=arr[1]-arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]-arr[i-1]!=diff){
                return false;
            }
        }

        return true;
    }

}
