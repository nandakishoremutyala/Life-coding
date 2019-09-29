package leetcode.contests.contest_156;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    UniqueNumberOfOccurrences uniqueNumberOfOccurrences;

    @BeforeEach
    public void init() {
        uniqueNumberOfOccurrences = new UniqueNumberOfOccurrences();
    }

    @Test
    public void firstTest() {
        boolean result = uniqueNumberOfOccurrences.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
        Assertions.assertEquals(true, result);
    }

    @Test
    public void secondTest() {
        boolean result = uniqueNumberOfOccurrences.uniqueOccurrences(new int[]{1, 2});
        Assertions.assertEquals(false, result);
    }

    @Test
    public void thirdTest() {
        boolean result = uniqueNumberOfOccurrences.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0});
        Assertions.assertEquals(true, result);
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> elementCounter = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            elementCounter.compute(arr[i], (k, v) -> v == null ? 1 : v + 1);
        }
        Set<Integer> uniqueOccurrences = new HashSet<>();
        for (Integer value : elementCounter.values()) {
            uniqueOccurrences.add(value);
        }
        if (uniqueOccurrences.size() == elementCounter.size())
            return true;
        return false;
    }
}
