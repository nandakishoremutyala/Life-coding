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
        Assertions.assertEquals(60,result);
    }

    @Test
    public void secondTest() {
        int[] speed = new int[]{2, 10, 3, 1, 5, 8};
        int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
        int n = 6;
        int k = 3;
        int result = maximumPerformanceOfTeam.maxPerformance(n, speed, efficiency, k);
        Assertions.assertEquals(68,result);
    }

    @Test
    public void thirdTest() {
        int[] speed = new int[]{2, 10, 3, 1, 5, 8};
        int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
        int n = 6;
        int k = 4;
        int result = maximumPerformanceOfTeam.maxPerformance(n, speed, efficiency, k);
        Assertions.assertEquals(72,result);
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        TreeMap<Integer, int[]> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < speed.length; i++) {
            int s = speed[i];
            int e = efficiency[i];
            int[] arr = new int[2];
            arr[0] = s;
            arr[1] = e;
            map.put((s * e), arr);

        }

        List<Integer> speedList = new ArrayList<>();
        List<Integer> effList = new ArrayList<>();

        for (Map.Entry<Integer, int[]> e : map.entrySet()) {
            if (k > 0) {
                int[] arr = e.getValue();
                speedList.add(arr[0]);
                effList.add(arr[1]);
                k--;
            }else break;
        }

        System.out.println(speedList);
        System.out.println(effList);
        int sum = speedList.stream().mapToInt(Integer::intValue).sum();
        int min= Collections.min(effList);
        return sum*min;
    }

}
