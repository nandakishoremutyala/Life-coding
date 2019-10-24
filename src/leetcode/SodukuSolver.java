package leetcode;

public class SodukuSolver {
    public static void main(String[] args) {
        SodukuSolver sodukuSolver = new SodukuSolver();
        char[][] input = new char[][]{
                {}, {}, {},
                {}, {}, {},
                {}, {}, {}
        };
        sodukuSolver.solveSudoku(input);
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int x, int y) {
        int n = board.length;
        if (x > n - 1 || y > n - 1)
            return true;
        int nextX = (y == n - 1) ? x + 1 : x;
        int nextY = (y == n - 1) ? 0 : y + 1;
        if (board[x][y] != '.') {
            if (solve(board, nextX, nextY))
                return true;
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isValid(board, x, y, i)) {
                    board[x][y] = (char) (i + '0');
                    if (solve(board, nextX, nextY))
                        return true;
                    board[x][y] = '.';
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int x, int y, int val) {
        int n = board.length;
        //check row
        for (int j = 0; j < n; j++) {
            if (board[x][j] == val + '0') {
                return false;
            }
        }

        //check col
        for (int i = 0; i < n; i++) {
            if (board[i][y] == val + '0') {
                return false;
            }
        }

        //check box
        x = x / 3 * 3;
        y = y / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + x][y + j] == val + '0')
                    return false;
            }
        }

        return true;
    }
}
