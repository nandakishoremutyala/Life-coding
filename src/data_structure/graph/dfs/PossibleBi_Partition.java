package data_structure.graph.dfs;

import java.util.*;

/**
 * https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBi_Partition {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    //0-> node is not colored
    //1 -> colored in group 1
    //-1-> colored in group 2
    public boolean possibleBipartition(int N, int[][] dislikes) {
        buildGraph(graph, N, dislikes);
        int[] colors = new int[N+1];
        for (int node = 1; node <= N; node++) {
            if (colors[node] == 0 && !dfs(graph, node, 1, colors))
                return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int node, int color, int[] colors) {
        if (colors[node] != 0) {
            //conflict case
            if (colors[node] == color) return true;
            else return false;
        }
        //color the node
        colors[node] = color;
        // no child/ person does not dislike anyone
        if (graph.get(node) == null) return true;
        for (int p : graph.get(node)) {
            // if there is any conflict in the down stream it has to return false
            if (!dfs(graph, p, -color, colors)) return false;
        }
        return true;
    }


    private void buildGraph(Map<Integer, List<Integer>> graph, int n, int[][] dislikes) {
        for (int[] dislike : dislikes) {
            int x = dislike[0];
            int y = dislike[1];
            graph.compute(x, (k, v) -> v == null ? new ArrayList<>() : v).add(y);
            graph.compute(y, (k, v) -> v == null ? new ArrayList<>() : v).add(x);
        }
    }
}
