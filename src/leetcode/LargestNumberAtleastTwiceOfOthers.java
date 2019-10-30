package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LargestNumberAtleastTwiceOfOthers {
    public static void main(String[] args) {
        LargestNumberAtleastTwiceOfOthers ln = new LargestNumberAtleastTwiceOfOthers();
        System.out.println(ln.dominantIndex(new int[]{3, 6, 1, 0}));
    }

    public int dominantIndex(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> {
            if (q > p) return 1;
            else if (p > q) return -1;
            else return 0;
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int val : nums) {
            pq.add(val);
            map.put(val, i++);
        }
        int count = 0;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        if (pq.size() == 1) return 0;
        if (pq.size() > 1 && count < 2) {
            firstMax = pq.poll();
            secondMax = pq.poll();
        }
        if (firstMax >= (2 * secondMax))
            return map.get(firstMax);
        return -1;
    }

}
