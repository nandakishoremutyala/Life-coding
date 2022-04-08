package leetcode.contests.contest_285;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.Arrays;

public class LongestSubstringOfOneRepeatingCharacter {
    LongestSubstringOfOneRepeatingCharacter lsrc;

    @BeforeEach
    public void init() {
        lsrc = new LongestSubstringOfOneRepeatingCharacter();
    }

    @Test
    public void firstTest() {
        /**
         * "exjwgrh"
         * "qreuu"
         * [5,4,0,1,5]
         * */
        lsrc.longestRepeating("babacc", "bcb", new int[]{1, 3, 3});
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int len = s.length();
        if (len == 0) return new int[0];
        int k = queryCharacters.length();

        int[] dp = new int[len];
        int max = 1;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    dp[i] = dp[i - 1] + 1;
                    max = Math.max(max, dp[i]);
                } else {
                    dp[i] = 1;
                }
            }

        }
        MasterPrinter.printArray(dp);
        StringBuilder sb = new StringBuilder(s);
        int j=0;
        int[] result=new int[k];
        Arrays.fill(result,1);
        for (int i = 0; i < k; i++) {
            char c = queryCharacters.charAt(i);
            int pos = queryIndices[i];

            if (sb.charAt(pos) == c) continue;
            char prevC = sb.charAt(pos);
            int prevValue = dp[pos];
            sb.setCharAt(pos, c);


            int left = pos - 1;
            int right = pos + 1;
            dp[pos]=1;
            if (left >= 0 && sb.charAt(left) == c) {
                dp[pos] = dp[left] + 1;
                // update the right
                while (right < len && sb.charAt(right) == sb.charAt(pos)) {
                    dp[right] += dp[pos];
                    right++;
                }
            }else if (right < len && sb.charAt(right) == c) {
                while (right < len && sb.charAt(right) == c) {
                    dp[right] += dp[pos];
                    right++;
                }
            }
            right = pos + 1;
            // if the previsous character was equal to right, reduce the impact on right side
            if (right < len && sb.charAt(right) == prevC) {
                while (right < len && sb.charAt(right) == prevC) {
                    dp[right] -= prevValue;
                    right++;
                }
            }
            result[j++]= Arrays.stream(dp).max().getAsInt();
        }

        MasterPrinter.printArray(result);
        return result;

    }
}
