package leetcode.contests.contest_171;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConvertIntsToSumOfTwoNonZeroInts {
    ConvertIntsToSumOfTwoNonZeroInts convertIntsToSumOfTwoNonZeroInts;

    @BeforeEach
    public void init() {
        this.convertIntsToSumOfTwoNonZeroInts = new ConvertIntsToSumOfTwoNonZeroInts();
    }

    @Test
    public void firstTest() {
        int n = 11;
        int[] expected = new int[]{2, 9};
        int[] actual = convertIntsToSumOfTwoNonZeroInts.getNoZeroIntegers(n);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void secondTest() {
        int n = 2;
        int[] expected = new int[]{1, 1};
        int[] actual = convertIntsToSumOfTwoNonZeroInts.getNoZeroIntegers(n);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void thirdTest() {
        int n = 10000;
        int[] expected = new int[]{1, 9999};
        int[] actual = convertIntsToSumOfTwoNonZeroInts.getNoZeroIntegers(n);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void fourthTest() {
        int n = 69;
        int[] expected = new int[]{1, 68};
        int[] actual = convertIntsToSumOfTwoNonZeroInts.getNoZeroIntegers(n);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void fifthTest() {
        int n = 1010;
        int[] expected = new int[]{11, 999};
        int[] actual = convertIntsToSumOfTwoNonZeroInts.getNoZeroIntegers(n);
        Assertions.assertArrayEquals(expected, actual);
    }


    public int[] getNoZeroIntegers(int n) {
        int end = n - 1;
        int start = 1;

        while (start <= end) {
            if (!String.valueOf(start).contains("0") &&
                    !String.valueOf(end).contains("0")) {
                return new int[]{start, end};
            }
            start++;
            end--;
        }
        return null;
    }
}
