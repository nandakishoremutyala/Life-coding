package leetcode;

public class SubArrayProductLessThanK {
    /**
     * For those who are confused, let's use the example nums = [10,5,2,6]:
     * <p>
     * If we start at the 0th index, [10,5,2,6], the number of intervals is obviously 1.
     * If we move to the 1st index, the window is now [10,5,2,6]. The new intervals created are [5] and [10,5], so we add 2.
     * Now, expand the window to the 2nd index: [10,5,2,6]. The new intervals are [2], [5,2], and [10,5,2], so we add 3.
     * The pattern should be obvious by now; we add right - left + 1 to the output variable every loop!
     */
    public static void main(String[] args) {
        SubArrayProductLessThanK sapk = new SubArrayProductLessThanK();
        int result = sapk.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        System.out.println(result);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }
}
