package leetcode.contests.contest_177;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

public class ClosestDivisors {
    ClosestDivisors closestDivisors;

    @BeforeEach
    public void init() {
        closestDivisors = new ClosestDivisors();
    }

    @Test
    public void firstTest() {
        int[] res= closestDivisors.closestDivisors(8);
        Assertions.assertArrayEquals(new int[]{3,3},res);

    }
    @Test
    public void secondTest() {
        int[] res= closestDivisors.closestDivisors(123);
        Assertions.assertArrayEquals(new int[]{5,25},res);

    }
    @Test
    public void thirdTest() {
        int[] res= closestDivisors.closestDivisors(999);
        Assertions.assertArrayEquals(new int[]{25,40},res);

    }
    @Test
    public void fourthTest() {
        int[] res= closestDivisors.closestDivisors(1);
        Assertions.assertArrayEquals(new int[]{1,2},res);

    }

    public int[] closestDivisors(int num) {
        int[] d1 = divisors(num + 1);
        int[] d2 =  divisors(num + 2);

        if((d1[1]-d1[0])<(d2[1]-d2[0])) return d1;
        return d2;
    }


    public int[] divisors(int n) {
        int high = n / 2+1;
        int low = 1;
        int mul = Integer.MAX_VALUE;
        int minDiff=Integer.MAX_VALUE;
        int[] result=new int[]{0,Integer.MAX_VALUE};
        while (low <= high) {
            mul = high * low;
            if (mul > n) high--;
            if (mul < n) low++;
            if(mul==n){
                int diff=high-low;
                if(diff<minDiff){
                    result[0]=low;
                    result[1]=high;
                    minDiff=diff;
                }
                high--;
            }
        }
        return result;
    }
}
