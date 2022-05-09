package leetcode.contests.contest_292;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class Problem_2267 {
    int R;
    int C;
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'(', '(', '('},
                {')', '(', ')'},
                {'(', '(', ')'},
                {'(', '(', ')'}
        };

        Problem_2267 p = new Problem_2267();
        boolean result = p.hasValidPath(grid);
        System.out.println(result);
    }

    boolean[][][] visited = new boolean[100][100][101];

    public boolean hasValidPath(char[][] grid) {
        R = grid.length;
        C = grid[0].length;
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int bal) {
        bal += grid[r][c] == '(' ? 1 : -1;
        if (bal < 0 || bal > ((R + C) / 2) || visited[r][c][bal])
            return false;

        visited[r][c][bal] = true;
        if (r == R - 1 && c == C - 1 && bal == 0)
            return true;
        if (r < R - 1 && dfs(grid, r + 1, c, bal))
            return true;
        if (c < C - 1 && dfs(grid, r, c + 1, bal))
            return true;

        return false;

    }

}
