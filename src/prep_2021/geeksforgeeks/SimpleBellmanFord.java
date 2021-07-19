package prep_2021.geeksforgeeks;

import java.util.Arrays;

public class SimpleBellmanFord {
    static void BellmanFord(int[][] graph, int V, int E, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                if ((distance[graph[j][0]] != Integer.MAX_VALUE)
                        && (distance[graph[j][0]] + graph[j][2]
                        < distance[graph[j][1]])) {
                    distance[graph[j][1]] = distance[graph[j][0]] + graph[j][2];
                }
            }
        }

        // check for negative-weight cycles.
        // The above step guarantees shortest
        // distances if graph doesn't contain
        // negative weight cycle. If we get a
        // shorter path, then there is a cycle.
        for (int i = 0; i < E; i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            int weight = graph[i][2];
            if (distance[x] != Integer.MAX_VALUE &&
                    distance[x] + weight < distance[y])
                System.out.println("Graph contains negative"
                        + " weight cycle");
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + distance[i]);

    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        // Every edge has three values (u, v, w) where
        // the edge is from vertex u to v. And weight
        // of the edge is w.
        int graph[][] = {
                {0, 1, -1},
                {0, 2, 4},
                {1, 2, 3},
                {1, 3, 2},
                {1, 4, 2},
                {3, 2, 5},
                {3, 1, 1},
                {4, 3, -3}};
        BellmanFord(graph, V, E, 0);
    }
}
