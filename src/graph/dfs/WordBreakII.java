package graph.dfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WordBreakII {
    WordBreakII wordBreakII;

    @BeforeEach
    public void init() {
        wordBreakII = new WordBreakII();
    }

    @Test
    public void firstTest() {
        String input = "catsanddog";
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        List<String> result = wordBreakII.wordBreak(input, dict);
        for (String str : result)
            System.out.println(str);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int start = 0;
        return dfs(s, start, dict);
    }

    // this map is important because we dont want to compute same thing over and over again
    // when we got "cat sand dog", we already compute the dog, i mean the index after
    // second time cats and dog, we dont need to compute dog again
    Map<Integer, List<String>> map = new HashMap<>();

    private List<String> dfs(String s, int start, Set<String> dict) {
        if (start == s.length()) return Arrays.asList("");
        if (map.containsKey(start)) return map.get(start);

        List<String> res = new ArrayList<>();
        for (int i = start + 1; i <= s.length(); i++) {
            String subString = s.substring(start, i);
            if (!dict.contains(subString)) continue;
            System.out.println(subString);
            List<String> next = dfs(s, i, dict);
            if (next.size() != 0) {
                for (String k : next) {
                    res.add(subString + (k.equals("") ? "" : " " + k));
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
