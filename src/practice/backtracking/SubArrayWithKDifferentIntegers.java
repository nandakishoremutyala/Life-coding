package practice.backtracking;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubArrayWithKDifferentIntegers {
    public static void main(String[] args) {
        SubArrayWithKDifferentIntegers sdi = new SubArrayWithKDifferentIntegers();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        System.out.println(sdi.isKDistinct(l, 2));
        sdi.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int start = 0;
        runBacktrack(A, K, start, new ArrayList<>());
        return 0;
    }

    private boolean runBacktrack(int[] a, int k, int start, List<Integer> l) {

        if (isKDistinct(l, k)){
            MasterPrinter.printList(l);
            return true;
        }
        for (int i = start; i < a.length; i++) {
            l.add(a[i]);
            if (!runBacktrack(a, k, start + 1, l)) return false;
        }
        return false;
    }

    public boolean isKDistinct(List<Integer> l, int k) {
        Set<Integer> set = new HashSet<>();
        for (int val : l)
            set.add(val);
        return set.size() == k;
    }
}
