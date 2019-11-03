package data_structure.graph;

import java.util.*;

public class PathsFromSourceToDest {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        buildGraph(graph, edges);

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == destination) {
                //destination was not been added since it is the end
                // there was no edge from destination
                if (!graph.containsKey(node))//check path is the end or not
                    continue;
            }
            visited[node] = true;
            // if node is the end but was not the destination, it is not a path
            if (!graph.containsKey(node))   // Check if the current visiting node is at the end of the path
                return false;

            for (int next : graph.get(node)) {
                //there is any loop or not
                if (!visited[next])
                    q.add(next);
                else
                    return false;
            }
        }
        return true;
    }

    private void buildGraph(Map<Integer, List<Integer>> graph, int[][] edges) {
        for (int[] edge : edges) {
            int src = edge[0];
            int des = edge[1];
            graph.compute(src, (k, v) -> v == null ? new ArrayList<>() : v).add(des);
        }
    }

}
