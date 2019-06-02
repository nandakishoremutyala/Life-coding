package leetcode.contests.contest_139;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class IndexPairsOfString {

    IndexPairsOfString indexPairsOfString;

    class Sample implements Comparable<Sample> {
        private int start, end;

        public Sample(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Sample o) {
            if (o == null)
                return -1;
            return start - o.start;
        }

    }


    @BeforeEach
    public void init() {
        indexPairsOfString = new IndexPairsOfString();
    }

    @Test
    public void testFirst() {
        int[][] result = indexPairsOfString.indexPairs("thestoryofleetcodeandme", new String[]{"story", "fleet", "leetcode"});
    }

    @Test
    public void testSecond() {
        int[][] result = indexPairsOfString.indexPairs("ababa", new String[]{"aba", "ab"});
    }
    private int[][] indexPairs(String text, String[] words) {
        List<Sample> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> startPos = findWord(text, word);
            for (int j = 0; j < startPos.size(); j++) {
                Sample s = new Sample(startPos.get(j), startPos.get(j) + word.length() - 1);
                list.add(s);
            }
        }
        Collections.sort(list);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = new int[]{list.get(i).start, list.get(i).end};
        }
        return result;
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
