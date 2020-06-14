package leetcode.contests.contest_191;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaintHouseIII {
    PaintHouseIII paintHouseIII;

    /**
     * 1   10 -> if you paint with color 1, cost is 1. if you paint with color 2 cost is 10
     * 10  1
     * 10  1
     * 1   10
     * 5   1
     */

    int[][][] dp = new int[101][23][101]; // i th house j color k group

    @BeforeEach
    public void init() {
        paintHouseIII = new PaintHouseIII();
    }

    @Test
    public void firstTest() {
        int[] houses = new int[]{0, 0, 0, 0, 0};
        int[][] cost = new int[][]{{1, 10}, {10, 1}, {1, 10}, {1, 10}, {5, 1}};
        int res = minCost(houses, cost, 5, 2, 3);
        System.out.println(res);
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        int res = dfs(houses, cost, 0, n + 1, target);
        return res >= 10000000 ? -1 : res;

    }

    private int dfs(int[] houses, int[][] cost, int curr, int prev, int target) {
        if (curr >= houses.length) return target != 0 ? 10000000 : 0;
        if (target < 0) return 10000000;
        if (dp[curr][prev][target] >= 0) return dp[curr][prev][target];
        int res = Integer.MAX_VALUE;
        if (houses[curr] == 0) {
            for (int i = 0; i < cost[curr].length; i++) {
                res = Math.min(res, cost[curr][i] + dfs(houses, cost, curr + 1, i + 1, target - (curr + 1 != prev ? 0 : 1)));
            }
        } else {
            res = Math.min(res, dfs(houses, cost, curr + 1, houses[curr], target - (houses[curr] != prev ? 0 : 1)));

        }
        return dp[curr][prev][target] = res;
    }
}



