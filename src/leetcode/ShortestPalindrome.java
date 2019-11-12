package leetcode;

public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome=new ShortestPalindrome();
        String str= shortestPalindrome.shortestPalindrome("abcd");
        System.out.println(str);
    }
    public String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j))
                i++;
        }

        if (i == n) return s;
        StringBuilder rem = new StringBuilder(s.substring(i, n));
        String rem_rev = rem.reverse().toString();
        return rem_rev + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }
}
