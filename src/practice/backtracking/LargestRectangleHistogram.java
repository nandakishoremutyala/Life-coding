package practice.backtracking;

import org.junit.jupiter.api.Assertions;

public class LargestRectangleHistogram {
    public static void main(String[] args) {
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        int res = largestRectangleHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        Assertions.assertEquals(10, res);
        int res1 = largestRectangleHistogram.largestRectangleArea(new int[]{0, 9});
        Assertions.assertEquals(9, res1);
        int res2 = largestRectangleHistogram.largestRectangleArea(new int[]{9, 0});
        Assertions.assertEquals(9, res2);
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
