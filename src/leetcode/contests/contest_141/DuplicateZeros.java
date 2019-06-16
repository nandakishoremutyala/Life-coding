package leetcode.contests.contest_141;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DuplicateZeros {
    DuplicateZeros duplicateZeros;

    @BeforeEach
    public void init() {
        duplicateZeros = new DuplicateZeros();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros.duplicateZeros(input);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{0, 0, 0, 0, 0, 0, 0};
        duplicateZeros.duplicateZeros(input);
    }

    @Test
    public void shiftTest() {
        int[] input = new int[]{1, 0, 2, 3, 4,};
        duplicateZeros.shift(input, 2);
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                shift(arr, ++i);
            }
        }
    }

    public void shift(int[] in, int cur) {
        if (cur == in.length) return;
        int prev = in[cur];
        in[cur] = 0;
        int temp;
        while (cur < in.length) {
            if (cur + 1 < in.length) {
                temp = in[cur + 1];
                in[++cur] = prev;
                prev = temp;
            } else
                cur++;
        }
    }
}
