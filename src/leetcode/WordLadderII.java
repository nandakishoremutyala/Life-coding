package leetcode;

import others.MasterPrinter;

import java.util.*;

public class WordLadderII {
    /**
     *
     * hit-> hot
     * hot-> lot, dot
     * lot-> log
     * log-> cog
     * dot->dog
     * dog->cog
     * */
    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        List<List<String>> result = wordLadderII.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        for (List<String> l : result)
            MasterPrinter.printList(l);
    }

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        //graph
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> curLevel = new HashSet<String>();
        curLevel.add(beginWord);
        boolean found = false;
        while (!found && !curLevel.isEmpty()) {
            dict.removeAll(curLevel);
            Set<String> nextLevel = new HashSet<String>();
            for (String s : curLevel) {
                graph.put(s, new ArrayList<>());
                //<-- try for every character
                char[] chs = s.toCharArray();
                for (int k = 0; k < beginWord.length(); k++) {
                    char x = chs[k];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[k] = c;
                        String tmp = new String(chs);
                        if (dict.contains(tmp)) {
                            graph.get(s).add(tmp);
                            nextLevel.add(tmp);
                            if (tmp.equals(endWord)) found = true;
                        }
                    }
                    //--> erver character back
                    chs[k] = x;
                }
            }
            curLevel = nextLevel;
        }
        if (!found) return ans;
        List<String> tmp = new ArrayList<>();
        tmp.add(beginWord);
        dfs(beginWord, endWord, graph, tmp);
        return ans;
    }

    private void dfs(String node, String end, Map<String, List<String>> g, List<String> tmp) {
        if (node.equals(end)) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (!g.containsKey(node)) return;

        for (String nei : g.get(node)) {
            tmp.add(nei);
            dfs(nei, end, g, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
