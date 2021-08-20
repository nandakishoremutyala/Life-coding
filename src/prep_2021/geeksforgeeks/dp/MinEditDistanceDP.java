package prep_2021.geeksforgeeks.dp;

public class MinEditDistanceDP {
    public static void main(String[] args) {
        System.out.println(editDistDP("cat","cut",2,2));
    }
    static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    static int editDistDP(String str1, String str2, int m,
                          int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = n;

                else if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = 1 + min(
                            dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
