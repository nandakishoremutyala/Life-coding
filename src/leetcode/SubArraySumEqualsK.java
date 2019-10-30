package leetcode;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int res = subArraySumEqualsK.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(res);

        int result = subArraySumEqualsK.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4}, 7);
        System.out.println(result);
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.compute(sum, (key, value) -> value == null ? 1 : value + 1);
        }
        return count;
    }
}
