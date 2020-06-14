package leetcode.contests.contest_193;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MinNumberOfDaysToMakeMBouquets {
    MinNumberOfDaysToMakeMBouquets m;

    @BeforeEach
    public void init() {
        m = new MinNumberOfDaysToMakeMBouquets();
    }

    @Test
    public void firstTest() {
        int[] bloomDay = new int[]{1,10,3,10,2};int  m = 3; int k = 1;
        int res=  minDays(bloomDay,m,k);
        System.out.println(res);

    }

    public int minDays(int[] bloomDay, int m, int k) {
        // we need minimum m*k flowers to bloom
        int n = bloomDay.length;
        int[] flowers = new int[n+1];
        int min = m * k;
        if (n < min)
            return -1;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int val = bloomDay[i];
            map.compute(val, (kk, v) -> v == null ? new ArrayList<>() : v).add(i + 1);
        }

        int totalBloomed = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            int day = e.getKey();
            totalBloomed += e.getValue().size();
            for (int bloom : e.getValue()) {
                flowers[bloom-1] = 1;
            }
            if (totalBloomed >= min) {
                if(canWeFullBoquets(flowers, m, k)) return day;
            }

        }
        return -1;
    }

    private boolean canWeFullBoquets(int[] flowers, int m, int k) {
        int firstBloom = -1;
        int p = 0;
        while (p < flowers.length) {
            if (flowers[p] == 1) {
                firstBloom = p;
                break;
            }
        }
        if (firstBloom == -1) return false;

        int pos = firstBloom + 1;
        while (pos < flowers.length) {
            if (flowers[pos] != 1) {
                int target = pos - firstBloom;
                int boquets = target / k;
                if (boquets > 0) {
                    m -= boquets;
                }
                firstBloom = pos+1;
            }
            pos++;
        }
        if (m <= 0) return true;
        return false;

    }
}
