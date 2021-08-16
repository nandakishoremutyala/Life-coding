package effort_2021;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        LongestValidParenthesis longestValidParenthesis = new LongestValidParenthesis();
        //longestValidParenthesis.longestValidParentheses(")()())");

        //longestValidParenthesis.longestValidParentheses(")(");
        longestValidParenthesis.longestValidParentheses("(())(");
    }

    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty()){
                    stack.push(i);
                    max = Math.max(max, i);
                }
                else {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        max = Math.max(max, i - stack.peek() - 1);
                        stack.push(i);
                    }
                }

            } else {
                if (!stack.isEmpty()) {
                    max = Math.max(max, (i - stack.peek() - 1));
                } else {
                    max = Math.max(max, i );
                }
                stack.push(i);
            }
        }
        if (!stack.isEmpty())
            max = Math.max(max, s.length() - stack.peek() - 1);
        if (stack.isEmpty())
            max = s.length();
        return max;
    }
}
