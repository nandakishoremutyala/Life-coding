package leetcode.contests.contest_263;

import java.util.*;

public class SecondMinimumDistanceToReachDistance {
    public static void main(String[] args) {
        SecondMinimumDistanceToReachDistance s =new SecondMinimumDistanceToReachDistance();
        int res= s.secondMinimum(5,new int[][]{{1,2},{1,3},{1,4},{3,4},{4,5}},3,5);
        System.out.println(res);
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer,List<Integer>> map = new HashMap<>();

        // prepare adjacency map
        for(int[] e : edges){
            map.putIfAbsent(e[0] , new ArrayList<>());
            map.putIfAbsent(e[1] , new ArrayList<>());

            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});

        for (int[] e : edges) {
            int src = e[0];
            int des = e[1];
            map.get(src).add(des);
            map.get(des).add(src);
        }
        Map<Integer, Integer> cache = new HashMap<>();
        Set<Integer> exhausted = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int city = curr[0];
            int timeElapsed = curr[1];
            // we have found the destination and second minimum because of the '>' sign
            if (city == n &&
                    timeElapsed > cache.getOrDefault(city, Integer.MAX_VALUE)) {
                return timeElapsed;
            }
            // first time visiting
            if (!cache.containsKey(city)) {
                cache.put(city, timeElapsed);
            } else if (cache.get(city) == timeElapsed || exhausted.contains(city))
                continue;
            else {
                exhausted.add(city);// second time, update the black list
            }

            int factor = timeElapsed / change;
            if (factor % 2 == 1) {
                timeElapsed = (factor + 1) * change;
            }
            for (int child : map.get(city)) {
                int visitedTime = timeElapsed + time;
                if (!exhausted.contains(child)) {
                    pq.add(new int[]{child, visitedTime});
                }
            }
        }
        return -1;
    }
}
