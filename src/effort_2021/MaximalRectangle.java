package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    MaximalRectangle maximalRectangle;

    @BeforeEach
    public void init() {
        maximalRectangle = new MaximalRectangle();
    }

    @Test
    public void firstTest() {
        maximalRectangle.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
    }

    public int maximalRectangle(char[][] matrix) {
        int R = matrix.length;
        if(R==0) return 0;

        int C = matrix[0].length;
        int[][] mat = new int[R][C];
        for (int i = 0; i < C; i++) {
            mat[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == '1')
                    mat[i][j] = mat[i - 1][j]+1;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < R; i++) {
            int area = findMaxArea(mat[i]);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private int findMaxArea(int[] matrix) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int maxArea = 0;
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            while (stack.peek() != -1 &&
                    matrix[stack.peek()] >= matrix[i]) {
                int h = matrix[stack.pop()];
                int w = i - stack.peek() - 1;
                int a = h * w;
                maxArea = Math.max(a, maxArea);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int h = matrix[stack.pop()];
            int w = length - stack.peek() - 1;
            int a = h * w;
            maxArea = Math.max(a, maxArea);
        }

        return maxArea;
    }
}
