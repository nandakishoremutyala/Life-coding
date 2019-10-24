package data_structure.trees;

import java.util.Arrays;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        SearchIn2DMatrix searchIn2DMatrix = new SearchIn2DMatrix();
        int[][] input = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean result = searchIn2DMatrix.searchMatrix(input, 5);
        System.out.println(result);
    }

    private boolean helper(int[][] matrix, int target, int r, int c) {

        if (r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length) {
            if (matrix[r][c] == target) return true;
            boolean right = false;
            boolean down = false;
            if (matrix[r][c] < target) {
                right = helper(matrix, target, r, c + 1);
                down = helper(matrix, target, r + 1, c);
                return (right || down);
            }
        }
        return false;
    }

    /**
     * Easiest way to do in a binary search
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //return helper(matrix, target, 0, 0);
        if(matrix.length==0|| matrix[0].length == 0) return false;
        for(int[] row:matrix){
            int result=Arrays.binarySearch(row,target);
            if(result>=0)return true;

        }
        return false;
    }

}
