package leetcode.contests.contest_169;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

public class NUniqueIntegersSumToZero {
    NUniqueIntegersSumToZero nUniqueIntegersSumToZero;

    @BeforeEach
    public void init() {
        this.nUniqueIntegersSumToZero = new NUniqueIntegersSumToZero();
    }

    @Test
    public void firstTest() {
        int[] result = nUniqueIntegersSumToZero.sumZero(5);
        MasterPrinter.printArray(result);
    }
    @Test
    public void secondTest() {
        int[] result = nUniqueIntegersSumToZero.sumZero(3);
        MasterPrinter.printArray(result);
    }
    @Test
    public void thirdTest() {
        int[] result = nUniqueIntegersSumToZero.sumZero(1);
        MasterPrinter.printArray(result);
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n == 1) {
            result[0] = 0;
            return result;
        }
        if (n % 2 == 0) {
            int x = n / 2;
            int i = 0;
            while (i < n) {
                result[i] = x;
                result[i + 1] = -x;
                i += 2;
                x--;
            }
        } else {
            int x = n / 2;
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
