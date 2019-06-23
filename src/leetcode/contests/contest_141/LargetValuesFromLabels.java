package leetcode.contests.contest_141;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class LargestValuesFromLabels {
    LargestValuesFromLabels largestValuesFromLabels;

    class Item {
        int val, pos;

        Item(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    @BeforeEach
    public void init() {
        largestValuesFromLabels = new LargestValuesFromLabels();
    }

    @Test
    public void firstTest() {
        int result = largestValuesFromLabels.largestValsFromLabels(new int[]{5, 4, 3, 2, 1},
                new int[]{1, 1, 2, 2, 3},
                3,
                1);
        Assertions.assertEquals(9, result);
    }

    @Test
    public void secondTest() {
        int result = largestValuesFromLabels.largestValsFromLabels(new int[]{5, 4, 3, 2, 1},
                new int[]{1, 3, 3, 3, 2},
                3,
                2);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void thirdTest() {
        int result = largestValuesFromLabels.largestValsFromLabels(new int[]{9, 8, 8, 7, 6},
                new int[]{0, 0, 0, 1, 1},
                3,
                1);
        Assertions.assertEquals(16, result);
    }

    @Test
    public void fourthTest() {
        int result = largestValuesFromLabels.largestValsFromLabels(new int[]{9, 8, 8, 7, 6},
                new int[]{0, 0, 0, 1, 1},
                3,
                2);
        Assertions.assertEquals(24, result);
    }

    public int largestValsFromLabels(int[] values,
                                     int[] labels,
                                     int num_wanted,
                                     int use_limit) {
        int max_sum = 0;
        PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.val < o2.val)
                return 1;
            else if (o1.val > o2.val)
                return -1;
            else
                return 0;

        });
        for (int i = 0; i < values.length; i++) {
            pq.add(new Item(values[i], i));
        }

        HashMap<Integer, Integer> groupCounter = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {
            groupCounter.put(labels[i], 0);
        }
        int limit = 0;
        while (!pq.isEmpty() && limit < num_wanted) {
            Item it = pq.poll();
            if (groupCounter.get(labels[it.pos]) < use_limit) {
                groupCounter.computeIfPresent(labels[it.pos], (k, v) -> v + 1);
                max_sum += it.val;
                limit++;
            }

        }
        return max_sum;
    }
}
