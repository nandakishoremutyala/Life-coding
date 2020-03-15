package leetcode.contests.contest_180;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInAMatrix {
    LuckyNumberInAMatrix luckyNumberInAMatrix;

    @BeforeEach
    public void init() {
        luckyNumberInAMatrix = new LuckyNumberInAMatrix();
    }

    @Test
    public void firstTest() {
        int[][] matrix = new int[][]{
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };
        List<Integer> result = luckyNumberInAMatrix.luckyNumbers(matrix);
        Assertions.assertEquals(1,result.size());
    }

    @Test
    public void secondTest() {
        int[][] matrix = new int[][]{
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };
        List<Integer> result = luckyNumberInAMatrix.luckyNumbers(matrix);
        Assertions.assertEquals(1,result.size());
    }

    @Test
    public void thirdTest() {
        int[][] matrix = new int[][]{
                {7, 8},
                {1,2}
        };
        List<Integer> result = luckyNumberInAMatrix.luckyNumbers(matrix);
        Assertions.assertEquals(1,result.size());
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            int minCol = Integer.MAX_VALUE;
            int val = Integer.MAX_VALUE;
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] <= val) {
                    minCol = c;
                    val = matrix[r][c];
                }
            }
            if (isMaxOfCol(matrix, minCol, val))
                result.add(val);

        }
        return result;
    }

    private boolean isMaxOfCol(int[][] matrix, int minCol, int val) {
        for (int c = 0; c < matrix.length; c++) {
            if (val < matrix[c][minCol])
                return false;
        }
        return true;
    }
}
