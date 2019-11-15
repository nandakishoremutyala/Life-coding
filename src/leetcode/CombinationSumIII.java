package leetcode;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        CombinationSumIII cs = new CombinationSumIII();
        cs.combinationSum3(3, 9);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int length = k;
        helper(1, n, length, new ArrayList<>());
        return result;
    }
    private void helper(int start, int sum, int n, List<Integer> num) {
        if (num.size() > n) return;
        if (num.size() == n && num.stream().mapToInt(i -> (int) i).sum() == sum)
            result.add(new ArrayList<>(num));
        for (int i = start; i <= 9; i++) {
            num.add(i);
            helper(i + 1, sum, n, num);
            num.remove(num.size() - 1);
        }
    }
}
