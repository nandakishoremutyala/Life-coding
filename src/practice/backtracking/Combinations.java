package practice.backtracking;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> result;
    static int n = 4;
    static int k = 2;

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combination(n, k);
    }

    public List<List<Integer>> combination(int n, int k) {
        result = new ArrayList<>();
        combinationHelper(1, n, k, new ArrayList<>());
        return result;
    }

    public void combinationHelper(int start, int n, int k, List<Integer> list) {
        MasterPrinter.printList(list);
        if (list.size() == 2) {
            result.add(new ArrayList<>(list));
            MasterPrinter.printList(list);
        } else {
            for (int i = start; i <= n; i++) {
                //change
                list.add(i);
                //explore
                combinationHelper(i + 1, n, k, list);
                //unchange
                list.remove(list.size() - 1);
            }
        }

    }
}
