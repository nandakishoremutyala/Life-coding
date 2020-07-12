package leetcode.contests.contest_197;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class NumberOfGoodPairs {
    NumberOfGoodPairs numberOfGoodPairs;
    @BeforeEach
    public void init(){
        numberOfGoodPairs=new NumberOfGoodPairs();
    }

    @Test
    public void firstTest(){
        int result =numberOfGoodPairs.numIdenticalPairs(new int[]{1,2,3,1,1,3});
        System.out.println(result);
    }
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, TreeSet<Integer>> numberToPosition = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numberToPosition.compute(nums[i], (k, v) -> v == null ? new TreeSet<>() : v).add(i);
        }

        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            TreeSet<Integer> values = numberToPosition.get(n);
            if (values.size() > 1) {
                values.remove(i);
                pairs+=values.size();
            }
        }

        return pairs;
    }
}
