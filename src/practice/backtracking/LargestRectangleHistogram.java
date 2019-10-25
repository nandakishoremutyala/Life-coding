package practice.backtracking;

public class LargestRectangleHistogram {
    public static void main(String[] args) {
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        int res = largestRectangleHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(res);

        int res1 = largestRectangleHistogram.largestRectangleArea(new int[]{0, 9});
        System.out.println(res1);

        int res2 = largestRectangleHistogram.largestRectangleArea(new int[]{9, 0});
        System.out.println(res2);
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int min = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(heights[j], Math.max(maxArea, min * (j - i + 1)));
                maxArea=Math.max(maxArea,heights[i]);
            }
        }
        return maxArea;
    }
}
