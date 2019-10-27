package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String result = mostCommonWord.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
        System.out.println(result);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        for (String str : banned)
            ban.add(str.toLowerCase());

        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        HashMap<String, Integer> counter = new HashMap<>();
        for (String s : words) {
            if (!s.isEmpty() && !ban.contains(s.toLowerCase()))
                counter.compute(s, (k, v) -> v == null ? 1 : v + 1);
        }
        int max = 0;
        String maxString = "";
        for (Map.Entry<String, Integer> e : counter.entrySet()) {
            if (e.getValue() >= max) {
                maxString = e.getKey();
                max = e.getValue();
            }
        }
        return maxString;
    }
}
