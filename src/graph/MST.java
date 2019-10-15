package graph;

import java.util.Arrays;
import java.util.Comparator;

public class MST {
    static class Graph {
        int V;
        int E;
        static Edge[] edge;

        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edge=new Edge[E];
            for (int i = 0; i < E; i++) {
                edge[i] = new Edge();
            }
        }

        public void KruskalMST() {
            Arrays.sort(edge);
            for (Edge e : edge) {
                System.out.println(e.src + "->" + e.dest+"..."+e.weight);
            }

        }
    }

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    public static void main(String[] args) {
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }
}
