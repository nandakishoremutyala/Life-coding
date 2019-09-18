package leetcode.contests.contest_154;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MaximumNumberOfBalloons {
    MaximumNumberOfBalloons maximumNumberOfBalloons;

    @BeforeEach
    public void init() {
        maximumNumberOfBalloons = new MaximumNumberOfBalloons();
    }

    @Test
    public void firstTest() {
        String inputText = "nlaebolko";
        Assertions.assertEquals(1, maximumNumberOfBalloons.maxNumberOfBalloons(inputText));
    }

    @Test
    public void secondTest() {
        String inputText = "loonbalxballpoon";
        Assertions.assertEquals(2, maximumNumberOfBalloons.maxNumberOfBalloons(inputText));
    }

    @Test
    public void thirdTest() {
        String inputText = "leetcode";
        Assertions.assertEquals(0, maximumNumberOfBalloons.maxNumberOfBalloons(inputText));
    }


    @Test
    public void fourthTest() {
        String inputText = "hpitp";
        Assertions.assertEquals(0, maximumNumberOfBalloons.maxNumberOfBalloons(inputText));
    }

    public int maxNumberOfBalloons(String text) {
        Set<Character> balloons = new HashSet<>();
        for (char c : "balloon".toCharArray()) {
            balloons.add(c);
        }
        HashMap<Character, Integer> characterCounter = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (balloons.contains(c))
                characterCounter.compute(c, (k, v) -> v == null ? 1 : (v + 1));
        }
        characterCounter.computeIfPresent('l', (k, v) -> v / 2);
        characterCounter.computeIfPresent('o', (k, v) -> v / 2);
        if (characterCounter.size() < balloons.size())
            return 0;
        return Collections.min(characterCounter.values());
    }
}
