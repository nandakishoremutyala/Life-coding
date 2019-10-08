package leetcode.contests.contest_156;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MinMoveToReachTargetWithRotation {
    MinMoveToReachTargetWithRotation minMoveToReachTargetWithRotation;
    Set<SnakeMove> visited = new HashSet<>();
    int n;

    class SnakeMove {
        //h is for head
        //t is for tail
        int hRow;
        int hCol;
        int tRow;
        int tCol;
        int moves;

        public SnakeMove(int hRow, int hCol, int tRow, int tCol, int moves) {
            this.hRow = hRow;
            this.hCol = hCol;
            this.tRow = tRow;
            this.tCol = tCol;
            this.moves = moves;
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
        n = grid.length;
        SnakeMove s = new SnakeMove(0, 1, 0, 0, 0);
        Queue<SnakeMove> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            SnakeMove curMove = q.poll();
            SnakeMove right = moveRight(grid, curMove, curMove.moves);
            SnakeMove down = moveDown(grid, curMove, curMove.moves);
            SnakeMove clk = moveClockwise(grid, curMove, curMove.moves);
            SnakeMove aclk = moveAntiClockwise(grid, curMove, curMove.moves);
            if (isDestination(curMove)) {
                return curMove.moves;
            }
            if (right != null) {
                q.offer(right);
            }
            if (down != null) {
                q.offer(down);
            }
            if (clk != null) {
                q.offer(clk);
            }
            if (aclk != null) {
                q.offer(aclk);
            }

        }

        return -1;
    }

    private boolean isDestination(SnakeMove curMove) {
        if (curMove.hRow == n - 1 && curMove.hCol == n - 1
                && curMove.tRow == n - 1 && curMove.tCol == n - 2) {
            return true;
        }
        return false;
    }

    private SnakeMove moveAntiClockwise(int[][] grid, SnakeMove snakeMove, int moves) {
        // Not Vertical
        if (snakeMove.hRow != snakeMove.tRow + 1) {
            return null;
        }
        // unable to move
        if (snakeMove.hCol + 1 >= n ||
                grid[snakeMove.hRow][snakeMove.hCol + 1] == 1 ||
                snakeMove.tCol + 1 >= n || grid[snakeMove.tRow][snakeMove.tCol + 1] == 1) {
            return null;
        }
        SnakeMove counterClockP = new SnakeMove(snakeMove.hRow - 1, snakeMove.hCol + 1, snakeMove.tRow, snakeMove.tCol, moves + 1);
        if (isValidMove(grid, counterClockP)) {
            return counterClockP;
        }
        return null;
    }

    private SnakeMove moveClockwise(int[][] grid, SnakeMove snakeMove, int moves) {
        // Not horizontal
        // it will take clockwise turn only when the snake is in horizontal
        if (snakeMove.hCol != snakeMove.tCol + 1) {
            return null;
        }

        //Unable to move
        if (snakeMove.hRow + 1 >= n || // to get the down point, row has to be incremented. safety check for increment
                grid[snakeMove.hRow + 1][snakeMove.hCol] == 1 || //down of the head has to be 1
                snakeMove.tRow + 1 >= n ||
                grid[snakeMove.tRow + 1][snakeMove.tCol] == 1) {// down of the tail has to be 1
            return null;
        }
        SnakeMove clockP = new SnakeMove(snakeMove.hRow + 1, snakeMove.hCol - 1, snakeMove.tRow, snakeMove.tCol, moves + 1);
        // Cannot move back to same position in next position
        if (isValidMove(grid, clockP)) {
            return clockP;
        }
        return null;
    }

    private SnakeMove moveDown(int[][] grid, SnakeMove snakeMove, int moves) {
        SnakeMove downP = new SnakeMove(snakeMove.hRow + 1,
                snakeMove.hCol,
                snakeMove.tRow + 1,
                snakeMove.tCol,
                moves + 1);
        if (isValidMove(grid, downP)) {
            return downP;
        }
        return null;
    }

    private SnakeMove moveRight(int[][] grid, SnakeMove snakeMove, int moves) {
        SnakeMove rightP = new SnakeMove(snakeMove.hRow,
                snakeMove.hCol + 1,
                snakeMove.tRow,
                snakeMove.tCol + 1,
                moves + 1);
        if (isValidMove(grid, rightP)) {
            return rightP;
        }
        return null;
    }

    public boolean isValidMove(int[][] grid, SnakeMove snakeMove) {
        if (snakeMove.hRow < 0 || snakeMove.hRow >= n
                || snakeMove.hCol < 0 || snakeMove.hCol >= n
                || snakeMove.tRow < 0 || snakeMove.tRow >= n
                || snakeMove.tCol < 0 || snakeMove.tCol >= n) {
            return false;
        }
        if (grid[snakeMove.hRow][snakeMove.hCol] == 1 || grid[snakeMove.tRow][snakeMove.tCol
                ] == 1) {
            return false;
        }
        return visited.add(snakeMove);
    }
}
