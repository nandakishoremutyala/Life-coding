package leetcode.contests.contest_159;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ReplaceSubstringForBalancedString {
    ReplaceSubstringForBalancedString replaceSubstringForBalancedString;

    @BeforeEach
    public void init() {
        replaceSubstringForBalancedString = new ReplaceSubstringForBalancedString();
    }

    @Test
    public void firstTest() {
        String input = "QWER";
        int result = replaceSubstringForBalancedString.balancedString(input);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void secondTest() {
        String input = "QQWE";
        int result = replaceSubstringForBalancedString.balancedString(input);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void thirdTest() {
        String input = "QQQW";
        int result = replaceSubstringForBalancedString.balancedString(input);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void fourthTest() {
        String input = "QQQQ";
        int result = replaceSubstringForBalancedString.balancedString(input);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void fifthTest() {
        String input = "WWEQERQWQWWRWWERQWEQ";
        int result = replaceSubstringForBalancedString.balancedString(input);
        Assertions.assertEquals(3, result);
    }

    public int balancedString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('R', 0);
        map.put('E', 0);

        int count = 0;
        int len = s.length();
        int target = len / 4;

        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int val = e.getValue();
            if (val >= target)
                count += (val - target);
        }
        return Math.abs(count);
    }
}
