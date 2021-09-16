package advance_algos;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphColoring {
    int V;
    List<Integer>[] adj;

    GraphColoring(int v) {
        this.V = v;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
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

    private void greedyColoring() {
        int[] colors = new int[V]; // number of color has been used
        // each element is nth color
        Arrays.fill(colors, -1);

        colors[0] = 0;

        for (int i = 1; i < V; i++) {
            boolean[] availableColors = new boolean[V];
            Arrays.fill(availableColors, true);

            List<Integer> children = adj[i];
            for (int child : children) {
                if (colors[child] != -1) { // those are colored already
                    availableColors[colors[child]] = false; // nth color is not available to use
                }
            }
            for (int j = 0; j < V; j++) {
                if (availableColors[j]) {
                    colors[i]=j;
                    break;
                }
            }
        }

        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " --->  Color "
                    + colors[u]);
        MasterPrinter.printArray(colors);
    }
}
