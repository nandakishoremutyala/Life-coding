package leetcode.contests.contest_156;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMoveToReachTargetWithRotation {
    MinMoveToReachTargetWithRotation minMoveToReachTargetWithRotation;
    static int val = Integer.MAX_VALUE;

    int[][] minMatrix;

    enum Direction {
        RIGHT,
        DOWN
    }

    class SnakeMove {
        int row;
        int col;
        Direction direction;
        int val;

        SnakeMove(int row, int col, Direction direction, int val) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.val = val;
        }
    }

    @BeforeEach
    public void init() {
        minMoveToReachTargetWithRotation = new MinMoveToReachTargetWithRotation();
    }

    @Test
    public void firstTest() {
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0}
        };
        int result = minMoveToReachTargetWithRotation.minimumMoves(grid);
        Assertions.assertEquals(11, result);
    }

    @Test
    public void secondTest() {
        int[][] grid = new int[][]{
                {0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 0}
        };
        int result = minMoveToReachTargetWithRotation.minimumMoves(grid);
        Assertions.assertEquals(9, result);
    }

    public int minimumMoves(int[][] grid) {
        minMatrix = new int[grid.length][grid[0].length];
        for (int i = 0; i < minMatrix.length; i++) {
            for (int j = 0; j < minMatrix[0].length; j++) {
                minMatrix[i][j] = 9;
            }
        }
        //minMatrix[0][1] = 0;
        SnakeMove s = new SnakeMove(0, 1, Direction.RIGHT, -1);
        Queue<SnakeMove> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            SnakeMove sm = queue.poll();
            minMatrix[sm.row][sm.col] = Math.min(sm.val + 1,
                    minMatrix[sm.row][sm.col]);

            if(sm.row==5 && sm.col==5)
                System.out.println("ping pong"+minMatrix[5][5]);
            if (isValidMove(grid, sm.row, sm.col + 1))
                queue.add(new SnakeMove(sm.row, sm.col + 1, Direction.RIGHT, minMatrix[sm.row][sm.col]));

            if (isValidMove(grid, sm.row + 1, sm.col))
                queue.add(new SnakeMove(sm.row + 1, sm.col, Direction.DOWN, minMatrix[sm.row][sm.col]));

            //anti-clockwise
            if (isValidMove(grid, sm.row - 1, sm.col + 1) &&
                    sm.direction == Direction.DOWN &&
                    grid[sm.row][sm.col + 1] == 0 &&
                    grid[sm.row - 1][sm.col + 1] == 0)
            {
                if (grid[sm.row - 1][sm.col + 1] == 0) {
                    queue.add(new SnakeMove(sm.row - 1, sm.col + 1, Direction.DOWN, minMatrix[sm.row][sm.col]));
                }
            }

            //clockwise
            if (isValidMove(grid, sm.row + 1, sm.col - 1) &&
                    sm.direction == Direction.RIGHT &&
                    grid[sm.row + 1][sm.col] == 0 &&
                    grid[sm.row + 1][sm.col - 1] == 0)
            {
                if (grid[sm.row + 1][sm.col - 1] == 0) {
                    queue.add(new SnakeMove(sm.row + 1, sm.col - 1, Direction.RIGHT, minMatrix[sm.row][sm.col]));
                }
            }
        }
        if (minMatrix[grid.length-1][grid[0].length-1] == Integer.MAX_VALUE) return -1;
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                System.out.print(minMatrix[i][j]+" ");
            }
            System.out.println();
        }

        return minMatrix[grid.length-1][grid[0].length-1] ;
    }

    public boolean isValidMove(int[][] grid, int r, int c) {
        return ((c < grid[0].length) &&
                (r < grid.length)) &&
                ((c >= 0) && (r >= 0)) &&
                grid[r][c] == 0;
    }
}
