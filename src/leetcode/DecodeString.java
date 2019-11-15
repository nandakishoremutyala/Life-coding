package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String res = decodeString.decodeString("3[a]2[bc]");
        System.out.println(res);
    }

    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> values = new Stack<>();
        values.push(new StringBuilder());
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // computing the numbser value
            if (ch >= '0' && ch <= '9')
                num = num * 10 + (ch - '0');
                // when parenthesis starts
            else if (ch == '[') {
                values.push(new StringBuilder());
                counts.push(num);
                num = 0; //reseting the number
            }
            // whenever you find the closed parenthesis, you need to compute
            else if (ch == ']') {
                // take the last stringbuilder and repeat the number of times
                String toAppend = values.pop().toString();
                int count = counts.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    sb.append(toAppend);
                }
                // push  it back
                values.push(values.pop().append(sb.toString()));
            } else {
                values.peek().append(ch);
            }
        }
        return values.pop().toString();
    }
}
