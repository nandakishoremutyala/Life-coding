package dailycodings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsStringWithDistinctCharacter_DC_13 {
    public static void main(String[] args) {
        String input = "mangopalllaa";
        System.out.println(computeLength(input, 2));
    }

    private static int computeLength(String input, int k) {
        int len = 0;
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        while (end < input.length()) {
            set.add(input.charAt(end));
            if (set.size() > k) {
                set.remove(input.charAt(start));
                start++;
            }
            if (set.size() == k) {
                len = Math.max((end - start)+1, len);
            }
            end++;
        }
        return len;
    }
}
