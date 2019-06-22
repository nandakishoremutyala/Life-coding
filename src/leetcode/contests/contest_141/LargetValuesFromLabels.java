package leetcode.contests.contest_141;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LargetValuesFromLabels {
    LargetValuesFromLabels largetValuesFromLabels;

    @BeforeEach
    public void init() {
        largetValuesFromLabels = new LargetValuesFromLabels();
    }

    @Test
    public void firstTest() {
        int result = largetValuesFromLabels.largestValsFromLabels(new int[]{5, 4, 3, 2, 1},
                new int[]{1, 1, 2, 2, 3},
                3,
                1);
        Assertions.assertEquals(9, result);

    }

    @Test
    public void secondTest() {
        int result = largetValuesFromLabels.largestValsFromLabels(new int[]{5, 4, 3, 2, 1},
                new int[]{1,3,3,3,2},
                3,
                2);
        Assertions.assertEquals(9, result);

    }

    @Test
    public void thirdTest() {

    }

    @Test
    public void fourthTest() {

    }

    public int largestValsFromLabels(int[] values,
                                     int[] labels,
                                     int num_wanted,
                                     int use_limit) {
        int max_sum = 0;
        TreeMap<Integer, ArrayList<Integer>> groups = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < labels.length; i++) {
            groups.compute(labels[i], (k, v) -> v == null ? new ArrayList<>() : v).add(values[i]);
        }
        System.out.println(groups);
        int limit = 0;
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> it = groups.entrySet().iterator();
        while (limit < num_wanted && it.hasNext()) {
            Map.Entry<Integer, ArrayList<Integer>> entry = it.next();
            ArrayList<Integer> elements = entry.getValue();
            Collections.sort(elements, Collections.reverseOrder());
            // use_limit> higher than the size, take all the elements
            if (use_limit >= elements.size()) {
                int s = elements.stream().mapToInt(Integer::intValue).sum();
                max_sum += s;

            } else {
                for (int i = 0; i < use_limit; i++) {
                    max_sum += elements.get(i);

                }
            }
            limit++;
        }
        return max_sum;

    }
}
