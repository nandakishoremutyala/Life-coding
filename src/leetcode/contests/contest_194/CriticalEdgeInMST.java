package leetcode.contests.contest_194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalEdgeInMST {
    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            this.parent=new int[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
            }
        }

        int find(int i){
            while (parent[i]!=i){
                i=parent[i];
            }
            return i;
        }

        boolean union(int x, int y){
           int px=find(x);
           int py=find(y);
           if(px==py) return false;
           parent[px]=py;
           return true;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        // sort the edges based on weight
        Arrays.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));
        int mstWeight = buildAndGetMSTHeight(n, edges, -1, -1);
        for (int i = 0; i < edges.length; i++) {
            if (mstWeight < buildAndGetMSTHeight(n, edges, i, -1)) {
                criticalEdges.add(edges[i][3]);
            }
            else if (mstWeight == buildAndGetMSTHeight(n, edges, -1, i)) {
                pseudoCriticalEdges.add(edges[i][3]);
            }
        }
        return Arrays.asList(criticalEdges, pseudoCriticalEdges);

    }

    private int buildAndGetMSTHeight(int n, int[][] edges, int block, int preEdge) {
        // block and preEdge is accept and edge or not
        int weight = 0;
        UnionFind uf = new UnionFind(n);
        if (preEdge != -1) {
            weight += edges[preEdge][2];
            uf.union(edges[preEdge][0], edges[preEdge][1]);
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == block || i == preEdge) {
                continue;
            }
            if (uf.union(edges[i][0], edges[i][1])) {
                weight += edges[i][2];
            }
        }
        // This part is to verify that all the nodes has been added into MST or not
        for (int i = 0; i < n; i++) {
            if (uf.find(i) != uf.find(0)) {
                return Integer.MAX_VALUE;
            }
        }
        return weight;
    }
}
