package leetcode.contests.contest_154;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ReverseSubstringBetweenEachPairOfParenthesis {
    ReverseSubstringBetweenEachPairOfParenthesis reverseSubstringBetweenEachPairOfParenthesis;

    @BeforeEach
    public void init() {
        reverseSubstringBetweenEachPairOfParenthesis = new ReverseSubstringBetweenEachPairOfParenthesis();
    }

    @Test
    public void firstTest() {
        String input = "(u(love)i)";
        String output = reverseSubstringBetweenEachPairOfParenthesis.reverseParentheses(input);
        Assertions.assertEquals("iloveu", output);
    }

    @Test
    public void secondTest() {
        String input = "(abcd)";
        String output = reverseSubstringBetweenEachPairOfParenthesis.reverseParentheses(input);
        Assertions.assertEquals("dcba", output);
    }

    @Test
    public void thirdTest() {
        String input = "(ed(et(oc))el)";
        String output = reverseSubstringBetweenEachPairOfParenthesis.reverseParentheses(input);
        Assertions.assertEquals("leetcode", output);
    }

    @Test
    public void fourthTest() {
        String input = "a(bcdefghijkl(mno)p)q";
        String output = reverseSubstringBetweenEachPairOfParenthesis.reverseParentheses(input);
        Assertions.assertEquals("apmnolkjihgfedcbq", output);
    }

    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    char cFromQueue = stack.pollLast();
                    if (cFromQueue == '(')
                        break;
                    sb.append(cFromQueue);
                }
                addAllIntoQueue(stack, sb);
            } else {
                stack.add(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst());
        }
        return result.toString();
    }

    private void addAllIntoQueue(Deque<Character> stack, StringBuilder sb) {
        for (char c : sb.toString().toCharArray()) {
            stack.add(c);
        }
    }
}
