package leetcode;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0 || matrix[i][j] == Integer.MIN_VALUE)
                    updateRowCol(i, j, r, c, matrix);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = 0;
            }
        }
    }

    private void updateRowCol(int r, int c, int rows, int cols, int[][] matrix) {
        for (int i = 0; i < cols; i++) {
            if (matrix[r][i] == 0)
                matrix[r][i] = Integer.MIN_VALUE;
            else
                matrix[r][i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][c] == 0)
                matrix[i][c] = Integer.MIN_VALUE;
            else
                matrix[i][c] = Integer.MAX_VALUE;
        }
    }
}
