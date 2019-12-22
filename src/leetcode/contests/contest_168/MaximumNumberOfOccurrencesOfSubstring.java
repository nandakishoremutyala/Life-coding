package leetcode.contests.contest_168;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfOccurrencesOfSubstring {
    MaximumNumberOfOccurrencesOfSubstring maximumNumberOfOccurrencesOfSubstring;

    @BeforeEach
    public void init() {
        maximumNumberOfOccurrencesOfSubstring = new MaximumNumberOfOccurrencesOfSubstring();
    }

    @Test
    public void firstTest() {
        int result = maximumNumberOfOccurrencesOfSubstring.maxFreq(
                "aababcaab",
                2,
                3,
                4);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void secondTest() {
        int result = maximumNumberOfOccurrencesOfSubstring.maxFreq(
                "aaaa",
                1,
                3,
                3);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void thirdTest() {
        int result = maximumNumberOfOccurrencesOfSubstring.maxFreq(
                "aabcabcab",
                2,
                2,
                3);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void fourthTest() {
        int result = maximumNumberOfOccurrencesOfSubstring.maxFreq(
                "abcde",
                2,
                3,
                3);
        Assertions.assertEquals(0, result);
    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        while (maxSize >= minSize) {
            for (int i = 0; i < s.length() - maxSize; i++) {
                String substr = s.substring(i, i + maxSize);
                System.out.println(substr);
                if (isValid(maxLetters, substr)) {
                    int temp = count(s, substr);
                    max = Math.max(max, temp);
                }
            }
            maxSize--;
        }
        return max;
    }

    public boolean isValid(int maxLetters, String string) {
        Set<Character> chars = new HashSet<>();
        for (char c : string.toCharArray())
            chars.add(c);

        if (chars.size() <= maxLetters) return true;
        return false;
    }

    public int count(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        int res = 0;

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            /* For current index i, check for
        pattern match */
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M) {
                res++;
                j = 0;
            }
        }
        return res;
    }
}
