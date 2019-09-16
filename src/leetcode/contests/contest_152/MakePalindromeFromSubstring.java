package leetcode.contests.contest_152;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MakePalindromeFromSubstring {
    MakePalindromeFromSubstring makePalindromeFromSubstring;

    @BeforeEach
    public void init() {
        makePalindromeFromSubstring = new MakePalindromeFromSubstring();
    }

    @Test
    public void firstTest() {
        String input = "abcda";
        int[][] queries = new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> result = makePalindromeFromSubstring.canMakePaliQueries(input, queries);
        Boolean[] truth = new Boolean[]{true, false, false, true, true};
        Assertions.assertArrayEquals(truth, result.toArray());
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            Set<Character> set = new HashSet<>();
            int left = query[0];
            int right = query[1] ;
            int replace = query[2];
            if (replace >= 13) result.add(true);
            else {
                for (int i = left; i <= right; i++) {
                    if (!set.add(s.charAt(i))) set.remove(s.charAt(i));
                }
                boolean output= replace >= set.size() / 2;
                result.add(output);
            }
        }
        return result;
    }
}
