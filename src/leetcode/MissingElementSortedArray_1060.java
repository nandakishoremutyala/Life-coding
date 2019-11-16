package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MissingElementSortedArray_1060 {
    MissingElementSortedArray_1060 mesa;

    @BeforeEach
    public void init() {
        mesa = new MissingElementSortedArray_1060();
    }

    @Test
    public void firstTest() {
        int result = mesa.missingElement(new int[]{4, 7, 9, 10}, 1);
        Assertions.assertEquals(result, 5);
    }

    @Test
    public void secondTest() {
        int result = mesa.missingElement(new int[]{4, 7, 9, 10}, 3);
        Assertions.assertEquals(result, 8);
    }

    @Test
    public void thirdTest() {
        int result = mesa.missingElement(new int[]{1, 2, 4}, 3);
        Assertions.assertEquals(result, 6);
    }

    public int missingElement(int[] nums, int k) {
        int i = 1;
        while (i < nums.length) {
            int start = nums[i - 1];
            int end = nums[i];
            int diff = end - start - 1;
            if (diff < k)
                k -= diff;
            else if (diff >= k) {
                return start + k;
            }
            if (k == 0) return end;
            i++;
        }
        return nums[nums.length - 1] + k;
    }
}
