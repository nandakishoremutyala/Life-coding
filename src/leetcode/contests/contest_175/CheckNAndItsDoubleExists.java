package leetcode.contests.contest_175;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class CheckNAndItsDoubleExists {
    CheckNAndItsDoubleExists checkNAndItsDoubleExists;

    @BeforeEach
    public void init() {
        checkNAndItsDoubleExists = new CheckNAndItsDoubleExists();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{10, 2, 5, 3};
        boolean result = checkNAndItsDoubleExists.checkIfExist(input);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{7, 1, 14, 11};
        boolean result = checkNAndItsDoubleExists.checkIfExist(input);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void thirdTest() {
        int[] input = new int[]{3, 1, 7, 11};
        boolean result = checkNAndItsDoubleExists.checkIfExist(input);
        Assertions.assertEquals(false, result);
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int n : arr) {
            int m = n * 2;
            if (seen.contains(m)) return true;
            if (n % 2 == 0) {
                m = n / 2;
                if (seen.contains(m)) return true;
            }
            seen.add(n);
        }
        return false;
    }

}
