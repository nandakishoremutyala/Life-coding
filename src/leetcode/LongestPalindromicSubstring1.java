package leetcode;

public class LongestPalindromicSubstring1 {
    public static void main(String[] args) {
        LongestPalindromicSubstring1 lps = new LongestPalindromicSubstring1();
        String result= lps.longestPalindrome("babad");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = centerAround(s, i, i);
            int len2 = centerAround(s, i, i + 1);
            int max = Math.max(len1, len2);
            System.out.println(max);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int centerAround(String str, int L, int R) {
        int start = L;
        int end = R;
        while (start >= 0 &&
                end < str.length() &&
                str.charAt(start) == str.charAt(end)) {
            if (str.charAt(start) == str.charAt(end)) {
                start--;
                end++;
            }
        }
        return end - start - 1;
    }
}
