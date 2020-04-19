package leetcode.contests.contest_184;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatchingInAnArray {
    StringMatchingInAnArray stringMatchingInAnArray;

    @BeforeEach
    public void init() {
        stringMatchingInAnArray = new StringMatchingInAnArray();
    }

    @Test
    public void firstTest() {
        String[] words = new String[]{"mass", "as", "hero", "superhero"};
        List<String> result = stringMatchingInAnArray.stringMatching(words);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void secondTest() {
        String[] words = new String[]{"leetcode", "et", "code"};
        List<String> result = stringMatchingInAnArray.stringMatching(words);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void thirdTest() {
        String[] words = new String[]{"blue", "green", "bu"};
        List<String> result = stringMatchingInAnArray.stringMatching(words);
        Assertions.assertEquals(0, result.size());
    }

    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            String str = words[i];
            int start = i + 1;
            while (start < words.length) {
                if (words[start].contains(str)) {
                    result.add(str);
                    break;
                }
                start++;
            }
        }
        return result;
    }
}
