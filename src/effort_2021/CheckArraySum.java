package effort_2021;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CheckArraySum {
    public static void main(String[] args) {
        CheckArraySum checkArraySum = new CheckArraySum();
        //checkArraySum.checkSubarraySum(new int[]{1,2,12}, 6);

        checkArraySum.checkSubarraySum(new int[]{23,2,4,6,7}, 6);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}
