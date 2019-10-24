package data_structure.graph.dfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestIncreasingPathInMatrix {
    LongestIncreasingPathInMatrix longestIncreasingPathInMatrix;
    int[][] nexts = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    @BeforeEach
    public void init() {
        longestIncreasingPathInMatrix = new LongestIncreasingPathInMatrix();
    }

    @Test
    public void firstTest() {
        int[][] nums = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        int result = longestIncreasingPathInMatrix.longestIncreasingPath(nums);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void secondTest() {
        int[][] nums = new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        int result = longestIncreasingPathInMatrix.longestIncreasingPath(nums);
        Assertions.assertEquals(4, result);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        if(r==0)return 0;
        int c = matrix[0].length;
        int[][] cache = new int[r][c];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max = Math.max(max, findMinPath(matrix, cache, i, j));
            }
        }

        return max;
    }

    private int findMinPath(int[][] matrix, int[][] cache, int i, int j) {
        int path = 1;
        if (cache[i][j] == 0) {
            // compute for every four neighbours
            for (int[] next : nexts) {
                int x = i + next[0];
                int y = j + next[1];
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                        && matrix[i][j] < matrix[x][y]) {
                    path = Math.max(path, findMinPath(matrix, cache, x, y) + 1);
                }
            }
            cache[i][j] = path;
        }
        return cache[i][j];
    }
}
