package leetcode.contests.contest_135;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ValidBoomerang {
    ValidBoomerang validBoomerang;

    @BeforeEach
    public void init() {
        validBoomerang = new ValidBoomerang();
    }

    @Test
    public void testFirst() {
        int[][] input = new int[][]{{1, 1}, {2, 2}, {3, 3}};

        boolean result=isBoomerang(input);
        Assertions.assertEquals(false,result);
    }

    @Test
    public void testSecond() {
        int[][] input = new int[][]{{1, 1}, {2, 3}, {3, 2}};
        boolean result=isBoomerang(input);
        Assertions.assertEquals(true,result);
    }

    @Test
    public void testThird() {
        int[][] input = new int[][]{{0, 0}, {0, 2}, {2, 1}};
        boolean result=isBoomerang(input);
        Assertions.assertEquals(true,result);
    }

    @Test
    public void testFourth() {
        int[][] input = new int[][]{{0, 0}, {2, 1}, {2, 1}};
        boolean result=isBoomerang(input);
        Assertions.assertEquals(false,result);
    }

    @Test
    public void testFifth() {
        int[][] input = new int[][]{{0, 0}, {1, 2}, {0, 1}};
        boolean result=isBoomerang(input);
        Assertions.assertEquals(true,result);
    }

    @Test
    public void testSixth() {
        int[][] input = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        boolean result=isBoomerang(input);
        Assertions.assertEquals(true,result);
    }

    @Test
    public void testSeven() {
        int[][] input = new int[][]{{0, 1}, {0, 1}, {2, 1}};
        boolean result=isBoomerang(input);
        Assertions.assertEquals(false,result);
    }

    @Test
    public void testEight() {
        int[][] input = new int[][]{{0, 1}, {1, 0}, {0, 1}};
        boolean result=isBoomerang(input);
        Assertions.assertEquals(false,result);
    }

    @Test
    public void testNine() {
        int[][] input = new int[][]{{0, 1}, {1, 1}, {2, 2}};
        boolean result=isBoomerang(input);
        Assertions.assertEquals(false,result);
    }

    public boolean isBoomerang(int[][] points) {
        if(points.length==2)return true;
        if(points==null ||points.length==0)return true;

        Arrays.sort(points, Comparator.comparingDouble(a -> a[0]));

        int[] m=points[0];
        int j;
        double slope=Integer.MAX_VALUE;
        for (j=1;j<points.length;j++){
            int[] n=points[j];
            if(m[0]!=n[0] || m[1]!=n[1]) {
                if (n[0] - m[0] == 0)
                    slope = Integer.MAX_VALUE;
                else
                    slope = Math.abs(n[1] - m[1]) / Math.abs(n[0] - m[0]);
                break;
            }
        }


        if(j==points.length-1)return false;
        for (int i = j+1; i <points.length ; i++) {
            int[] a=points[0];
            int[] b=points[i];

            double slopetemp=0;
            if(b[0]-a[0]==0)
                slopetemp=Integer.MAX_VALUE;
            else
                slopetemp=Math.abs(b[1]-a[1])/Math.abs(b[0]-a[0]);

            if(slope==slopetemp)
                return false;
        }
        return true;
    }
}
