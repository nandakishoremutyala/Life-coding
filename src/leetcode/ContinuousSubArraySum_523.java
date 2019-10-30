package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubArraySum_523 {
    public static void main(String[] args) {
        ContinuousSubArraySum_523 csas=new ContinuousSubArraySum_523();
        boolean res= csas.checkSubarraySum(new int[]{23, 2, 4, 6, 7},6);
        System.out.println(res);
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
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
