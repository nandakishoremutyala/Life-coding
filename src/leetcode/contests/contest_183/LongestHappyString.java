package leetcode.contests.contest_183;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LongestHappyString {
    LongestHappyString longestHappyString;
    TreeMap<Character, Integer> map;

    private class SuitableCharacter {
        int count;
        char c;

        public SuitableCharacter(char c, int count) {
            this.count = count;
            this.c = c;
        }
    }

    @BeforeEach
    public void init() {
        longestHappyString = new LongestHappyString();
    }

    @Test
    public void firstTest() {
        longestHappyString = new LongestHappyString();
        String result = longestHappyString.longestDiverseString(1, 1, 7);
    }

    @Test
    public void secondTest() {
        longestHappyString = new LongestHappyString();
        String result = longestHappyString.longestDiverseString(2, 2, 1);
    }

    @Test
    public void thirdTest() {
        longestHappyString = new LongestHappyString();
        String result = longestHappyString.longestDiverseString(7, 1, 0);
    }

    public String longestDiverseString(int a, int b, int c) {
        map = new TreeMap<>();
        if(a!=0)
            map.put('a', a);
        if(b!=0)map.put('b', b);
        if(c!=0)map.put('c', c);
        System.out.println(map);

        char lastCharacter = '#';
        StringBuilder sb = new StringBuilder();
        SuitableCharacter sc = findSuitableCharacter(lastCharacter, map);
        while (sc != null) {
            if (sc.count >= 2) {
                sb.append(sc.c);
                sb.append(sc.c);
                updateMap(sc.c, 2, map);
                lastCharacter=sc.c;
            } else if (sc.count == 1) {
                sb.append(sc.c);
                updateMap(sc.c, 1, map);
                lastCharacter=sc.c;
            }
            sc = findSuitableCharacter(lastCharacter, map);
        }
        return sb.toString();
    }

    private void updateMap(char c, int i, TreeMap<Character, Integer> map) {
        int count = map.get(c);
        count -= i;
        if (count == 0) map.remove(c);
        else map.put(c, count);
    }

    private SuitableCharacter findSuitableCharacter(char lastCharacter, TreeMap<Character, Integer> map) {
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            char c =e.getKey();
            if (c != lastCharacter) {
                return new SuitableCharacter(e.getKey(), e.getValue());
            }
        }
        return null;
    }
}
