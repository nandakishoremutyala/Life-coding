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

    /**
     * 1. if there is not equal number of bracket in different sign, there is no
     * way to match. so we need to track the diff counter.
     * 2. If diff counter become negative, we need to make it positive and track that
     * how much has been added to make it positive.
     * */
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
