package leetcode.contests.contest_184;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Coloring3NBlocks {
    Coloring3NBlocks coloring3NBlocks;

    @BeforeEach
    public void init() {
        coloring3NBlocks = new Coloring3NBlocks();
    }

    @Test
    public void firstTest() {
        int n = 1;
        int res = coloring3NBlocks.numOfWays(n);
        Assertions.assertEquals(12, res);
    }

    @Test
    public void secondTest() {
        int n = 1;
        int res = coloring3NBlocks.numOfWays(n);
        Assertions.assertEquals(54, res);
    }

    @Test
    public void thirdTest() {
        int n = 3;
        int res = coloring3NBlocks.numOfWays(n);
        Assertions.assertEquals(246, res);
    }

    public int numOfWays(int n) {
        long mod = (long) 1e9 + 7;
        long pat1 = 6;
        long pat2 = 6;

        for (int i = 1; i < n; ++i) {
            long x = pat1 * 3 + pat2 * 2;
            long y = pat1 * 2 + pat2 * 2;
            pat1 = x % mod;
            pat2 = y % mod;
        }
        return (int) ((pat1 + pat2) % mod);
    }
}
