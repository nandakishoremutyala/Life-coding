package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    PartitionEqualSubsetSum partitionEqualSubsetSum;

    int n;
    boolean[] visited;

    @BeforeEach
    public void init() {
        partitionEqualSubsetSum = new PartitionEqualSubsetSum();
    }

    @Test
    public void firstTest() {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean result= partitionEqualSubsetSum.canPartition(nums);
        System.out.println(result);
    }

    public boolean canPartition(int[] nums) {
        n = nums.length;
        visited=new boolean[n];
        int numSubset = 2;
        int total = Arrays.stream(nums).sum();
        if (total % numSubset != 0) return false;
        int target = total / numSubset;
        int rem = 0, start = 0;
        return dfs(nums, target, rem, start, numSubset);
    }

    private boolean dfs(int[] nums, int target, int rem, int start, int numSubset) {
        if(rem<0)return false;
        if(rem==0){
            --numSubset;
            rem = target;
            start = 0;
        }
        if (numSubset == 0) return true;

        for (int i = start; i <n ; ++i) {
            if(visited[i])continue;
            visited[i]=true;
            if(dfs(nums,target,rem-nums[i],i,numSubset)) return true;
            visited[i]=false;
        }
        return false;
    }
}
