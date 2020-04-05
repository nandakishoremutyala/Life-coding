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
        Assertions.assertEquals(89, steps);
    }

    @Test
    public void fourthTest() {
        int steps = reduceANumberInBinaryRepresentationToOne.numSteps("1");
        Assertions.assertEquals(0, steps);
    }

    @Test
    public void fifthTest() {
        int steps = reduceANumberInBinaryRepresentationToOne.numSteps("11000");
        Assertions.assertEquals(6, steps);
    }

    public int numSteps(String s) {
        int step = 0; int carry=0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length()-1; i >0 ; --i) {
            // if it is odd, add 1 with it and update step by 2
            // what makes it odd, when last digit is 1
            if(sb.charAt(i)-'0'+carry==1){
                carry=1;
                step+=2;
            }else{
                step+=1;
            }
        }
        return step+carry;
    }
}
