package leetcode.contests.contest_245;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MaxNumberOfRemovalCharacters {
    MaxNumberOfRemovalCharacters maxNumberOfRemovalCharacters;

    @BeforeEach
    public void init() {
        maxNumberOfRemovalCharacters = new MaxNumberOfRemovalCharacters();
    }

    @Test
    public void firstTest() {
        int x = maxNumberOfRemovalCharacters.maximumRemovals("abcacb", "ab", new int[]{3, 1, 0});
        System.out.println(x);
    }

    @Test
    public void secondTest() {

    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int max = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < removable.length; i++) {
            int pos = removable[i];
            sb.replace(pos,pos+1,"-");
            if (isSubsequence( p,sb.toString(), p.length(),sb.length()))
                max = i+1;
            else
                return max;
        }
        return max;
    }


    boolean isSubsequence(String str1, String str2,
                          int m, int n)
    {
        // Base Cases
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        // If last characters of two strings are matching
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubsequence(str1, str2, m - 1, n - 1);

        // If last characters are not matching
        return isSubsequence(str1, str2, m, n - 1);
    }
}
