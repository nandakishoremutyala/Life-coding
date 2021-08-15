package effort_2021;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();

        // kthLargestElementInArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);

        kthLargestElementInArray.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
