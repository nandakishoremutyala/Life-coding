package leetcode.contests.contest_162;

public class CellsWithOddValuesInMatrix {

    public static void main(String[] args) {
        CellsWithOddValuesInMatrix coim = new CellsWithOddValuesInMatrix();
        coim.oddCells(2, 2, new int[][]{{0, 1}, {1, 1}});
    }

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] incr : indices) {
            int r = incr[0];
            int c = incr[1];
            updateRow(matrix, r, m);
            updateCol(matrix, c, n);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 != 0) count++;
            }
        }
        return count;
    }

    public void updateRow(int[][] matrix, int r, int numCol) {
        for (int i = 0; i < numCol; i++) {
            matrix[r][i] += 1;
        }
    }

    public void updateCol(int[][] matrix, int col, int numRow) {
        for (int i = 0; i < numRow; i++) {
            matrix[i][col] += 1;
        }
    }
}
