package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    SlidingWindowMedian slidingWindowMedian;

    @BeforeEach
    public void init() {
        slidingWindowMedian = new SlidingWindowMedian();
    }

    @Test
    public void firstTest() {
        slidingWindowMedian.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    @Test
    public void secondTest() {
        slidingWindowMedian.medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3);
    }

    @Test
    public void thirdTest() {
        slidingWindowMedian.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4);
    }

    @Test
    public void fourthTest() {
        slidingWindowMedian.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int start = 0;
        int end = start + k - 1;

        int N = nums.length;
        if (N < k) return null;
        double[] output = new double[N - k + 1];

        for (int i = 0; i < k - 1; i++) {
            pq.add(nums[i]);
        }
        int pos = 0;
        while (end < N) {
            pq.add(nums[end]);
            if (k % 2 == 0) { //even case
                int first = k / 2;
                int second = first + 1;

                List<Integer> temp = new ArrayList<>();
                int l = 0;
                while (!pq.isEmpty() && first > 0) {
                    l = pq.poll();
                    temp.add(l);
                    first--;
                }
                int r = pq.poll();
                output[pos++] = (double) ((long)l + (long)r) / 2;
                pq.addAll(temp);
            } else { // odd case
                int first = k / 2;

                List<Integer> temp = new ArrayList<>();
                int l = 0;
                while (!pq.isEmpty() && first >= 0) {
                    l = pq.poll();
                    temp.add(l);
                    first--;
                }
                output[pos++] = l;
                pq.addAll(temp);
            }

            int beg = nums[start];
            pq.remove(beg);
            start++;
            end++;
        }
        return output;
    }
}
