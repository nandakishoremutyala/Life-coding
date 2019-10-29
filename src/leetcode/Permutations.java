package leetcode;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permute(new int[]{1, 2, 3});
        validPermute(new int[]{1, 2, 3}, 0, 2);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), nums);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        MasterPrinter.printList(temp);
        if (temp.size() == nums.length) {
            MasterPrinter.printList(temp);
            result.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            helper(result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    private static void validPermute(int[] in, int l, int r) {
        if (l == r) {
            MasterPrinter.printArray(in);
            System.out.println("");
        }
        for (int i = l; i <= r; i++) {
            in = swap(in, i, l);
            validPermute(in, l + 1, r);
            in = swap(in, i, l);
        }
    }

    private static int[] swap(int[] in, int i, int j) {
        int temp = in[i];
        in[i] = in[j];
        in[j] = temp;
        return in;
    }
}
