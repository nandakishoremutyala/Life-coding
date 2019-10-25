package leetcode;

import java.util.PriorityQueue;

public class MinCostToConnectSticks {
    public static void main(String[] args) {
        MinCostToConnectSticks minCostToConnectSticks = new MinCostToConnectSticks();
        System.out.println(minCostToConnectSticks.minCost(new int[]{2, 4, 3}));
        System.out.println(minCostToConnectSticks.minCost(new int[]{1, 8, 3, 5}));
    }

    public int minCost(int[] input) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : input)
            pq.add(i);

        int sum = 0;
        int cost = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            int second = 0;
            if (!pq.isEmpty())
                second = pq.poll();
            sum = first + second;
            cost += sum;
            if (!pq.isEmpty())
                pq.add(sum);
        }
        return cost;
    }
}
