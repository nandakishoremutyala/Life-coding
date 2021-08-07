package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SearchIn2DMatrix {
    SearchIn2DMatrix searchIn2DMatrix;

    @BeforeEach
    public void init() {
        searchIn2DMatrix = new SearchIn2DMatrix();
    }

    @Test
    public void firstTest() {
        searchIn2DMatrix.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        },13);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int targetRow = -1;

        for (int r = 0; r < row; r++) {
            if (r == row - 1) {
                targetRow = r;
            } else {
                if (target >= matrix[r][0] && target < matrix[r + 1][0]) {
                    targetRow = r;
                    break;
                }
            }
        }

        int res = Arrays.binarySearch(matrix[targetRow], target);
        return res >= 0;
    }
}
