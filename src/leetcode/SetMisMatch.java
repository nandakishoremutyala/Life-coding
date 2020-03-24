package leetcode;

public class SetMisMatch {
    public int[] findErrorNums(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        int sum = 0;
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (seen[nums[i] - 1]) duplicate = nums[i];
            else seen[nums[i] - 1] = true;
        }

        int tsum = (nums.length * (nums.length + 1)) / 2;
        int result = (tsum - sum) + duplicate;

        return new int[]{duplicate, result};
    }
}
