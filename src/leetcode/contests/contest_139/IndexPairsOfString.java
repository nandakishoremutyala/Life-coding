package leetcode.contests.contest_139;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class IndexPairsOfString {
    IndexPairsOfString indexPairsOfString;

    @BeforeEach
    public void init() {
        indexPairsOfString = new IndexPairsOfString();
    }

    @Test
    public void firstSimpleExample() {
        int[][] result = indexPairsOfString.indexPairs("thestoryofleetcodeandme", new String[]{"story", "fleet", "leetcode"});
        Assertions.assertArrayEquals(new int[][]{{3,7},{9,13},{10,17}},result);
    }
    private int[][] indexPairs(String text, String[] words) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> startPos = findWord(text, word);
            for (int j = 0; j < startPos.size(); j++) {
                int s = startPos.get(j);
                int e = s + word.length() - 1;
                map.computeIfAbsent(s, k -> new ArrayList<>()).add(e);
            }
        }
        System.out.println(map);
        ArrayList<int[]> resultList = new ArrayList<>();

        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = iterator.next();
            int start = entry.getKey();
            List<Integer> val = entry.getValue();
            Collections.sort(val);
            for (int i = 0; i < val.size(); i++) {
                resultList.add(new int[]{start, val.get(i)});
            }
        }

        int[][] res = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }

    private List<Integer> findWord(String textString, String word) {
        List<Integer> indexes = new ArrayList<Integer>();
        String lowerCaseTextString = textString.toLowerCase();
        String lowerCaseWord = word.toLowerCase();

        int index = 0;
        while (index != -1) {
            index = lowerCaseTextString.indexOf(lowerCaseWord, index);
            if (index != -1) {
                indexes.add(index);
                index++;
            }
        }
        return indexes;
    }
}
