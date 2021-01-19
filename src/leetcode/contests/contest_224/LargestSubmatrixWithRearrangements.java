package leetcode.contests.contest_224;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.Arrays;
import java.util.Collections;

public class LargestSubmatrixWithRearrangements {
    LargestSubmatrixWithRearrangements largestSubmatrixWithRearrangements;
    @BeforeEach
    public void init(){
        largestSubmatrixWithRearrangements=new LargestSubmatrixWithRearrangements();
    }
    @Test
    public void firstTest(){
        int[][] matrix=new int[][]{
                {0,0,1},
                {1,1,1},
                {1,0,1}
        };
        int res= largestSubmatrixWithRearrangements.largestSubmatrix(matrix);
        System.out.println(res);
    }

    @Test
    public void secondTest(){
        int[][] matrix=new int[][]{
                {0,0,1},
                {1,1,1},
                {1,0,1}
        };
        int res= largestSubmatrixWithRearrangements.largestSubmatrix(matrix);
        System.out.println(res);
    }
    public int largestSubmatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j]=matrix[i-1][j]+1;
            }
        }

        int result=0;
        for (int i = 0; i <matrix.length ; i++) {
            int[] row=matrix[i];
            MasterPrinter.printArray(row);
            System.out.println("sorted");
            Arrays.sort(row);
            result=Math.max(result,compute(row));

        }
        return result;
    }

    private int compute(int[] row) {
        int len=row.length-1;
        int max=0;
        int itr=len;
        while (itr>=0){
            max=Math.max(max,Math.min(row[len],row[itr])*(len-itr+1));
            itr--;
        }
        return max;
    }
}
