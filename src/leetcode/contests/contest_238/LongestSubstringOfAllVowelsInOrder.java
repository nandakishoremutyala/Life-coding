package leetcode.contests.contest_238;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LongestSubstringOfAllVowelsInOrder {
    LongestSubstringOfAllVowelsInOrder longestSubstringOfAllVowelsInOrder;

    @BeforeEach
    public void init() {
        longestSubstringOfAllVowelsInOrder = new LongestSubstringOfAllVowelsInOrder();
    }

    @Test
    public void firstTest() {
        int len = longestSubstringOfAllVowelsInOrder.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu");
        Assertions.assertEquals(13,len);
    }

    @Test
    public void secondTest() {
        int len = longestSubstringOfAllVowelsInOrder.longestBeautifulSubstring("aeeeiiiioooauuuaeiou");
        Assertions.assertEquals(5,len);
    }

    public int longestBeautifulSubstring(String word) {
        int countInOrder = 1;
        int len = 1;
        int max = 0;

        int n = word.length();

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                len++;
            } else if (word.charAt(i - 1) < word.charAt(i)) {
                countInOrder++;
                len++;
            } else {
                len = 1;
                countInOrder = 1;
            }

            if (countInOrder == 5) {
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
