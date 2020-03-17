package leetcode.contests.contest_180;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.*;

public class MaximumPerformanceOfTeam {
    private MaximumPerformanceOfTeam maximumPerformanceOfTeam;

    @BeforeEach
    public void init() {
        maximumPerformanceOfTeam = new MaximumPerformanceOfTeam();
    }

    @Test
    public void firstTest() {
        int[] speed = new int[]{2, 10, 3, 1, 5, 8};
        int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
        int n = 6;
        int k = 2;
        int result = maximumPerformanceOfTeam.maxPerformance(n, speed, efficiency, k);
        Assertions.assertEquals(60, result);
    }

    @Test
    public void secondTest() {
        int[] speed = new int[]{2, 10, 3, 1, 5, 8};
        int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
        int n = 6;
        int k = 3;
        int result = maximumPerformanceOfTeam.maxPerformance(n, speed, efficiency, k);
        Assertions.assertEquals(68, result);
    }

    @Test
    public void thirdTest() {
        int[] speed = new int[]{2, 10, 3, 1, 5, 8};
        int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
        int n = 6;
        int k = 4;
        int result = maximumPerformanceOfTeam.maxPerformance(n, speed, efficiency, k);
        Assertions.assertEquals(72, result);
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i)
            engineers[i] = new int[]{efficiency[i], speed[i]};

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);// efficiency from high to low

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);//low to high
        long res = Long.MIN_VALUE, totalSpeed = 0;

        for (int[] engineer : engineers) {
            if (pq.size() == k) totalSpeed -= pq.poll();  // layoff the one with min speed
            pq.add(engineer[1]);
            totalSpeed = (totalSpeed + engineer[1]);
            res = Math.max(res, (totalSpeed * engineer[0]));  // min efficiency is the efficiency of new engineer
        }
        return (int) (res % MOD);
    }

}
