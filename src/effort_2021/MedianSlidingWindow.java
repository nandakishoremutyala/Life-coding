package effort_2021;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        double[] results = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.peek());
                right.poll();
            } else {
                left.add(nums[i]);
                right.add(left.peek());
                left.poll();
            }
            if (left.size() + right.size() == k) {
                double median;
                if (left.size() == right.size()) {
                    median = (double) ((long) left.peek() + (long) right.peek()) / 2;
                } else {
                    median = (double) left.peek();
                }

                int start = i - k + 1;

                results[start] = median;
                if (!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }

            }
        }
        return results;
    }

}
