package leetcode.contests.contest_145;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LongestWellPerformingInterval {
    LongestWellPerformingInterval mLongestWellPerformingInterval;

    @BeforeEach
    public void init() {
        mLongestWellPerformingInterval = new LongestWellPerformingInterval();
    }

    @Test
    public void firstTest() {
        int[] hours = new int[]{9, 9, 6, 1, 6, 6, 9};
        int result = mLongestWellPerformingInterval.longestWPI(hours);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void secondTest() {
        int[] hours = new int[]{6, 6, 9};
        int result = mLongestWellPerformingInterval.longestWPI(hours);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void thirdTest() {
        int[] hours = new int[]{6, 6, 6};
        int result = mLongestWellPerformingInterval.longestWPI(hours);
        Assertions.assertEquals(0, result);
    }

    public int longestWPI(int[] hours) {
        int res = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        int score = 0;
        for (int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0)
                res = i + 1;
            else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }

        return res;
    }

}
