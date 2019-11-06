package data_structure.graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * https://leetcode.com/problems/redundant-connection/discuss/277026/DFS-Java-Solution-With-Explanation
 * */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ret = null;
        int n = edges.length;
        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 1001; i++)
            g.add(new HashSet<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (dfs(u, v, 0, g)) {
                ret = edges[i];
            } else {
                g.get(u).add(v);
                g.get(v).add(u);
            }
        }
        return ret;
    }

    private boolean dfs(int u, int v, int pre, List<Set<Integer>> g) {
        if (u == v) return true;
        for (int w : g.get(u)) {
            if (w == pre) continue;
            boolean ret = dfs(w, v, u, g);
            if (ret) return true;
        }
        return false;
    }
}
