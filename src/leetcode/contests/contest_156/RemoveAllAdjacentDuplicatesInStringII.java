package leetcode.contests.contest_156;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;


public class RemoveAllAdjacentDuplicatesInStringII {
    RemoveAllAdjacentDuplicatesInStringII removeAllAdjacentDuplicatesInStringII;

    class Data{
        char c;
        int count;
        Data( int count,char c){
            this.c=c;
            this.count=count;
        }
    }
    @BeforeEach
    public void init() {
        removeAllAdjacentDuplicatesInStringII = new RemoveAllAdjacentDuplicatesInStringII();
    }

    @Test
    public void firstTest() {
        String s = "abcd";
        int k = 2;
        String result = removeAllAdjacentDuplicatesInStringII.removeDuplicates(s, k);
        Assertions.assertEquals("abcd", result);
    }

    @Test
    public void secondTest() {
        String s = "deeedbbcccbdaa";
        int k = 3;
        String result = removeAllAdjacentDuplicatesInStringII.removeDuplicates(s, k);
        Assertions.assertEquals("aa", result);
    }

    @Test
    public void thirdTest() {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        String result = removeAllAdjacentDuplicatesInStringII.removeDuplicates(s, k);
        Assertions.assertEquals("ps", result);
    }

    public String removeDuplicates(String s, int k) {
        Deque<Data> stack = new ArrayDeque<>();
        stack.push(new Data(0,'#'));

        for (char c : s.toCharArray()) {
            if (stack.peek().c != c) {
                stack.push(new Data(1, c));
            } else {
                int count = stack.peek().count + 1;
                stack.pop();
                if (count != k)
                    stack.push(new Data(count, c));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            for (int i = 0; i < stack.peek().count; i++) {
                stringBuilder.append(stack.peek().c);
            }
            stack.pop();
        }
        return stringBuilder.reverse().toString();
    }
}
