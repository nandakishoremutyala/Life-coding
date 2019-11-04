package leetcode;

import java.util.PriorityQueue;

public class MinCostToConnectSticks {
    public static void main(String[] args) {
        MinCostToConnectSticks minCostToConnectSticks = new MinCostToConnectSticks();
        System.out.println(minCostToConnectSticks.minCost(new int[]{2, 4, 3}));
        System.out.println(minCostToConnectSticks.minCost(new int[]{1, 8, 3, 5}));
    }

    public int minCost(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) {
            pq.offer(s);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int two = pq.poll() + pq.poll();
            sum += two;
            pq.offer(two);
        }
        return sum;
    }
}
