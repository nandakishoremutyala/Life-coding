package leetcode.contests.contest_260;

import javafx.util.Pair;
import others.MasterPrinter;

public class GridGameMain {
    public static void main(String[] args) {
        GridGameMain gm = new GridGameMain();
        long res = gm.gridGame(new int[][]{{2, 5, 4}, {1, 5, 1}});
        System.out.println(res);
        long res1 = gm.gridGame(new int[][]{{3, 3, 1}, {8, 5, 2}});
        System.out.println(res1);
        long res2 = gm.gridGame(new int[][]{{1,3,1,15}, {1,3,3,1}});
        System.out.println(res2);
    }

    public long gridGame(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Pair<Long, int[]>[][] temp = new Pair[row][col];// first is value second is parent location
        temp[0][0] = new Pair<>((long) grid[0][0], new int[]{0, 0});
        temp[1][0] = new Pair<>((long) grid[0][0] + grid[1][0], new int[]{0, 0});
        for (int c = 1; c < col; c++) {
            for (int r = 0; r < row; r++) {
                if (r == 0) {
                    long updated = temp[r][c - 1].getKey() + (long) grid[r][c];
                    temp[r][c] = new Pair<>(updated, new int[]{r, c - 1});
                } else {
                    long left = temp[r][c - 1].getKey() + (long) grid[r][c];
                    long up = temp[r - 1][c].getKey() + (long) grid[r][c];
                    if (left >= up) {
                        temp[r][c] = new Pair<>(left, new int[]{r, c - 1});
                    } else {
                        temp[r][c] = new Pair<>(up, new int[]{r - 1, c});
                    }
                }
            }
        }
        int[] loc = temp[row - 1][col - 1].getValue();
        grid[row - 1][col - 1] = 0;
        while (true) {
            if (loc[0] == 0 && loc[1] == 0) {
                grid[0][0] = 0;
                break;
            }
            grid[loc[0]][loc[1]] = 0;
            loc = temp[loc[0]][loc[1]].getValue();
        }
        MasterPrinter.printMatrix(grid);

        return maxForSecondRobot(grid, row, col);
    }

    private long maxForSecondRobot(int[][] original, int row, int col) {
        long[][] grid = new long[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = (long) original[i][j];
            }
        }
        grid[1][0] += grid[0][0];
        for (int c = 1; c < col; c++) {
            for (int r = 0; r < row; r++) {
                if (r == 0) {
                    long updated = grid[r][c - 1] + grid[r][c];
                    grid[r][c] = updated;
                } else {
                    long left = grid[r][c - 1] + (long) grid[r][c];
                    long up = grid[r - 1][c] + (long) grid[r][c];
                    if (left >= up) {
                        grid[r][c] = left;
                    } else {
                        grid[r][c] = up;
                    }
                }
            }
        }
        return grid[row - 1][col - 1];
    }
}
