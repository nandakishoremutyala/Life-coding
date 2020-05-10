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
        int k = 5;
        int res = kthSmallestCorrection(matrix, k);
        System.out.println(res);
    }

    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        doBacktrack(mat, k, pq, 0, 0);
        System.out.println(pq);
        return pq.peek();
    }

    /**
     * 1  3  11
     * 2  4  6
     */
    private void doBacktrack(int[][] mat, int k, PriorityQueue<Integer> pq, int row, int sum) {
        if (row == mat.length) {
            pq.add(sum);
            if (pq.size() > k)
                pq.poll();
            return;
        }
        for (int i = 0; i < mat[0].length; i++) {
            sum += mat[row][i];
            System.out.println("growing sum: " + sum);
            doBacktrack(mat, k, pq, row + 1, sum);
            sum -= mat[row][i];
            System.out.println("reducing sum: " + sum);
        }
    }

    public int kthSmallestCorrection(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        // take all the elements from the first row and add to the queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int c = 0; c < col; c++) {
            pq.add(mat[0][c]);
            // keep pq size less than or equal to k
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int r = 1; r < row; r++) {
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Comparator.reverseOrder());
            // for each of the element in the queue, take the next row element and add
            // take only those element only upto to k size, so we can save some computation
            for (int i : pq) {
                for (int c = 0; c < col; c++) {
                    nextPq.add(i + mat[r][c]);
                    // keep pq size less than or equal to k
                    if (nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }
            pq = nextPq;
        }
        return pq.poll();
    }
}
