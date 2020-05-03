package leetcode.contests.contest_187;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OnesKPlacesAway {
    OnesKPlacesAway onesKPlacesAway;

    @BeforeEach
    public void init() {
        onesKPlacesAway = new OnesKPlacesAway();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{1, 0, 0, 0, 1, 0, 0, 1};
        int k = 2;
        boolean result = onesKPlacesAway.kLengthApart(input, k);
        Assertions.assertEquals(result, true);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{1, 0, 0, 1, 0, 1};
        int k = 2;
        boolean result = onesKPlacesAway.kLengthApart(input, k);
        Assertions.assertEquals(result, false);
    }

    @Test
    public void thirdTest() {
        int[] input = new int[]{1, 1, 1, 1, 1};
        int k = 0;
        boolean result = onesKPlacesAway.kLengthApart(input, k);
        Assertions.assertEquals(result, true);
    }


    @Test
    public void fourthTest() {
        int[] input = new int[]{0,1,0,1};
        int k = 1;
        boolean result = onesKPlacesAway.kLengthApart(input, k);
        Assertions.assertEquals(result, true);
    }

    public boolean kLengthApart(int[] nums, int k) {
        boolean result = true;

        int pre = -1;
        int fro = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 1) {
                fro = i;
                if (pre == -1) {
                    pre = i;
                } else {
                    int dist = fro - pre;
                    pre = i;
                    if (dist - 1 < k) {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
