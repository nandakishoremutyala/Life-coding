package data_structure.graph.union_find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//https://leetcode.com/problems/similar-string-groups/
/**For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

 Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

 We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

 Example 1:

 Input: ["tars","rats","arts","star"]
 Output: 2
 Note:

 A.length <= 2000
 A[i].length <= 1000
 A.length * A[i].length <= 20000
 All words in A consist of lowercase letters only.
 All words in A have the same length and are anagrams of each other.
 The judging time limit has been increased for this question.
 *
 * */
public class SimilarStringGroups {
    SimilarStringGroups similarStringGroups;

    class UnionFind {
        int groups;
        int n;
        int[] parents;

        UnionFind(int n) {
            this.n=n;
            this.groups = n;
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                parents[xRoot] = yRoot;
                groups--;
            }
        }
    }

    @BeforeEach
    public void init() {
        similarStringGroups = new SimilarStringGroups();
    }

    @Test
    public void firstTest() {
        String[] input = new String[]{"tars","rats","arts","star"};
        Assertions.assertEquals(2, similarStringGroups.numSimilarGroups(input));
    }

    public int numSimilarGroups(String[] A) {
        final int n = A.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.find(i) == uf.find(j)) continue;
                String str1 = A[i];
                String str2 = A[j];
                System.out.println(str1+"-"+str2);
                if (isSimilar(str1, str2)) uf.union(i, j);
            }
        }
        return uf.groups;
    }

    private boolean isSimilar(String a, String b) {
        int count=0;
        for (int i = 0; i <a.length() ; i++) {
            if(a.charAt(i)!=b.charAt(i) && ++count>2) return false;
        }
        return true;
    }
}
