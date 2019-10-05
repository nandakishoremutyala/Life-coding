package leetcode.contests.contest_156;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInStringII {
    RemoveAllAdjacentDuplicatesInStringII removeAllAdjacentDuplicatesInStringII;

    class Data {
        char c;
        int count;

        Data(char c, int count) {
            this.c = c;
            this.count = count;
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
        LinkedList<Data> counter = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (counter.size()==0) {
                counter.add(new Data(c, 1));
            } else {
                if (counter.getLast().c == c) {
                    Data d = new Data(c, counter.getLast().count + 1);
                    counter.remove(counter.getLast());
                    counter.add(d);
                } else {
                    counter.add(new Data(c, 1));
                }
            }

            if (counter.getLast().count == k) {
                sb.delete(i - k+1, i+1);
                counter.removeLast();
                i=i-k;
            }
        }
        return sb.toString();
    }

}
