package leetcode.contests.contest_181;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ValidPathInGrid {
    ValidPathInGrid validPathInGrid;

    @BeforeEach
    public void init() {
        validPathInGrid = new ValidPathInGrid();
    }

    @Test
    public void firstTest() {
        int[][] grid = new int[][]{
                {1, 2, 1},
                {1, 2, 1}
        };
        boolean result = validPathInGrid.hasValidPath(grid);
        Assertions.assertEquals(result, false);
    }

    @Test
    public void secondTest() {
        int[][] grid = new int[][]{
                {2, 4, 3},
                {6, 5, 2}
        };
        boolean result = validPathInGrid.hasValidPath(grid);
        Assertions.assertEquals(result, true);
    }

    public boolean hasValidPath(int[][] grid) {
        Map<Integer, int[][]> rules = new HashMap<>();
        int[][] pro1 = new int[][]{{0, -1}, {0, 1}};
        rules.put(1, pro1);

        int[][] pro2 = new int[][]{{-1, 0}, {1, 0}};
        rules.put(2, pro2);

        int[][] pro3 = new int[][]{{0, -1}, {1, 0}};
        rules.put(3, pro3);

        int[][] pro4 = new int[][]{{0, 1}, {1, 0}};
        rules.put(4, pro4);

        int[][] pro5 = new int[][]{{0, -1}, {-1, 0}};
        rules.put(5, pro5);

        int[][] pro6 = new int[][]{{0, 1}, {-1, 0}};
        rules.put(6, pro6);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int tr = grid.length-1;
        int tc = grid[0].length-1;
        boolean result = pathExist(rules, grid, queue, tr, tc) ;
        return result;
    }

    private boolean pathExist(Map<Integer, int[][]> rules, int[][] grid, Queue<int[]> queue, int tr, int tc) {
        boolean[][] visited =new boolean[grid.length][grid[0].length];
        boolean pathEsixt =false;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            System.out.println(r+"-"+c);
            if (r == tr && c == tc)
                pathEsixt=true;

            if(!visited[r][c]){
                int[][] next = rules.get(grid[r][c]);
                if (next != null) {
                    for (int i = 0; i < 2; i++) {
                        int[] ruleMove = next[i];
                        int[] move = new int[]{r + ruleMove[0], c + ruleMove[1]};
                        if (validMove(grid, move) && !visited[move[0]][move[1]]){
                            queue.add(move);
                        }
                    }

                }
            }
            visited[cell[0]][cell[1]]=true;
        }
        return pathEsixt;
    }

    private boolean validMove(int[][] grid, int[] move) {
        int R = grid.length;
        int C = grid[0].length;

        int r = move[0];
        int c = move[1];
        if (r < R && r >= 0 && c < C && c >= 0) return true;
        return false;
    }
}
