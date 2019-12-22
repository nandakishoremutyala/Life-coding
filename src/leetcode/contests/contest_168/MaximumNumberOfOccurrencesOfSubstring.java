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

        return chars.size() <= maxLetters;
    }

    public int count(String txt, String pat) {
        int M = pat.length();//pattern length
        int N = txt.length();//text length
        int res = 0;

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            String substring=txt.substring(i,i+M);
            if(substring.hashCode()==pat.hashCode())res++;
        }
        return res;
    }
}
