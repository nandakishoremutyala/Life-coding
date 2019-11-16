package leetcode;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] input=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        MinimumFallingPathSum minimumFallingPathSum=new MinimumFallingPathSum();
        minimumFallingPathSum.minFallingPathSum(input);
    }
    int r, c;
    int[][] A;

    public int minFallingPathSum(int[][] A) {
        this.A = A;
        r = A.length;
        c = A[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, findMin(0, i, 0));
        }

        System.out.println(min);
        return min;
    }

    public int findMin(int row, int col, int sum) {
        if (row >= r)
            return sum;
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;
        if (isValid(row, col)) {
            x = findMin(row + 1, col, sum + A[row][col]);
        }
        if (isValid(row + 1, col - 1)){
            z = findMin(row + 1, col - 1, sum + A[row][col]);
        }

        if (isValid(row + 1, col + 1)){
            y = findMin(row + 1, col + 1, sum + A[row][col]);
        }
        return Math.min(Math.min(x, y), z);
    }

    public boolean isValid(int row, int col) {
        if (row >= 0 && row < r && col < c && col >= 0) return true;
        return false;

    }
}
