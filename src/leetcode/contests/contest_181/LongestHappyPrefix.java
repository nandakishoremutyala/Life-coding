package leetcode.contests.contest_181;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestHappyPrefix {
    LongestHappyPrefix longestHappyPrefix;

    @BeforeEach
    public void init() {
        longestHappyPrefix = new LongestHappyPrefix();
    }

    @Test
    public void firstTest() {
        String input = "level";
        String result = longestHappyPrefix.longestPrefix(input);
        Assertions.assertEquals(result, "l");
    }

    @Test
    public void secondTest() {
        String input = "ababab";
        String result = longestHappyPrefix.longestPrefix(input);
        Assertions.assertEquals(result, "abab");
    }

    @Test
    public void thirdTest() {
        String input = "leetcodeleet";
        String result = longestHappyPrefix.longestPrefix(input);
        Assertions.assertEquals(result, "leet");
    }

    @Test
    public void fourthTest() {
        String input = "a";
        String result = longestHappyPrefix.longestPrefix(input);
        Assertions.assertEquals(result, "");
    }

    @Test
    public void fifthTest() {
        String input = "aaaaa";
        String result = longestHappyPrefix.longestPrefix(input);
        Assertions.assertEquals(result, "aaaa");
    }

    public String longestPrefix(String s) {
        if (s.length() == 1) return "";
        int constant = 26;
        long head = 0, tail = 0, mul = 1, len = 0, mod = 1000000007;
        for (int i = 0; i < s.length() - 1; ++i) {
            head = (head * constant + s.charAt(i)) % mod;
            tail = (tail + mul * s.charAt(s.length() - i - 1)) % mod;
            if (head == tail)
                len = i + 1;
            mul = mul * constant % mod;
        }
        return s.substring(0, (int) len);
    }
}
