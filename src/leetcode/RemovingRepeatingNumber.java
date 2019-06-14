package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class RemovingRepeatingNumber {
    RemovingRepeatingNumber removingRepeatingNumber;

    @BeforeEach
    public void init() {
        removingRepeatingNumber = new RemovingRepeatingNumber();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{1, 3, 3, 3, 2, 2, 2, 3, 1};
        Assertions.assertArrayEquals(removingRepeatingNumber.remove(input), new int[]{1, 3, 1});
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{1, 3, 3, 3, 2, 2, 2, 3, 1, 1};
        Assertions.assertArrayEquals(removingRepeatingNumber.remove(input), new int[]{1, 3});
    }

    @Test
    public void thirdTest() {
        int[] input = new int[]{1, 1, 3, 3, 3, 2, 2, 2, 3, 1, 1};
        Assertions.assertArrayEquals(removingRepeatingNumber.remove(input), new int[]{3});
    }

    @Test
    public void fourthTest() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(removingRepeatingNumber.remove(input), new int[]{1, 2, 3, 4, 5, 6});
    }

    public int[] remove(int[] in) {
        if (in.length == 1) return in;
        int lastSeen = in[0];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(in[0]);
        for (int i = 1; i < in.length; i++) {
            while (deque.isEmpty()) {
                deque.add(in[i]);
                i++;
                lastSeen = in[i];
            }

            int last = deque.getLast();
            if (in[i] == lastSeen) {
                if (in[i] == last) {
                    deque.pollLast();
                    lastSeen = in[i];
                } else
                    i++;
            } else {
                deque.add(in[i]);
                lastSeen = in[i];
            }
        }

        int[] result = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            result[i++] = deque.pollFirst();
        }
        return result;
    }
}
