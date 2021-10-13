package leetcode.contests.contest_262;

import java.util.Arrays;

public class UniValueGrid {
    public static void main(String[] args) {
        UniValueGrid uniValueGrid=new UniValueGrid();
        int result= uniValueGrid.minOperations(new int[][]{{146}},86);
        System.out.println(result);
    }
    public int minOperations(int[][] grid, int x) {
        if(grid.length==1 && grid[0].length==1)return 0;
        int min=findMin(grid);
        int max=findMax(grid);
        int minimum=Integer.MAX_VALUE;
        while (min<max){
            int left= waysToMakeUnique(min,grid,x);
            int right=waysToMakeUnique(max,grid,x);
            minimum=Math.min(Math.min(left,right),minimum);
            int mid=min+(max-min)/2;
            if(left<=right){
                max=mid;
            }else{
                min=max+1;
            }
        }
        if(minimum==Integer.MAX_VALUE)return -1;
        return minimum;
    }

    private int waysToMakeUnique(int target, int[][] grid, int x) {
        int total=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val=grid[i][j];
                if((target-val)%x!=0)
                    return Integer.MAX_VALUE;
                else
                    total+=(Math.abs(target-val))/x;
            }
        }
        return total;
    }

    private int findMax(int[][] grid) {
        int max=Integer.MIN_VALUE;
        for(int[] x:grid){
            max=Math.max(max, Arrays.stream(x).min().getAsInt());
        }
        return max;
    }

    private int findMin(int[][] grid) {
        int min=Integer.MAX_VALUE;
        for(int[] x:grid){
            min=Math.min(min, Arrays.stream(x).min().getAsInt());
        }
        return min;
    }
}
