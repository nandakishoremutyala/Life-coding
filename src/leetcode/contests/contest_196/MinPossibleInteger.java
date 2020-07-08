package leetcode.contests.contest_196;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinPossibleInteger {
    MinPossibleInteger mpi;
    @BeforeEach
    public void init(){
        mpi=new MinPossibleInteger();
    }
    @Test
    public void firstTest(){
        String result = mpi.minInteger("4321",4);
        System.out.println(result);
    }

    @Test
    public void secondTest(){
        String result = mpi.minInteger("100",1);
        System.out.println(result);
    }

    @Test
    public void thirdTest(){
        String result = mpi.minInteger("36789",1000);
        System.out.println(result);
    }

    @Test
    public void fourthTest(){
        String result = mpi.minInteger("9438957234785635408",23);
        System.out.println(result);
    }
    public String minInteger(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        int start = 0;
        while (k >= 0 && start<sb.length()) {
            int swap = findSmallest(sb, start, k);
            char c=sb.charAt(swap);
            sb.deleteCharAt(swap);
            sb.insert(start,c);
            k-=swap;
            start++;
        }
        return sb.toString();
    }

    private int findSmallest(StringBuilder sb, int start, int k) {
        char c = sb.charAt(start);
        int min=Integer.parseInt(String.valueOf(c));
        int pos = start;
        for (int i = start + 1; i < Math.min(start + k+1, sb.length()); i++) {
            if (Integer.parseInt(String.valueOf(sb.charAt(i))) < min) {
                min=Integer.parseInt(String.valueOf(sb.charAt(i)));
                pos = i;
            }
        }
        return pos;
    }
}
