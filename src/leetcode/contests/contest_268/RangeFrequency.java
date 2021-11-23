package leetcode.contests.contest_268;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RangeFrequency {
    Map<Integer, TreeMap<Integer, Integer>> map;

    public RangeFrequency(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            map.putIfAbsent(val, new TreeMap<Integer, Integer>());
            map.get(val).put(i, i);
        }
        //System.out.println(map);
    }

    public int query(int left, int right, int value) {
        int count = 0;
        TreeMap<Integer, Integer> m = map.get(value);
        if (m == null) return count;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getKey() >= left && e.getKey() <= right) {
                count++;
            }
        }
        return count;
    }
}
