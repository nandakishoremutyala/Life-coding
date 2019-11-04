package leetcode;

import java.util.Arrays;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        int res = searchInRotatedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}
