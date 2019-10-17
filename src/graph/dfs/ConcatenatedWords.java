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
        List<String> result = concatenatedWords.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"});
        Assertions.assertEquals(3, result.size());
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList();
        Set<String> dict = new HashSet<>();
        if (words.length == 1) {
            return ans;
        }
        for (String word : words) {
            dict.add(word);
        }

        for (String word : words) {
            int len = word.length();
            if (len == 0) {
                continue;
            } else {
                dict.remove(word);
                if (wordCanBeFormed(word, dict)) {
                    ans.add(word);
                }
                dict.add(word);
            }
        }

        return ans;
    }

    private boolean wordCanBeFormed(String word, Set<String> dictionary) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subString = word.substring(j, i);
                if (dp[j] && dictionary.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
