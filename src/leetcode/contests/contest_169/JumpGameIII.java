package leetcode.contests.contest_169;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JumpGameIII {
    JumpGameIII jumpGame;
    static boolean result;

    @BeforeEach
    public void init() {
        jumpGame = new JumpGameIII();
    }

    @Test
    public void firstTest(){
        int[] input=new int[]{4,2,3,0,3,1,2};
        int start=5;
        boolean result= jumpGame.canReach(input,start);
        Assertions.assertEquals(true,result);
    }

    @Test
    public void secondTest(){
        int[] input=new int[]{4,2,3,0,3,1,2};
        int start=0;
        boolean result= jumpGame.canReach(input,start);
        Assertions.assertEquals(true,result);
    }

    @Test
    public void thirdTest(){
        int[] input=new int[]{3,0,2,1,2};
        int start=2;
        boolean result= jumpGame.canReach(input,start);
        Assertions.assertEquals(false,result);
    }
    public boolean canReach(int[] arr, int start) {
        boolean[] visited=new boolean[arr.length];
        helper(visited,arr,start);
        return result;
    }

    private void helper(boolean[] visited, int[] arr, int pos) {
        if(pos<0||pos>=arr.length)return;
        if(result) return;
        if(arr[pos]==0){
            System.out.println("Found");
            result=true;
        }
        if(visited[pos])return;
        visited[pos]=true;
        helper(visited,arr,pos-arr[pos]);
        helper(visited,arr,pos+arr[pos]);
    }
}
