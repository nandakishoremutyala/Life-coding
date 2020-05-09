package leetcode.contests.contest_187;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSumOfAMatrix {
    KthSmallestSumOfAMatrix kthSmallestSumOfAMatrix;

    @BeforeEach
    public void init() {
        kthSmallestSumOfAMatrix = new KthSmallestSumOfAMatrix();
    }

    @Test
    public void firstTest() {
        int[][] matrix = new int[][]{
                {1, 3, 11},
                {2, 4, 6}
        };
        int k=5;
        int res= kthSmallest(matrix,k);
        System.out.println(res);
    }

    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        doBacktrack(mat,k,pq,0,0);
        System.out.println(pq);
        return pq.peek();
    }
  /**
   * 1  3  11
   * 2  4  6
   *
   * */
    private void doBacktrack(int[][] mat, int k, PriorityQueue<Integer> pq, int row, int sum) {
        if(row==mat.length) {
            pq.add(sum);
            if(pq.size()>k)
                pq.poll();
            return;
        }
        for (int i = 0; i <mat[0].length ; i++) {
            sum+=mat[row][i];
            System.out.println("growing sum: "+sum);
            doBacktrack(mat,k,pq,row+1,sum);
            sum-=mat[row][i];
            System.out.println("reducing sum: "+sum);
        }
    }
}
