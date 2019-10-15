package graph.union_find;

public class UF {
    static int[] parent;

    static class Graph {
        int V;
        int E;
        Edge edge[]; // /collection of all edges

        public int isCycle(Graph graph) {
            for (int i = 0; i < graph.E; i++) {
                int xRoot = find(parent, graph.edge[i].src);
                int yRoot = find(parent, graph.edge[i].dest);
                if (xRoot == yRoot)
                    return 1;
                union(parent, xRoot, yRoot);
            }
            return 0;
        }

        private int find(int[] parent, int src) {
            if (parent[src] == -1)
                return src;
            return find(parent, parent[src]);
        }

        private void union(int[] parent, int x, int y) {
            int xRoot=find(parent,x);
            int yRoot=find(parent,y);
            parent[xRoot]=yRoot;

        }

        class Edge {
            int src, dest;
        }

        Graph(int v, int e) {
            this.E = e;
            this.V = v;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }
    }

    public static void main(String[] args) {

          /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 3;
        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = -1;
        }

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

        if (graph.isCycle(graph) == 1)
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }
}
