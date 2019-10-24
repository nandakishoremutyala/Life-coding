package data_structure.graph.union_find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
