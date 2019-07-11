package pramp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BracketMatch {
    BracketMatch mBracketMatch;

    @BeforeEach
    public void init() {
        mBracketMatch = new BracketMatch();
    }

    @Test
    public void firstTest() {
        String input = "(())";
        int actual = mBracketMatch.bracketMatch(input);
        Assertions.assertEquals(0, actual);
    }

    @Test
    public void secondTest() {
        String input = "())(";
        int actual = mBracketMatch.bracketMatch(input);
        Assertions.assertEquals(2, actual);
    }

    public int bracketMatch(String text) {
        int diffCounter = 0;
        int ans = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(')
                diffCounter++;
            else if (c == ')')
                diffCounter--;
            if (diffCounter < 0) {
                diffCounter++;
                ans++;
            }
        }
        return diffCounter + ans;

    }
}
