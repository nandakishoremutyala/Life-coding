package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingInteger {
    public static void main(String[] args) {
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
        // System.out.println(firstMissingInteger.firstMissingPositive(new int[]{1,2,0}));

        System.out.println(firstMissingInteger.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Base case.
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        // nums = [1]
        if (n == 1)
            return 2;

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (a == n)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }

    /**
     * It takes extra memory but pass all the test cases
     */
    public int firstMissingPositiveWithExtraMemory(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int i = 1;
        while (true && set.size() > 0) {
            if (!set.contains(i)) return i;
            i++;
        }
        return i;
    }
}
