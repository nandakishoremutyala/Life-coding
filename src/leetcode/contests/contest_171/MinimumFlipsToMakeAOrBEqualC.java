package leetcode.contests.contest_171;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinimumFlipsToMakeAOrBEqualC {
    MinimumFlipsToMakeAOrBEqualC minimumFlipsToMakeAOrBEqualC;

    @BeforeEach
    public void init() {
        this.minimumFlipsToMakeAOrBEqualC = new MinimumFlipsToMakeAOrBEqualC();
    }

    @Test
    public void firstTest() throws Exception {
        int result= minimumFlipsToMakeAOrBEqualC.minFlips(2, 6, 5);
        Assertions.assertEquals(3,result);
    }

    @Test
    public void secondTest() throws Exception {
        int result= minimumFlipsToMakeAOrBEqualC.minFlips(4, 2, 7);
        Assertions.assertEquals(1,result);
    }

    @Test
    public void fourthTest() throws Exception {
        int result= minimumFlipsToMakeAOrBEqualC.minFlips(7, 7, 7);
        Assertions.assertEquals(0,result);
    }

    @Test
    public void thirdTest() throws Exception {
        int result= minimumFlipsToMakeAOrBEqualC.minFlips(1, 2, 3);
        Assertions.assertEquals(0,result);
    }

    public int minFlips(int a, int b, int c) {
        if((a | b)==c) return 0;
        char[] aBits = Integer.toBinaryString(a).toCharArray();
        char[] bBits = Integer.toBinaryString(b).toCharArray();
        char[] cBits = Integer.toBinaryString(c).toCharArray();
        int maxLen = Math.max(cBits.length, Math.max(aBits.length, bBits.length));

        char[] aa = new char[maxLen];
        Arrays.fill(aa,'0');
        fillUpBuffer(aa, aBits, maxLen);

        char[] bb = new char[maxLen];
        Arrays.fill(bb,'0');
        fillUpBuffer(bb, bBits, maxLen);

        char[] cc = new char[maxLen];
        Arrays.fill(cc,'0');
        fillUpBuffer(cc, cBits, maxLen);

        int count=0;
        int res=0;
        while(count<maxLen){
            int x= aa[count];
            int y=bb[count];
            int z=cc[count];
            if((x|y)==z){
                if(x==49 && y==49){
                    res++;
                }
            }else if((x|y)!=z){
                if(x==49 && y==49){
                    res+=2;
                }else{
                    res++;
                }
            }
            count++;
        }
        return res;
    }

    private void fillUpBuffer(char[] aa, char[] aBits, int len) {
        int i = aBits.length-1;
        len-=1;
        while (len >= 0 && i>=0) {
            aa[len] = aBits[i];
            len--;
            i--;
        }
    }
}
