package leetcode;

import java.util.Arrays;

public class ValidAnangram {
    public static void main(String[] args) {
        ValidAnangram validAnangram = new ValidAnangram();
        boolean result = validAnangram.isAnagram("anagram", "nagaram");
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return String.valueOf(s1).equalsIgnoreCase(String.valueOf(t1));
    }
}
