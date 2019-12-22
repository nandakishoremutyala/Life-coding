package leetcode.contests.contest_168;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberWithEvenNumberOfDigits {
    NumberWithEvenNumberOfDigits numberWithEvenNumberOfDigits;

    @BeforeEach
    public void init() {
        numberWithEvenNumberOfDigits = new NumberWithEvenNumberOfDigits();
    }

    @Test
    public void firstTestCase() {
        int[] input = new int[]{12, 345, 2, 6, 7896};
        int len = numberWithEvenNumberOfDigits.findNumbers(input);
        Assertions.assertEquals(2, len);
    }

    @Test
    public void secondTestCase() {
        int[] input = new int[]{555, 901, 482, 1771};
        int len = numberWithEvenNumberOfDigits.findNumbers(input);
        Assertions.assertEquals(1, len);
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String str = Integer.toString(num);
            if (str.length() % 2 == 0)
                count++;
        }
        return count;
    }
}
