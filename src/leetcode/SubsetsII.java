package leetcode;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        subsetsII.subsetsWithDup(new int[]{1, 2, 2});
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(path));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
