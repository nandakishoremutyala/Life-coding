package data_structure.graph.union_find;

public class UFPathCompression {
    static Subset[] subsets;
    static class Graph {
        int V, E;
        Edge[] edge;

        Graph(int v, int e) {
            this.E = e;
            this.V = v;
            edge = new Edge[e];
            for (int i = 0; i < e; i++) {
                edge[i] = new Edge();
            }
        }

        public int isCycle(Graph graph) {
            for (int i = 0; i < graph.edge.length; i++) {
                int src = graph.edge[i].src;
                int dest = graph.edge[i].dest;
                int sRoot = find(subsets, src);
                int dRoot = find(subsets, dest);
                if (sRoot == dRoot)
                    return 1;
                union(src, dest);
            }
            return 0;
        }

        private void union(int src, int dest) {
            int sRoot = find(subsets, src);
            int dRoot = find(subsets, dest);
            // add biggest ranked node to the smallest rank node
            if (subsets[sRoot].rank < subsets[dRoot].rank) {
                subsets[dRoot].parent = sRoot;
            } else if (subsets[dRoot].rank < subsets[sRoot].rank) {
                subsets[sRoot].parent = dRoot;
            } else {
                // add any node to other and update the rank
                subsets[sRoot].parent = dRoot;
                subsets[dRoot].rank++;
            }
        }

        private int find(Subset[] subsets, int src) {
            if (subsets[src].parent != src)
                subsets[src].parent = find(subsets, subsets[src].parent);
            return subsets[src].parent;
        }
    }

    static class Edge {
        int src;
        int dest;

        Edge() {
        }
    }

    static class Subset {
        int parent;
        int rank;
    }

    public static void main(String[] args) {
        /* Let us create the following data_structure.graph
        0
        | \
        | \
        1-----2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        subsets = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        if (graph.isCycle(graph) == 1)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
