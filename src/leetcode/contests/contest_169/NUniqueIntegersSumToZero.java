package leetcode.contests.contest_169;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

public class NUniqueIntegersSumToZero {
    private NUniqueIntegersSumToZero nUniqueIntegersSumToZero;

    @BeforeEach
    public void init() {
        this.nUniqueIntegersSumToZero = new NUniqueIntegersSumToZero();
    }

    @Test
    public void firstTest() {
        int[] expected = new int[]{0, 2, -2, 1, -1};
        int[] actualResult = nUniqueIntegersSumToZero.sumZero(5);
        MasterPrinter.printArray(actualResult);
        Assertions.assertArrayEquals(actualResult, expected);
    }

    @Test
    public void secondTest() {
        int[] expected = new int[]{0, 1, -1};
        int[] actualResult = nUniqueIntegersSumToZero.sumZero(3);
        MasterPrinter.printArray(actualResult);
        Assertions.assertArrayEquals(actualResult, expected);
    }

    @Test
    public void thirdTest() {
        int[] expected = new int[]{0};
        int[] actualResult = nUniqueIntegersSumToZero.sumZero(1);
        MasterPrinter.printArray(actualResult);
        MasterPrinter.printArray(actualResult);
        Assertions.assertArrayEquals(actualResult, expected);
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n == 1) {
            result[0] = 0;
            return result;
        }
        int x = n / 2;
        if (n % 2 == 0) {
            int i = 0;
            while (i < n) {
                result[i] = x;
                result[i + 1] = -x;
                i += 2;
                x--;
            }
        } else {
            result[0] = 0;
            int i = 1;
            while (i < n) {
                result[i] = x;
                result[i + 1] = -x;
                i += 2;
                x--;
            }
        }
        return result;
    }
}
