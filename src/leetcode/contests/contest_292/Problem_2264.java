package leetcode.contests.contest_292;

import java.util.HashSet;
import java.util.Set;

public class Problem_2264 {
    public String largestGoodInteger(String num) {
        Set<String> set = new HashSet<>();

        set.add("000");
        set.add("111");
        set.add("222");
        set.add("333");
        set.add("444");
        set.add("555");
        set.add("666");
        set.add("777");
        set.add("888");
        set.add("999");

        int max = -1;
        for (int i = 0; i <= num.length() - 3; i++) {
            String sub = num.substring(i, i + 3);
            if (set.contains(sub)) {
                max = Math.max(max, Integer.parseInt(sub));
            }
        }
        if (max == 0) return "000";
        return max == -1 ? "" : String.valueOf(max);
    }
}
