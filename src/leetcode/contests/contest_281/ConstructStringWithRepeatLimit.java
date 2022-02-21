package leetcode.contests.contest_281;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Stack;

public class ConstructStringWithRepeatLimit {
    ConstructStringWithRepeatLimit constructStringWithRepeatLimit;

    @BeforeEach
    public void init() {
        constructStringWithRepeatLimit = new ConstructStringWithRepeatLimit();
    }

    @Test
    public void firstTest() {
        String result= constructStringWithRepeatLimit
                .repeatLimitedString("cczazcc", 3);
        Assertions.assertEquals("zzcccac",result);
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> b - a);
        for (char c : s.toCharArray()) {
            pq.add(c);
        }
        int count = 0;
        char prev = pq.peek();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        // zzzzba
        while (!pq.isEmpty()) {
            char curr = pq.poll();
            if (curr == prev) {
                if (count < repeatLimit) {
                    result.append(curr);
                } else {
                    stack.add(curr);
                }
                count++;
            } else {
                if (stack.isEmpty()) {
                    result.append(curr);
                    prev = curr;
                    count=1;
                } else {
                    result.append(curr);
                    count = 0;
                    while (!stack.isEmpty() && count < repeatLimit) {
                        result.append(stack.pop());
                        count++;
                    }
                }
            }
        }
        return result.toString();
    }
}
