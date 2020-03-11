package leetcode.contests.contest_177;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.*;

public class LargestMultipleOfThree {
    LargestMultipleOfThree largestMultipleOfThree;

    @BeforeEach
    public void init() {
        largestMultipleOfThree = new LargestMultipleOfThree();
    }

    @Test
    public void firstTest() {
        String result = largestMultipleOfThree.largestMultipleOfThree(new int[]{8, 1, 9});
        Assertions.assertEquals(result, "981");
    }

    @Test
    public void secondTest() {
        String result = largestMultipleOfThree.largestMultipleOfThree(new int[]{8, 6, 7, 1, 0});
        Assertions.assertEquals(result, "8760");
    }

    @Test
    public void thirdTest() {
        String result = largestMultipleOfThree.largestMultipleOfThree(new int[]{1});
        Assertions.assertEquals("", result);
    }

    @Test
    public void fourthTest() {
        String result = largestMultipleOfThree.largestMultipleOfThree(new int[]{0, 0, 0, 0, 0, 0});
        Assertions.assertEquals("0", result);
    }

    public String largestMultipleOfThree(int[] digits) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        int sum = 0;

        Arrays.sort(digits);
        for (int d : digits) {
            sum += d;
            if (d % 3 == 0)
                q1.add(d);
            else if (d % 3 == 1) {
                q2.add(d);
            } else {
                q3.add(d);
            }
        }
        if (sum == 0) return "0";
        List<Integer> result = new ArrayList<>();
        if (sum % 3 == 0) {
            result = buildResultList(q1, q2, q3);
            MasterPrinter.printList(result);
        } else if (sum % 3 == 1) {
            if (!q2.isEmpty()) {
                q2.remove();
            } else {
                if (!q3.isEmpty()) {
                    q3.remove();
                }
                if (!q3.isEmpty()) {
                    q3.remove();
                } else {
                    return "";
                }

            }
            result = buildResultList(q1, q2, q3);
            MasterPrinter.printList(result);
        } else if (sum % 3 == 2) {
            if (!q3.isEmpty()) {
                q3.remove();
            } else {
                if (!q2.isEmpty()) {
                    q2.remove();
                }
                if (!q2.isEmpty()) {
                    q2.remove();
                } else {
                    return "";
                }
            }
            result = buildResultList(q1, q2, q3);
            MasterPrinter.printList(result);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append((int) i);
        }
        return sb.toString();
    }

    private List<Integer> buildResultList(Queue<Integer> q1, Queue<Integer> q2, Queue<Integer> q3) {
        List<Integer> result = new ArrayList<>();
        while (!q1.isEmpty())
            result.add(q1.poll());
        while (!q2.isEmpty())
            result.add(q2.poll());

        while (!q3.isEmpty())
            result.add(q3.poll());

        Collections.sort(result, Collections.reverseOrder());

        return result;
    }
}
