package prep_2021.geeksforgeeks.graphs;

public class FloydWarshall {
    // Driver program to test above function
    static final int INF=99999;
    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        FloydWarshall a = new FloydWarshall();

        // Print the solution
        a.floydWarshall(graph);
    }
    int V;
    private void floydWarshall(int[][] graph) {
        V=graph.length;
        int dist[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (k=0; k<V ; k++) {
            for (i = 0; i <V ; i++) {
                for (j = 0; j < V ; j++) {
                    if(dist[i][k]+dist[k][j]<dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
