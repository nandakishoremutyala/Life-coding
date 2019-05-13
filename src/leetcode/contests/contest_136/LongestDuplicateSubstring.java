package leetcode.contests.contest_136;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LongestDuplicateSubstring {
    static Map<Character, LinkedList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        String result = longestDupSubstring("banana");
        System.out.println(result);
    }

    public static String longestDupSubstring(String S) {
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c))
                map.get(c).add(i);
            else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(c, list);
            }
        }

        String output = "";
        Iterator<Map.Entry<Character, LinkedList<Integer>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, LinkedList<Integer>> next = it.next();
            if (next.getValue().size() > 2) {
                String cOutput = compute(next.getValue(), S);
                if (cOutput.length() > output.length())
                    output = cOutput;
            }
        }
        return output;
    }

    private static String compute(LinkedList<Integer> integers, String input) {
        int first = integers.get(0);
        int second = integers.get(1);
        int length = 0;
        while (first < second && second < input.length()) {
            while (second < input.length()) {
                if (input.charAt(first) == input.charAt(second)) {
                    first++;
                    second++;
                    length++;
                } else
                    break;
            }
        }
        return input.substring(first - length, first);
    }

}
