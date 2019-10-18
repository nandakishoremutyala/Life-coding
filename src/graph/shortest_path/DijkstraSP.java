package graph.shortest_path;

import java.util.ArrayList;
import java.util.List;

public class DijkstraSP {
    int[] pathto;

    class Edge {
        int src;
        int dst;
        int distance;

        public Edge(int src, int dst, int distance) {
            this.src = src;
            this.dst = dst;
            this.distance = distance;
        }
    }

    static class Graph {
        int V;
        int E;
        List<Integer>[] adjList;

        public Graph(int v) {
            this.V = v;
           // this.E = e;
            this.adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[0] = new ArrayList<>();
            }
        }

        public void addEdge(int src, int dst) {
            adjList[src].add(dst);
            adjList[dst].add(src);
        }
    }

    public static void main(String[] args) {
        Graph graph=new Graph(4);

    }

}
