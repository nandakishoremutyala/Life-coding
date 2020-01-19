package leetcode.contests.contest_172;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Maximum69Number {
    Maximum69Number maximum69Number;

    @BeforeEach
    public void init() {
        maximum69Number = new Maximum69Number();
    }

    @Test
    public void firstTest() {
        int input = 9669;
        int result = maximum69Number.maximum69Number(input);
        Assertions.assertEquals(9969, result);
    }

    @Test
    public void secondTest() {
        int input = 9996;
        int result = maximum69Number.maximum69Number(input);
        Assertions.assertEquals(9999, result);
    }

    @Test
    public void thirdTest() {
        int input = 9999;
        int result = maximum69Number.maximum69Number(input);
        Assertions.assertEquals(9999, result);
    }

    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        int len = 0, count = 0;
        StringBuilder result = new StringBuilder();
        while (len < str.length()) {
            char c = str.charAt(len);
            if (c == '6' && count < 1) {
                result.append('9');
                count++;
            } else
                result.append(c);
            len++;
        }

        return Integer.valueOf(result.toString());
    }
}
