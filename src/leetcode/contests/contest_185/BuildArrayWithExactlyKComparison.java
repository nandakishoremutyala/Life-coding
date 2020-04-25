package leetcode.contests.contest_185;

public class BuildArrayWithExactlyKComparison {
    public int numOfArrays(int n, int m, int k) {
        Integer[][][] dp = new Integer[n + 1][m + 1][k + 1];
        return dfs(n, m, k, 0, 0, 0, dp);
    }

    private int dfs(int n, int m, int k, int len, int curMax, int curCost, Integer[][][] dp) {
        if (len == n) {
            if (k == curCost) return 1;
            return 0;
        }

        if (dp[len][curMax][curCost] != null) return dp[len][curMax][curCost];

        int ans = 0;
        ans += (long) curMax * dfs(n, m, k, len + 1, curMax, curCost, dp) % 1_000_000_007;
        if (curCost + 1 <= k) {
            for (int num = curMax + 1; num <= m; num++) {
                ans += dfs(n, m, k, len + 1, num, curCost + 1, dp);
                ans %= 1_000_000_007;
            }
        }
        return dp[len][curMax][curCost] = ans;
    }
}
