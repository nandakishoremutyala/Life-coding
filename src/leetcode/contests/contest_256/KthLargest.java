package leetcode.contests.contest_256;

import java.util.*;

public class KthLargest {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        kthLargest.kthLargestNumber(new String[]{"3", "6", "7", "10"}, 3);
    }

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) { // If the same length then compare by their string
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length()); // Compare by their length
        });
        for (String num : nums) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
