package leetcode.contests.contest_262;

import java.util.*;
import java.util.stream.Collectors;

public class TwoOutThree {
    public static void main(String[] args) {

    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1)
            set1.add(i);

        Set<Integer> all = new HashSet<>(set1);
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2)
            set2.add(i);
        all.addAll(set2);
        Set<Integer> set3 = new HashSet<>();
        for (int i : nums3)
            set3.add(i);
        all.addAll(set3);

        List<Integer> result=new ArrayList<>();
        for (int x : all){
            int count=0;
            if(set1.contains(x))
                count++;
            if(set2.contains(x))
                count++;
            if(set3.contains(x))
                count++;
            if(count>=2) result.add(x);
        }
        return result;
    }
}
