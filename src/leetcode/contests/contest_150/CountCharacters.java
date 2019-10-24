package leetcode.contests.contest_150;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacters {
    CountCharacters countCharacters;

    @BeforeEach
    public void init() {
        countCharacters = new CountCharacters();
    }

    @Test
    public void firstTest() {
        String[] arr = new String[]{"cat", "bt", "hat", "data_structure/tree"};
        String chars = "atach";
        int len = countCharacters.countCharacters(arr, chars);
        Assertions.assertEquals(6, len);
    }

    @Test
    public void secondTest() {
        String[] arr = new String[]{"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        int len = countCharacters.countCharacters(arr, chars);
        Assertions.assertEquals(10, len);
    }

    public int countCharacters(String[] words, String chars) {
        StringBuilder resultBuild = new StringBuilder();
        Map<Character, Long> charMap = chars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> wMap;
        for (String w : words) {
            wMap = w.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            boolean taken = true;
            for (int i = 0; i < w.length(); i++) {
                if (!charMap.containsKey(w.charAt(i))) {
                    taken = false;
                    break;
                }
                char c = w.charAt(i);
                if (wMap.get(c) > charMap.get(c)) {
                    taken = false;
                    break;
                }
            }
            if (taken)
                resultBuild.append(w);
        }
        return resultBuild.length();
    }
}
