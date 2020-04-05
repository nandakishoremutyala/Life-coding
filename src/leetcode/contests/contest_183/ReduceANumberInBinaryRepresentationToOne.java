package leetcode.contests.contest_183;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class ReduceANumberInBinaryRepresentationToOne {
    ReduceANumberInBinaryRepresentationToOne reduceANumberInBinaryRepresentationToOne;

    @BeforeEach
    public void init() {
        reduceANumberInBinaryRepresentationToOne = new ReduceANumberInBinaryRepresentationToOne();
    }

    @Test
    public void firstTest() {
        int steps = reduceANumberInBinaryRepresentationToOne.numSteps("1101");
        Assertions.assertEquals(6, steps);
    }

    @Test
    public void secondTest() {
        int steps = reduceANumberInBinaryRepresentationToOne.numSteps("10");
        Assertions.assertEquals(1, steps);
    }

    @Test
    public void thirdTest() {
        int steps = reduceANumberInBinaryRepresentationToOne.numSteps("1111110011101010110011100100101110010100101110111010111110110010");
        Assertions.assertEquals(0, steps);
    }

    @Test
    public void fourthTest() {
        int steps = reduceANumberInBinaryRepresentationToOne.numSteps("1");
        Assertions.assertEquals(0, steps);
    }

    @Test
    public void fifthTest() {
        int steps = reduceANumberInBinaryRepresentationToOne.numSteps("11000");
        Assertions.assertEquals(0, steps);
    }

    public int numSteps(String s) {
        int step = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() != 0 && sb.charAt(sb.length() - 1) == '0' && sb.charAt(0) == '1') {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
            step++;
        }
        if (sb.length() == 0) return step;
        long num = Long.parseLong(sb.toString(), 2);

        if(num==0) return step;
        while (num != 1) {
            String binary = Long.toBinaryString(num);
            if (binary.charAt(binary.length() - 1) != '0') {
                num += 1;
                step++;
            }
            num = num >> 1;
            step++;
        }
        return step;

    }
}
