package leetcode.contests.contest_164;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CountServerThatCommunicate {
    CountServerThatCommunicate countServerThatCommunicate;

    @BeforeEach
    public void init() {
        countServerThatCommunicate = new CountServerThatCommunicate();
    }

    @Test
    public void firstTest() {
        int[][] input = new int[][]{
                {1, 0},
                {0, 1}
        };
        int result = countServerThatCommunicate.countServers(input);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void secondTest() {
        int[][] input = new int[][]{
                {1, 0},
                {1, 1}
        };
        int result = countServerThatCommunicate.countServers(input);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void thirdTest() {
        int[][] input = new int[][]{
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        int result = countServerThatCommunicate.countServers(input);
        Assertions.assertEquals(4, result);
    }

    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rowMap.compute(i, (k, v) -> v == null ? 1 : v + 1);
                    colMap.compute(j, (k, v) -> v == null ? 1 : v + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && (rowMap.get(i) > 1 || colMap.get(j) > 1))
                    result += 1;
            }
        }
        return result;
    }
}
