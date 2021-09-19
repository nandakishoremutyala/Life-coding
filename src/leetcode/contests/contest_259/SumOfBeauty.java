package leetcode.contests.contest_259;

import java.util.Arrays;

public class SumOfBeauty {
    public static void main(String[] args) {
        int result = sumOfBeauties(new int[]{1, 2, 3});
        System.out.println(result);
        int result1 = sumOfBeauties(new int[]{2, 4, 6, 4});
        System.out.println(result1);

        int result2 = sumOfBeauties(new int[]{3, 2, 1});
        System.out.println(result2);
    }

    public static int sumOfBeauties(int[] nums) {
        int N = nums.length;
        int max = Integer.MIN_VALUE;
        int[] maxFromLeft = new int[N];
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nums[i]);
            maxFromLeft[i] = Math.max(max, nums[i]);
        }

        max = Integer.MAX_VALUE;
        int[] maxFromRight = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            max = Math.min(max, nums[i]);
            maxFromRight[i] = Math.min(max, nums[i]);
        }
        int[] result = new int[N];
        for (int i = 1; i < N - 1; i++) {
            if (maxFromLeft[i - 1] < nums[i] && maxFromRight[i + 1] > nums[i]) {
                result[i] = 2;
            } else if (nums[i - 1] < nums[i] && nums[i + 1] > nums[i]) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return Arrays.stream(result).sum();
    }
}
