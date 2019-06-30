package leetcode.contests.contest_143;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistributeCandiesToPeople {
    DistributeCandiesToPeople distributeCandiesToPeople;

    @BeforeEach
    public void init() {
        distributeCandiesToPeople = new DistributeCandiesToPeople();
    }

    @Test
    public void firstTest() {
        int[] result = distributeCandiesToPeople.distributeCandies(7, 4);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 1}, result);
    }

    @Test
    public void secondTest() {
        int[] result = distributeCandiesToPeople.distributeCandies(10, 3);
        Assertions.assertArrayEquals(new int[]{5, 2, 3}, result);
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int candy = 1;
        while (candies != 0) {
            for (int i = 0; i < num_people; i++) {
                if (candy > candies) {
                    result[i] = result[i]+candies;
                    candies = 0;
                    break;
                } else {
                    candies -= candy;
                    result[i] =result[i]+ candy;
                    candy++;
                }
            }
        }
        return result;
    }
}
