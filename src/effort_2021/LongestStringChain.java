package effort_2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int longestWordSequenceLength = 1;

        for (String str : words) {
            int maxWordLength = 1;
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(i);
                int prevLength = dp.getOrDefault(sb.toString(), 0);
                maxWordLength = Math.max(maxWordLength, prevLength + 1);
            }
            dp.put(str, maxWordLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, maxWordLength);
        }
        return longestWordSequenceLength;
    }
}
