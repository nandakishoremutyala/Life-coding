package prep_2021.all_googles;

import java.util.*;

public class MinCostToReachDestinationInTime {
    public static void main(String[] args) {
        int result= minCost(30,
                new int[][]{
                        {0,1,10},
                        {1,2,10},
                        {2,5,10},
                        {0,3,1},
                        {3,4,10},
                        {4,5,15}
                },new int[]{5,1,2,20,20,3});
        System.out.println(result);
    }
    static List<int []> [] graph;

    public static int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        graph = new List [n];

        int [] minTime = new int [n];

        Arrays.fill(minTime, Integer.MAX_VALUE);

        for (int i = 0; i < n; ++i){
            graph[i] = new ArrayList<>();
        }

        for (int [] edge : edges){
            graph[edge[0]].add(new int [] {edge[1], edge[2] });
            graph[edge[1]].add(new int [] {edge[0], edge[2] });
        }

        PriorityQueue<int []> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        queue.add(new int [] {0, passingFees[0], 0});

        // node, fee, time spent
        int [] current;

        int time, score;

        while (!queue.isEmpty()){
            current = queue.poll();

            if (current[2] >= minTime[current[0]])
                continue;

            minTime[current[0]] = current[2];

            if (current[0] == n - 1)
                return current[1];

            for (int [] next : graph[current[0]]){
                time = current[2] + next[1];
                score = current[1] + passingFees[next[0]];

                if (time > maxTime)
                    continue;
                else if (time > minTime[next[0]])
                    continue;

                queue.add(new int [] { next[0], score, time });
            }
        }

        return -1;
    }
}
