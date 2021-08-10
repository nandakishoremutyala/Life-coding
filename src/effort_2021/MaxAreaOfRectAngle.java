package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaOfRectAngle {
    MaxAreaOfRectAngle maxAreaOfRectAngle;
    @BeforeEach
    public void init(){
        maxAreaOfRectAngle=new MaxAreaOfRectAngle();
    }
    @Test
    public void firstTest(){
        maxAreaOfRectAngle.largestRectangleArea(new int[]{0,9});
    }


    @Test
    public void secondTest(){
        maxAreaOfRectAngle.largestRectangleArea(new int[]{6, 7, 5, 2, 4, 5, 9, 3});
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {

            while ((stack.peek() != -1)
                    && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }

            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}
