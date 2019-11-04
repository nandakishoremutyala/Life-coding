package leetcode;

import java.util.Arrays;

public class ThreeSumCloset {
    public static void main(String[] args) {
        ThreeSumCloset threeSumCloset=new ThreeSumCloset();
        //System.out.println(threeSumCloset.threeSumClosest(new int[]{-1,2,1,-4},1));
        System.out.println(threeSumCloset.threeSumClosest(new int[]{1,1,1,0},-100));

    }
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    private int twoSum(int[] nums, int start, int target){
        int min=Integer.MAX_VALUE;
        int right=nums.length-1;
        while(start<right){
            int temp=nums[start]+nums[right];
            if(temp>min){
                right--;
            }else{
                start++;
            }
        }
        return min;
    }
}
