package leetcode;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        int maxSum = -1;

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if (sum >= K) continue;
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
