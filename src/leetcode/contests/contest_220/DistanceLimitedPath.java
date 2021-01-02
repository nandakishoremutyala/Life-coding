package leetcode.contests.contest_220;

import java.util.Arrays;
import java.util.Comparator;

public class DistanceLimitedPath {
    int[] parent;
    private int find(int i) {
        if (i != parent[i]) parent[i] = find(parent[i]);
        return parent[i];
    }
    private void union(int i, int j) {
        parent[find(i)] = find(j);
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < queries.length; i++)
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};

        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
        parent=new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        boolean[] res = new boolean[queries.length];

        for(int i=0,j=0;i<queries.length;i++){
            while (j<edgeList.length && edgeList[j][2]<queries[i][2]){ // keep doing union until the distance of the query
                // all the edge with query distance will be grouped together
                union(edgeList[j][0], edgeList[j][1]); // add two points/nodes in a single group
                j++;
            }
            res[queries[i][3]]= find(queries[i][0]) == find(queries[i][1]);
        }
        return res;
    }
}
