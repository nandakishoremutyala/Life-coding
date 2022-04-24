package leetcode;

/**
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
               [0,0,0,0,0,0,0,1,1,1,0,0,0],
               [0,1,1,0,1,0,0,0,0,0,0,0,0],
               [0,1,0,0,1,1,0,0,1,0,1,0,0],
               [0,1,0,0,1,1,0,0,1,1,1,0,0],
               [0,0,0,0,0,0,0,0,0,0,1,0,0],
               [0,0,0,0,0,0,0,1,1,1,0,0,0],
               [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

*/
class Problem_695 {
    int R;
    int C;
    int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
     static int area;
    public int maxAreaOfIsland(int[][] grid) {
        R=grid.length;
        C=grid[0].length;
        int maxArea=0;
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==1){
                    area=0;
                    dfs(i,j,grid);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
      return maxArea;  
    }
    
    private void dfs(int x, int y,int[][] grid){
        grid[x][y]=2;
        area+=1;
        System.out.println(area);
        for(int i=0;i<dirs.length;i++){
            int nx=x+dirs[i][0];
            int ny=y+dirs[i][1];
            //System.out.println(nx+"-"+ny);
            if(isInBoundary(nx,ny) && grid[nx][ny]==1){
                dfs(nx,ny,grid);
            }
        }
    }
    private boolean isInBoundary(int x,int y){
        if(x>=0 && y>=0 && x<R && y<C) 
            return true;
        else 
            return false;
    }
}
