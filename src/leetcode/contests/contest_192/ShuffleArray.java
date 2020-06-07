package leetcode.contests.contest_192;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

public class ShuffleArray {
    ShuffleArray shuffleArray;

    @BeforeEach
    public void init() {
        shuffleArray = new ShuffleArray();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{2, 5, 1, 3, 4, 7};
        int[] actual = shuffleArray.shuffle(input, 3);
        MasterPrinter.printArray(actual);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        int[] actual = shuffleArray.shuffle(input, 4);
        MasterPrinter.printArray(actual);
    }

    @Test
    public void thirdTest() {
        int[] input = new int[]{1, 1, 2, 2};
        int[] actual = shuffleArray.shuffle(input, 2);
        MasterPrinter.printArray(actual);
    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];

        int i = 0;
        int j = n;
        int len = 2 * n;
        int pos = 0;

        while (pos < len) {
            res[pos] = nums[i];
            res[pos + 1] = nums[j];
            pos += 2;
            i++;
            j++;
        }
        return res;
    }
}
