package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParenthesis {

    public static void main(String[] args) {
        LongestValidParenthesis longestValidParenthesis = new LongestValidParenthesis();
        int result = longestValidParenthesis.longestValidParentheses("(()");
        System.out.println(result);
    }

    Deque<Integer> stack = new ArrayDeque();
    public int longestValidParentheses(String s) {
        int maxans = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
