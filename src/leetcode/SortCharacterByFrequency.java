package leetcode;

import java.util.*;

public class SortCharacterByFrequency {
    public static void main(String[] args) {
        SortCharacterByFrequency sortCharacterByFrequency=new SortCharacterByFrequency();
        System.out.println(sortCharacterByFrequency.frequencySort("tree"));
        System.out.println(sortCharacterByFrequency.frequencySort("cccaaa"));
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }


        List<Map.Entry<Character, Integer>> list =
                new LinkedList<Map.Entry<Character, Integer>>(counter.entrySet());

        Collections.sort(list, (e1, e2) -> {
            if (e2.getValue() > e1.getValue()) return 1;
            else if (e1.getValue() > e2.getValue()) return -1;
            else return 0;
        });
        System.out.println(list);
        StringBuilder sb = new StringBuilder("");
        for (Map.Entry<Character, Integer> e : list) {
            char c = e.getKey();
            int count = e.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        //StringBuilder sb=new StringBuilder("");
        return sb.toString();
    }
}
