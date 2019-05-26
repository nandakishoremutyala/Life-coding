package leetcode.contests.contest_138;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HeightChecker {

    HeightChecker heightChecker;

    @BeforeEach
    public void init() {
        heightChecker = new HeightChecker();
    }

    @Test
    public void simpleHeightChecker() {
        int[] in = new int[]{1, 1, 4, 2, 1, 3};
        int count = heightChecker.heightChecker(in);
        Assertions.assertEquals(3, count);
    }

    public int heightChecker(int[] heights) {
        int count = 0;
        if (heights == null || heights.length == 0) return count;
        int len = heights.length;
        int[] newArr = new int[heights.length];
        System.arraycopy(heights, 0, newArr, 0, len);
        Arrays.sort(newArr);
        for (int i = 0; i < len; i++) {
            if (newArr[i] != heights[i])
                count++;
        }
        return count;
    }
}
