package effort_2021;

import java.util.*;

public class DikjstraShortestPathWithPQ {
    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    int[] dist;
    Set<Integer> visited;
    PriorityQueue<Node> pq;
    List<List<Node>> graph;
    int V;

    public DikjstraShortestPathWithPQ(int v) {
        this.V=v;
        this.pq=new PriorityQueue<>(V, Comparator.comparingInt(a -> a.cost));
        dist=new int[V];
        visited = new HashSet<>();
    }

    public void algo(List<List<Node> > graph, int src){
        this.graph=graph;
        for (int i = 0; i < V; i++) {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        pq.add(new Node(src,0));
        // Get the lowest cost node and run bfs on it
        while(!pq.isEmpty() && visited.size()<V){
            int u=pq.poll().v;
            visited.add(u);
            bfs(u);
        }
    }

    private void bfs(int u) {
        for(int i=0;i<graph.get(u).size();i++){
            Node n=graph.get(u).get(i);
            if(!visited.contains(n)){
                int nCost= n.cost+dist[u];
                if(nCost<dist[n.v]){
                    dist[n.v]=nCost;
                }
                pq.add(new Node(n.v,dist[n.cost]));
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        int source = 0;
        // adjacency list representation of graph
        List<List<Node> > adj_list = new ArrayList<List<Node> >();
        // Initialize adjacency list for every node in the graph
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj_list.add(item);
        }


        // Input graph edges
        adj_list.get(0).add(new Node(1, 5));
        adj_list.get(0).add(new Node(2, 3));
        adj_list.get(0).add(new Node(3, 2));
        adj_list.get(0).add(new Node(4, 3));
        adj_list.get(0).add(new Node(5, 3));
        adj_list.get(2).add(new Node(1, 2));
        adj_list.get(2).add(new Node(3, 3));
        // call Dijkstra's algo method
        DikjstraShortestPathWithPQ dpq = new DikjstraShortestPathWithPQ(V);
        dpq.algo(adj_list, source);

        // Print the shortest path from source node to all the nodes
        System.out.println("The shorted path from source node to other nodes:");
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " \t\t " + i + " \t\t "  + dpq.dist[i]);
    }
}
