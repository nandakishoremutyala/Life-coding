package data_structure.trees;

import java.util.*;

public class MinHeightTrees {
    public static void main(String[] args) {
        MinHeightTrees minHeightTrees = new MinHeightTrees();
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        minHeightTrees.findMinHeightTrees(4, edges);
    }

    List<Integer>[] graph;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph = new ArrayList[n];
        int[] degree = new int[n];
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        buildGraph(degree, graph, edges);
        System.out.println(degree);

        Queue<Integer> myQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0)
                return res;
            else if (degree[i] == 1) {
                myQueue.offer(i);
            }
        }

        while (!myQueue.isEmpty()) {
            res = new ArrayList<>();
            int count = myQueue.size();

            for (int i = 0; i < count; i++) {
                int cur = myQueue.poll();
                res.add(cur);
                degree[cur]--;
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if (degree[next] == 0) continue;
                    degree[next]--;
                    if (degree[next] == 1) {
                        myQueue.offer(next);
                    }
                    //degree[next]--;
                }
            }
        }
        return res;
    }

    private void buildGraph(int[] degree, List<Integer>[] g, int[][] edges) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
            degree[a] += 1;
            degree[b] += 1;
        }
    }
}
