package leetcode.contests.contest_133;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MaxSum_1031 {
    MaxSum_1031 maxSum;

    @BeforeEach
    public void init() {
        maxSum = new MaxSum_1031();
    }

    @Test
    public void testThird() {
        int[] in = new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int L = 4;
        int M = 3;
        int sum = maxSum.maxSumTwoNoOverlap(in, L, M);
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        //int[] temp=new int[A.length];
        int total=0;
        int maxL=0;
        int curMaxl=0;

        for (int i = 0; i <L ; i++) {
            curMaxl+=A[i];
        }
        int start=0;
        Set<Integer> maxLSet=new HashSet<>();
        while (L<A.length){
             curMaxl=curMaxl-A[start]+A[L];
            if(curMaxl>maxL) {
                maxL = curMaxl;
                maxLSet.clear();
                maxLSet.add(L);
            }
            else  if(curMaxl==maxL)
                maxLSet.add(L);
            System.out.println(maxL);
            L++;start++;
        }
        System.out.println(maxL);
        total+=maxL;

        int[] maxMArray=new int[A.length];
        int maxM=0;
        int curMaxM=0;
        for (int i = 0; i <L ; i++) {
            curMaxM+=A[i];
        }
       
        findMaxRange();
        return total;

    }

    private void findMaxRange() {
    }
}
