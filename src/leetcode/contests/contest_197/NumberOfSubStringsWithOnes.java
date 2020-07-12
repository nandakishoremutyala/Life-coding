package leetcode.contests.contest_197;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubStringsWithOnes {

    public static void main(String[] args) {
        NumberOfSubStringsWithOnes nosw = new NumberOfSubStringsWithOnes();
        int result = nosw.numSub("101");
        System.out.println(result);

        int res = nosw.numSub("0110111");
        System.out.println(res);
    }
    int MOD = 1000000007;

    public int numSub(String s) {
        long total = 0;
        for (int j = 0; j < s.length(); j++) {
            long count = 0;
            while (j < s.length() && s.charAt(j) == '1') {
                j++;
                count++;
            }
            total += (count * (count + 1)) / 2;
        }
        total = total % MOD;
        return (int) total;
    }
}
