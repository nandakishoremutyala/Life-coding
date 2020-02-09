package leetcode.contests.contest_175;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinStepsToMakeAnangram {
    MinStepsToMakeAnangram minStepsToMakeAnangram;

    @BeforeEach
    public void init() {
        minStepsToMakeAnangram = new MinStepsToMakeAnangram();
    }

    @Test
    public void firstTest() {
        String s = "aba";
        String t = "aba";
        int minSteps = minStepsToMakeAnangram.minSteps(s, t);
        Assertions.assertEquals(0, minSteps);
    }

    @Test
    public void secondTest() {
        String s = "leetcode";
        String t = "practice";
        int minSteps = minStepsToMakeAnangram.minSteps(s, t);
        Assertions.assertEquals(5, minSteps);
    }

    @Test
    public void thirdTest() {
        String s = "anagram";
        String t = "mangaar";
        int minSteps = minStepsToMakeAnangram.minSteps(s, t);
        Assertions.assertEquals(0, minSteps);
    }

    @Test
    public void fourthTest() {
        String s = "xxyyzz";
        String t = "xxyyzz";
        int minSteps = minStepsToMakeAnangram.minSteps(s, t);
        Assertions.assertEquals(0, minSteps);
    }

    @Test
    public void fifthTest() {
        String s = "friend";
        String t = "family";
        int minSteps = minStepsToMakeAnangram.minSteps(s, t);
        Assertions.assertEquals(4, minSteps);
    }

    public int minSteps(String s, String t) {
        TreeMap<Character, Integer> m1 = new TreeMap<>();
        TreeMap<Character, Integer> m2 = new TreeMap<>();

        for (char c : s.toCharArray()) {
            m1.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        for (char c : t.toCharArray()) {
            m2.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        int result=0;
        for(Map.Entry<Character,Integer> e:m2.entrySet()){
            char key=e.getKey();
            int val2=e.getValue();
            if(m1.containsKey(key)) {
                int val1 = m1.get(key);
                if (val1 > val2) {
                    m2.put(key,0);
                } else if (val1 < val2) {
                    m2.put(key, Math.abs(val1 - m2.get(key)));
                } else {
                    m2.put(key,0);
                    m1.put(key,0);
                }
            }
        }
        for(Map.Entry<Character,Integer> e:m2.entrySet()){
            result+=e.getValue();
        }
        return result;
    }
}
