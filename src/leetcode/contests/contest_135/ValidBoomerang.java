package leetcode.contests.contest_135;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidBoomerang {
    ValidBoomerang validBoomerang;

    @BeforeEach
    public void init() {
        validBoomerang = new ValidBoomerang();
    }

    @Test
    public void testFirst() {
        int[][] input = new int[][]{{1, 1}, {2, 2}, {3, 3}};

        boolean result = isBoomerang(input);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testSecond() {
        int[][] input = new int[][]{{1, 1}, {2, 3}, {3, 2}};
        boolean result = isBoomerang(input);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testThird() {
        int[][] input = new int[][]{{0, 0}, {0, 2}, {2, 1}};
        boolean result = isBoomerang(input);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testFourth() {
        int[][] input = new int[][]{{0, 0}, {2, 1}, {2, 1}};
        boolean result = isBoomerang(input);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testFifth() {
        int[][] input = new int[][]{{0, 0}, {1, 2}, {0, 1}};
        boolean result = isBoomerang(input);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testSixth() {
        int[][] input = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        boolean result = isBoomerang(input);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testSeven() {
        int[][] input = new int[][]{{0, 1}, {0, 1}, {2, 1}};
        boolean result = isBoomerang(input);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testEight() {
        int[][] input = new int[][]{{0, 1}, {1, 0}, {0, 1}};
        boolean result = isBoomerang(input);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testNine() {
        int[][] input = new int[][]{{0, 1}, {1, 1}, {2, 2}};
        boolean result = isBoomerang(input);
        Assertions.assertEquals(true, result);
    }

    public boolean isBoomerang(int[][] points) {
        if (points[0] == points[1] || points[1] == points[2] || points[0] == points[2]) return false;

        int x1 = points[0][0];
        int y1 = points[0][1];

        int x2 = points[1][0];
        int y2 = points[1][1];

        int x3 = points[2][0];
        int y3 = points[2][1];
        return x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) != 0;
    }
}
