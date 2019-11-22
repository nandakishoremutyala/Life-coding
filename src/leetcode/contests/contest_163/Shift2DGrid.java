package leetcode.contests.contest_163;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public static void main(String[] args) {
        int[][] input=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int k=1;
        Shift2DGrid shift2DGrid=new Shift2DGrid();
        List<List<Integer>> res= shift2DGrid.shiftGrid(input,k);
        MasterPrinter.printList(res);
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(i, new ArrayList<>(m));
        }
        while (k>0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == m - 1 && i == n - 1) {
                        grid[i][j] = grid[0][0];
                        result.get(i).add(j, grid[i][j]);
                    } else if (j == m - 1) {
                        grid[i][j] = grid[i + 1][0];
                        result.get(i).add(j, grid[i][j]);
                    } else {
                        grid[i][j] = grid[i][j + 1];
                        result.get(i).add(j, grid[i][j]);
                    }
                }
            }
            k--;
        }
        return result;
    }
}
