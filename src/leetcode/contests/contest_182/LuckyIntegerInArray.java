package leetcode.contests.contest_182;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LuckyIntegerInArray {
    LuckyIntegerInArray luckyIntegerInArray;

    @BeforeEach
    public void init() {
        luckyIntegerInArray = new LuckyIntegerInArray();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{2, 2, 3, 4};
        int result = luckyIntegerInArray.findLucky(input);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{1, 2, 2, 3, 3, 3};
        int result = luckyIntegerInArray.findLucky(input);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void thirdTest() {
        int[] input = new int[]{2, 2, 2, 3, 3};
        int result = luckyIntegerInArray.findLucky(input);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void fourthTest() {
        int[] input = new int[]{5};
        int result = luckyIntegerInArray.findLucky(input);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void fifthTest() {
        int[] input = new int[]{7, 7, 7, 7, 7, 7, 7};
        int result = luckyIntegerInArray.findLucky(input);
        Assertions.assertEquals(7, result);
    }

    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int lucky=-1;
        for (int i : arr) {
            counter.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Map.Entry<Integer, Integer> e : counter.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            if (key == val){
              lucky= Math.max(key,lucky);
            } ;
        }
        return lucky;
    }
}
