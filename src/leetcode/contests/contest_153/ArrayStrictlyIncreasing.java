package leetcode.contests.contest_153;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayStrictlyIncreasing {
    ArrayStrictlyIncreasing arrayStrictlyIncreasing;

    @BeforeEach
    public void init() {
        arrayStrictlyIncreasing = new ArrayStrictlyIncreasing();
    }

    @Test
    public void firstTest() {
        int[] in1 = new int[]{1, 5, 3, 6, 7};
        int[] in2 = new int[]{1, 3, 2, 4};
        Assertions.assertEquals(1, arrayStrictlyIncreasing.makeArrayIncreasing(in1, in2));
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int i;
        int j = 0;
        int count = 0;
        for (i = 1; i < arr1.length; i++) {
            if (arr1[i] < arr1[i - 1]) {//violation, needs to correct
                while (j < arr2.length) {
                    if (arr2[j] < arr1[i]) {
                        arr1[i - 1] = arr2[j];
                        count++;
                        i--;
                        break;
                    }
                    j++;
                }
            }

        }
        return -1;

    }
}
