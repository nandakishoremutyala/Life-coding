package leetcode;

import java.util.PriorityQueue;

public class Problem_703 {
    PriorityQueue<Integer> pq;
    int k;

    public Problem_703(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
