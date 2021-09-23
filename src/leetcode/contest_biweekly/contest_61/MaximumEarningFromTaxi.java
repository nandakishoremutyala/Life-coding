package leetcode.contest_biweekly.contest_61;

import java.util.*;

public class MaximumEarningFromTaxi {
    public static void main(String[] args) {
        MaximumEarningFromTaxi maximumEarningFromTaxi = new MaximumEarningFromTaxi();
        long res = maximumEarningFromTaxi.maxTaxiEarnings(20, new int[][]{{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}});
        System.out.println(res);

        long res1 = maximumEarningFromTaxi.maxTaxiEarningsAlternatives(10, new int[][]{{9, 10, 2}, {4, 5, 6}, {6, 8, 1}, {1, 5, 5}, {4, 9, 5}, {1, 6, 5}, {4, 8, 3}, {4, 7, 10}, {1, 9, 8}, {2, 3, 5}});
        System.out.println(res1);
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));


        int start = 0;
        long[] cache = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            cache[i] = Math.max(cache[i], cache[i - 1]);
            while (start < rides.length && rides[start][0] <= i) {
                int[] ride = rides[start];
                int src = ride[0];
                int dest = ride[1];
                int earn = ride[2];
                cache[dest] = Math.max(cache[dest], cache[ride[0]] + dest - src + earn);
                start++;
            }
        }
        return cache[n];
    }

    public long maxTaxiEarningsAlternatives(int n, int[][] rides) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] ride : rides) {
            map.compute(ride[1], (k, v) -> v == null ? new ArrayList<>() : v).add(ride);
        }

        long[] cache = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            cache[i] = Math.max(cache[i], cache[i - 1]);
            List<int[]> r = map.get(i);
            if (r == null) continue;

            for (int[] ride : r) {
                int start=ride[0];
                int end=ride[1];
                int tip=ride[2];

                cache[i]=Math.max(cache[i],(end-start+tip)+cache[start]);
            }
        }
        return cache[n];
    }
}
