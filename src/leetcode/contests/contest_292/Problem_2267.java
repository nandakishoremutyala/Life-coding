package leetcode.contests.contest_292;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class Problem_2267 {
     int R;
     int C;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}};
    boolean found = false;

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

    public boolean hasValidPath(char[][] grid) {
        R = grid.length;
        C = grid[0].length;
        StringBuilder sb = new StringBuilder();
        dfs(grid, sb, 0, 0);
        return found;
    }

    private void dfs(char[][] grid, StringBuilder sb, int r, int c) {
        if (found) return;
        if (r == R - 1 && c == C - 1) {
            sb.append(grid[r][c]);
            if (isItValid(sb)) {
                found = true;
                System.out.println("valid: " + sb.toString());
            }
            return;
        }
        sb.append(grid[r][c]);
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (isInBoundary(nr, nc)) {
                dfs(grid, sb, nr, nc);
                if (sb.length() >= 1)
                    sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private boolean isItValid(StringBuilder sb) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (char c : sb.toString().toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.poll();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isInBoundary(int r, int c) {
        return (r >= 0 && r < R && c >= 0 && c < C);
    }
}
