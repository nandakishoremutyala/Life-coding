package practice.graphs.coloring_connectivity;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphColoring {
    int V;
    LinkedList<Integer>[] adj;

    public GraphColoring(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int x, int y) {
        adj[x].add(y);
        adj[y].add(x);
    }

    public void greedyColoring() {
        int[] result = new int[V];
        Arrays.fill(result, -1);

        boolean[] available = new boolean[V];

        Arrays.fill(available, true);
        result[0] = 0;

        for (int i = 1; i < V; i++) {
            Iterator<Integer> itr = adj[i].iterator();
            while (itr.hasNext()) {
                int item = itr.next();
                if (result[item] != -1) { // If adjacent has been taken care, mark it not to color
                    available[result[item]] = false;
                }
            }

            // find first available color to color the current vertex
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr]) break;
            }
            result[i] = cr;
            Arrays.fill(available, true);
        }
        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " --->  Color "
                    + result[u]);
    }

    public static void main(String[] args) {
        GraphColoring g1 = new GraphColoring(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();

        System.out.println();
        GraphColoring g2 = new GraphColoring(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2 ");
        g2.greedyColoring();
    }
}
