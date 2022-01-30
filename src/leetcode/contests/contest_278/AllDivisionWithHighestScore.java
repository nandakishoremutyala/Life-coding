package leetcode.contests.contest_278;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AllDivisionWithHighestScore {
    AllDivisionWithHighestScore allDivisionWithHighestScore;

    @BeforeEach
    public void init() {
        allDivisionWithHighestScore = new AllDivisionWithHighestScore();
    }

    @Test
    public void firstTest() {
        allDivisionWithHighestScore.maxScoreIndices(new int[]{0, 0, 1, 0});
    }

    public List<Integer> maxScoreIndices(int[] nums) {
        int len = nums.length + 1;
        int totalOnes = Arrays.stream(nums).filter(n -> n == 1).sum();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        int totalZeros = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                int sum = totalOnes;
                map.compute(sum, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
                if (nums[i] == 0) {
                    totalZeros += 1;
                } else {
                    totalOnes -= 1;
                }
            } else if (i == len - 1) {
                int sum = totalZeros;
                map.compute(sum, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
            } else {
                if (nums[i] == 1) {
                    //totalOnes -= 1;
                    int sum = totalZeros + totalOnes;
                    map.compute(sum, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
                    totalOnes -= 1;
                } else {
                    int sum = totalZeros + totalOnes;
                    map.compute(sum, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
                    totalZeros += 1;
                }
            }
        }
        System.out.println(map);
        return map.firstEntry().getValue();
    }
}
