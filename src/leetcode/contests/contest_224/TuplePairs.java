package leetcode.contests.contest_224;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TuplePairs {
    TuplePairs tuplePairs;

    @BeforeEach
    public void init() {
        tuplePairs = new TuplePairs();
    }

    @Test
    public void firstTest() {
        int result = tuplePairs.tupleSameProduct(new int[]{2, 3, 4, 6});
        Assertions.assertEquals(result, 8);
    }

    @Test
    public void secondTest() {
        int result = tuplePairs.tupleSameProduct(new int[]{1, 2, 4, 5, 10});
        Assertions.assertEquals(result, 16);
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int mul = nums[i] * nums[j];
                    map.compute(mul, (k, v) -> v == null ? 1 : v + 1);
                }
            }
        }
        int res=0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int val = e.getValue() / 2;
            res+=val*(val-1)*4;
        }
        return res;
    }
}
