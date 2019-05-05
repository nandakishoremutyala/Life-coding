package leetcode.contests.contest_135;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        double slope=Double.MAX_VALUE;
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j <points.length ; j++) {
                int[] p=points[i];
                int[] q=points[j];
                if(p[0]!=q[0] ||p[1]!=q[1]){
                    double cSlope;
                    if(q[0]-p[0]==0){
                        cSlope=Double.MAX_VALUE;
                    }else{
                        cSlope=Math.abs(q[1]-p[1])/Math.abs(q[0]-p[0]);
                    }
                    if(slope==Double.MAX_VALUE && cSlope!=Double.MAX_VALUE){
                        slope=cSlope;
                    }
                    if(slope!=cSlope){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
