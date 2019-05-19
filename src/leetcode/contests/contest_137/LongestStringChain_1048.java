package leetcode.contests.contest_137;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LongestStringChain_1048 {
    LongestStringChain_1048 longestStringChain;

    @BeforeEach
    public void init() {
        longestStringChain = new LongestStringChain_1048();
    }

    @Test
    public void firstTest() {
        int len = longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"});
        Assertions.assertEquals(4, len);

    }

    public int longestStrChain(String[] words) {
        int max = 0;
        HashMap<String, Integer> wordMaxGain = new HashMap<>();
        HashMap<Integer, LinkedList<String>> lengthWordList = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (!lengthWordList.containsKey(w.length() - 1)) {
                if (lengthWordList.get(w.length()) == null) {
                    LinkedList<String> list = new LinkedList<>();
                    list.addFirst(w);
                    lengthWordList.put(w.length(), list);
                } else {
                    lengthWordList.get(w.length()).addFirst(w);
                }
                wordMaxGain.put(w, 1);
            } else {
                LinkedList l = lengthWordList.get(w.length() - 1);
                processAndUpdate(w, l, wordMaxGain);
                max = Math.max(wordMaxGain.get(w), max);
                if(lengthWordList.get(w.length())!=null){
                    lengthWordList.get(w.length()).addFirst(w);
                }else{
                    LinkedList<String> ll=new LinkedList();
                    ll.addFirst(w);
                    lengthWordList.put(w.length(),ll);
                }

            }
        }
        return max;

    }

    private void processAndUpdate(String cWord, LinkedList<String> words, HashMap<String, Integer> wordMaxGain) {
        for (int i = 0; i < words.size(); i++) {
            String tWord = words.get(i);
            int diff = 0;
            int j = 0;
            int k = 0;
            while (diff <= 1 && k < tWord.length() && j < cWord.length()) {
                if (tWord.charAt(k) != cWord.charAt(j)) {
                    diff++;
                    j++;
                } else {
                    j++;
                    k++;
                }
            }

            if (diff <= 1 &&  k == tWord.length()) {
                wordMaxGain.putIfAbsent(cWord, 0);
                wordMaxGain.put(cWord, Math.max(wordMaxGain.get(tWord) + 1,wordMaxGain.get(cWord)));
            }
        }

    }
}
