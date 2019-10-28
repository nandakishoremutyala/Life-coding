package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        FirstUniqueCharacterInString firstUniqueCharacterInString = new FirstUniqueCharacterInString();
        System.out.println(firstUniqueCharacterInString.firstUniqChar("leetcode"));
        System.out.println(firstUniqueCharacterInString.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> counter = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            counter.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Map.Entry<Character, Integer> e : counter.entrySet()) {
            if (e.getValue() == 1) return s.indexOf(e.getKey());
        }
        return -1;
    }
}
