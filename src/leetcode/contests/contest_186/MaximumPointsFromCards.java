package leetcode.contests.contest_186;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.Arrays;

public class MaximumPointsFromCards {
    MaximumPointsFromCards maximumPointsFromCards;

    @BeforeEach
    public void init() {
        maximumPointsFromCards = new MaximumPointsFromCards();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int res = maximumPointsFromCards.maxScore(input, k);
        Assertions.assertEquals(12, res);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{2,2,2};
        int k = 2;
        int res = maximumPointsFromCards.maxScore(input, k);
        Assertions.assertEquals(4, res);
    }

    @Test
    public void thirdTest() {
        int[] input = new int[]{9,7,7,9,7,7,9};
        int k = 7;
        int res = maximumPointsFromCards.maxScore(input, k);
        Assertions.assertEquals(55, res);
    }

    @Test
    public void fourthTest() {
        int[] input = new int[]{1,100,1};
        int k = 1;
        int res = maximumPointsFromCards.maxScore(input, k);
        Assertions.assertEquals(1, res);
    }

    @Test
    public void fifthTest() {
        int[] input = new int[]{1,79,80,1,1,1,200,1};
        int k = 3;
        int res = maximumPointsFromCards.maxScore(input, k);
        Assertions.assertEquals(202, res);
    }

    @Test
    public void sixthTest() {
        int[] input = new int[]{100,40,17,9,73,75};
        int k = 3;
        int res = maximumPointsFromCards.maxScore(input, k);
        Assertions.assertEquals(248, res);
    }

    public static void preCompute(int arr[], int n, int pre[])
    {
        pre[0] = arr[0];
        for (int i = 1; i < n; i++)
            pre[i] = arr[i] + pre[i - 1];
    }

    // Returns sum of elements in arr[i..j]
    // It is assumed that i <= j
    public static int rangeSum(int i, int j, int pre[])
    {
        if (i == 0)
            return pre[j];

        return pre[j] - pre[i - 1];
    }


    public int maxScore(int[] cardPoints, int k) {
        int left=0;
        int right=0;
        int first=cardPoints[0];
        int last=cardPoints[cardPoints.length-1];

        int leftSum=0;
        int[] pre=new int[cardPoints.length];
        preCompute(cardPoints,cardPoints.length,pre);
        int tk=k-1;
        if(tk==0) return Math.max(first,last);
        for (int i = 1; i <= cardPoints.length-tk; i++) {
            int ranSum=rangeSum(i,i+tk-1,pre);
            left=Math.max(left,ranSum);
        }

        System.out.println(left);
        for (int i = 0; i < cardPoints.length-1-tk; i++) {
            right=Math.max(leftSum,rangeSum(i,i+tk-1,pre));
        }
        return Math.max(first+left,last+right)%1_000_000_007;
    }
}
