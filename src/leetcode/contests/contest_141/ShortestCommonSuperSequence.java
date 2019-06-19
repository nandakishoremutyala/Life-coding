package leetcode.contests.contest_141;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShortestCommonSuperSequence {
    ShortestCommonSuperSequence shortestCommonSuperSequence;

    @BeforeEach
    public void init() {
        shortestCommonSuperSequence = new ShortestCommonSuperSequence();
    }

    @Test
    public void firstTest(){
        String result= shortestCommonSuperSequence.shortestCommonSupersequence("XABCBDAB","yBDCABA");
        System.out.println(result);

    }
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0 || j < 0) {
                char c = i < 0 ? s2.charAt(j--) : s1.charAt(i--); // remaining chars in the other string.
                sb.append(c);
            } else if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i--;
                j--;
            } else {
                char c = dp[i][j + 1] > dp[i + 1][j] ? s1.charAt(i--) : s2.charAt(j--); // the char corresponding to larger dp value.
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
