package leetcode.contests.contest_277;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        if (nums.length == 0) return new int[0];
        int len = nums.length;
        int[] result = new int[len];
        int cur = 0;

        int posLocation = 0;
        int negLocation = 0;

        while (cur < len) {
            // find positive number
            while (nums[posLocation] < 0 && posLocation < len) {
                posLocation++;
            }
            if (posLocation < len) {
                result[cur++] = nums[posLocation++];
            }
            // find negative number
            while (nums[negLocation] >= 0 && negLocation < len) {
                negLocation++;
            }
            if (negLocation < len) {
                result[cur++] = nums[negLocation++];
            }
        }
        return result;
    }
}
