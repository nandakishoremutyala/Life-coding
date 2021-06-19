package dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestPalindrome {
    LongestPalindrome lp;
    @BeforeEach
    public void init(){
        lp=new LongestPalindrome();
    }
    @Test
    public void firstTest(){
        String res= lp.longestPalindrome("babad");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
