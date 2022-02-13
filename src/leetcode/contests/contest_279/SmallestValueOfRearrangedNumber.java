package leetcode.contests.contest_279;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SmallestValueOfRearrangedNumber {
    SmallestValueOfRearrangedNumber smallestValueOfRearrangedNumber;

    @BeforeEach
    public void init() {
        smallestValueOfRearrangedNumber = new SmallestValueOfRearrangedNumber();
    }

    @Test
    public void firstTest() {
        smallestValueOfRearrangedNumber.smallestNumber(3100);
    }

    public long smallestNumber(long num) {
        boolean isNeg = num < 0;
        String s = String.valueOf(num);
        if(s.length()==1) return num;
        StringBuilder zeros = new StringBuilder();
        StringBuilder result = new StringBuilder();
        if (isNeg) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(0);
            char[] c = sb.toString().toCharArray();
            Arrays.sort(c);

            for (int i = c.length - 1; i >= 0; i--) {
                result.append(c[i]);
            }
            result=new StringBuilder("-").append(result);

        } else {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c.length; i++) {
                System.out.println(c[i]);
                if (c[i] == '0') {
                    zeros.append(c[i]);
                } else {
                    sb.append(c[i]);
                }

            }
            result.append(sb.charAt(0));
            result.append(zeros);
            sb.deleteCharAt(0);
            result.append(sb);
            //System.out.println(result.toString());

        }
        return Long.parseLong(result.toString());

    }

}
