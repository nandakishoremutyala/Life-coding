package practice.backtracking;

public class MaximumRectangle {
    public static void main(String[] args) {
        MaximumRectangle maximumRectangle = new MaximumRectangle();
        char[][] input = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximumRectangle.maximalRectangle(input));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = findHeight(matrix, i, j);
            }
            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }

    public int findHeight(char[][] matrix, int r, int c) {
        int h = 0;
        while (r >= 0) {
            if (matrix[r][c] == '1')
                h += 1;
            else
                break;
            r--;
        }
        return h;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) return heights[0];
        int maxArea = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int min = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(heights[j], Math.max(maxArea, min * (j - i + 1)));
                maxArea = Math.max(maxArea, heights[i]);
            }
        }
        return maxArea;
    }
}
