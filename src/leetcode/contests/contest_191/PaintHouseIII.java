package leetcode.contests.contest_191;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaintHouseIII {
    PaintHouseIII paintHouseIII;

    /**
     *
     * 1   10 -> if you paint with color 1, cost is 1. if you paint with color 2 cost is 10
     * 10  1
     * 10  1
     * 1   10
     * 5   1
     *
     * */

    @BeforeEach
    public void init() {
        paintHouseIII = new PaintHouseIII();
    }
    @Test
    public void firstTest(){
        int[] houses=new int[]{0,0,0,0,0};
        int[][] cost =new int[][]{{1,10},{10,1},{1,10},{1,10},{5,1}};
        minCost(houses,cost,5,2,3);
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        return dfs(houses,cost,n,target,m,0,0,0);

    }

    private int dfs(int[] houses, int[][] cost, int nColor, int target, int nHouses, int minCost,int group, int curr) {
        if(group>target) return Integer.MAX_VALUE;

        if(curr==nHouses)
            return minCost;

        for (int i = 1; i <=nColor ; i++) {
            if(houses[curr]==0){
                // color it
                houses[curr]=i;
                minCost+=cost[curr][i-1];
                if(curr!=0 && houses[curr-1]==i){
                    int g=group;
                    dfs(houses,cost,nColor,target,nHouses,minCost,g,curr+1);
                }else{
                    int g=group+1;
                    dfs(houses,cost,nColor,target,nHouses,minCost,g,curr+1);
                }
            }else{
                if(curr!=0 && houses[curr-1]==i){
                    int g=group;
                    dfs(houses,cost,nColor,target,nHouses,minCost,g,curr+1);
                }else{
                    int g=group+1;
                    dfs(houses,cost,nColor,target,nHouses,minCost,g,curr+1);
                }
            }
        }
        System.out.println(minCost);
        return minCost;
    }

}
