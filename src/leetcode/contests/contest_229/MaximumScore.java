package leetcode.contests.contest_229;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MaximumScore {
    MaximumScore maximumScore;
    @BeforeEach
    public void init(){
        maximumScore=new MaximumScore();
    }
    @Test
    public void firstTest(){
        maximumScore.maximumScore(new int[]{1,2,3},new int[]{3,2,1});
    }
    @Test
    public void secondTest(){
        maximumScore.maximumScore(new int[]{-5,-3,-3,-2,7,1},new int[]{-10,-5,3,4,6});
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int n : nums) {
            numbers.add(n);
        }
        Collections.sort(numbers);

        LinkedList<Integer> mults = new LinkedList<>();
        for (int m : multipliers) {
            mults.add(m);
        }
        Collections.sort(mults);
        int total = 0;
        while (!numbers.isEmpty() && !mults.isEmpty()) {
            int sN = numbers.getFirst();
            int sM = mults.getFirst();
            int x = sM * sN;

            int lN = numbers.getLast();
            int lM = mults.getLast();
            int y = lM * lN;

            if (x >= y) {
                total += x;
                numbers.removeFirst();
                mults.removeFirst();
            } else {
                total += y;
                numbers.removeLast();
                mults.removeLast();
            }

        }
        System.out.println(total);
        return total;
    }
}
