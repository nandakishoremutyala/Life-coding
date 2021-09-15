package others;

public class UnionFindPathCompression {
    int V, E;
    Edge[] edge;

    UnionFindPathCompression(int v, int e) {
        this.V = v;
        this.E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    class Edge {
        int src, dest;
    }

    class Subset {
        int parent;
        int rank;
    }

    public int find(Subset[] subsets, int id) {
        while (subsets[id].parent != id) {
            id = subsets[id].parent;
        }
        return id;
    }

    public void union(Subset[] subsets, int x, int y) {
        int idx = find(subsets, x);
        int idy = find(subsets, y);

        if (subsets[idx].rank <= subsets[idy].rank) {
            subsets[idx].parent = idy;
            subsets[idy].rank += subsets[idx].rank;
        } else {
            subsets[idy].parent = idx;
            subsets[idx].rank += subsets[idy].rank;
        }
    }

    public static void main(String[] args) {
        /* Let us create the following graph
            0
            | \
            | \
            1-----2 */

        int V = 3, E = 3;
        UnionFindPathCompression graph = new UnionFindPathCompression(V, E);

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
            System.out.println("Graph contains cycle");
        else
            System.out.println(
                    "Graph doesn't contain cycle");
    }

    private int isCycle(UnionFindPathCompression graph) {
        int V = graph.V;
        int E = graph.E;

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {

            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        for (int e = 0; e < E; e++) {
            int x = find(subsets, graph.edge[e].src);
            int y = find(subsets, graph.edge[e].dest);
            if (x == y)
                return 1;
            union(subsets, x, y);
        }
        return 0;
    }
}
