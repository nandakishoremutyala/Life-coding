package graph.dfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
    ConcatenatedWords concatenatedWords;

    @BeforeEach
    public void init() {
        concatenatedWords = new ConcatenatedWords();
    }

    @Test
    public void firstTest() {
        List<String> result = concatenatedWords.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
        Assertions.assertEquals(3,result.size());
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> dictionary = new HashSet<>();
        if (words.length == 1) {
            result.add(words[0]);
            return result;
        }

        for (String word : words) {
            dictionary.add(word);
        }

        for (String word : words) {
            dictionary.remove(word);
            if (wordCanBeFormed(word, dictionary)) {
                result.add(word);
            }
            dictionary.add(word);
        }
        return result;
    }

    private boolean wordCanBeFormed(String word, Set<String> dictionary) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <=word.length() ; i++) {
            for (int j = 0; j <i ; j++) {
                String subString=word.substring(j,i);
                if(dp[j] && dictionary.contains(subString)){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
