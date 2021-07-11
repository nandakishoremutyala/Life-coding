package prep_2021;

public class UnionFind {

    static class Graph{
         Edge[] edges;
        int V,E;
        public Graph(int V,int E) {
            this.V=V;
            this.edges=new Edge[E];
            for (int i = 0; i <E ; i++) {
                edges[i]=new Edge();
            }
        }
    }
    static class Edge{
        int src,dst;
    }
    private static void isCycle(Graph graph) {
        int[] parent=new int[graph.V];
        for (int i = 0; i <graph.V ; i++) {
            parent[i]=-1;
        }

        for (int i = 0; i <graph.edges.length ; i++) {
            Edge e=graph.edges[i];
            int x=find(parent,e.src);
            int y=find(parent,e.dst);
            if(x==y) {
                System.out.println("cycle detected");
                return;
            }
            union(parent,x,y);
        }
    }

    private static int find(int[] parent, int i) {
       /* if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);*/
        while(parent[i]!=-1){
            i=parent[i];
        }
        return i;
    }
    private static void union(int[] parent, int x, int y){
        parent[x]=y;
    }

    public static void main(String[] args) {

        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dst = 1;

        // add edge 1-2
        graph.edges[1].src = 1;
        graph.edges[1].dst = 2;

         // add edge 0-2
        graph.edges[2].src = 0;
        graph.edges[2].dst = 2;
        isCycle(graph);
    }


}
