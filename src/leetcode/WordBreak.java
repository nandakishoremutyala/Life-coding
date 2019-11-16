package leetcode;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        WordBreak wb = new WordBreak();
        boolean result = wb.wordBreak("leetcode", dict);
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] visited = new int[s.length()];
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) return true;
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}
