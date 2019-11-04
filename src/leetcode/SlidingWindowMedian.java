package leetcode;

import java.util.Arrays;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        slidingWindowMedian.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length - k+1; i++) {
            int[] temp = new int[k];
            System.arraycopy(nums, i, temp, 0, k);
            Arrays.sort(temp);
            int mid = k / 2;
            if (k % 2 == 0) {
                result[i] = (double) (temp[mid] + temp[mid - 1]) / 2;
            } else {
                result[i] = temp[mid];
            }

        }
        return result;
    }
}
