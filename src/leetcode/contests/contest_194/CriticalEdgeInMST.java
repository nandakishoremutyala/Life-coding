package leetcode.contests.contest_194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CriticalEdgeInMST {
    CriticalEdgeInMST criticalEdgeInMST;
    @BeforeEach
    public void init(){
        criticalEdgeInMST=new CriticalEdgeInMST();
    }
    @Test
    public void firstTest(){
        criticalEdgeInMST.findCriticalAndPseudoCriticalEdges(1,null);
    }
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    class subset {
        int parent;
        int rank;
    }

    class Graph {
        int V;
        Edge[] edges;
        int E;

        subset[] subsets = new subset[V];

        Graph(int v, int e) {
            this.E = e;
            this.V = v;
            edges = new Edge[e];


            for (int i = 0; i < e; i++) {
                edges[i] = new Edge();
            }


            for (int i = 0; i < V; ++i)
                subsets[i] = new subset();

            // Create V subsets with single elements
            for (int j = 0; j < V; j++) {
                subsets[v].parent = j;
                subsets[v].rank = 0;
            }
        }

        void buildGraph(int[][] edges) {
            for (int i = 0; i < edges.length; i++) {
                int[] e = edges[i];
                this.edges[i].src = e[0];
                this.edges[i].dest = e[1];
                this.edges[i].weight = e[2];
            }
        }

        int find(int i){
            if(subsets[i].parent!=i){
                subsets[i].parent= find(subsets[i].parent);
            }
            return subsets[i].parent;
        }

        void union(int x, int y){
            int xroot=find(x);
            int yroot=find(y);

            if(subsets[xroot].rank<subsets[y].rank){
                subsets[xroot].parent=yroot;
            }else if(subsets[xroot].rank>subsets[y].rank){
                subsets[yroot].parent=xroot;
            }else{
                subsets[yroot].parent=xroot;
                subsets[xroot].rank++;
            }
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Graph g=new Graph(n,edges.length);
        g.buildGraph(edges);

        int i=0;
        int e=0;
        Arrays.sort(g.edges);
        Edge[] result=new Edge[e];
        while(e<g.V-1){
            Edge nextEdge=g.edges[i++];
            int x=g.find(nextEdge.src);
            int y=g.find(nextEdge.dest);
            if(x!=y){
                result[e++] = nextEdge;
                g.union( x, y);
            }
        }

        for (Edge ed:result
             ) {
            System.out.println(ed.src+'-'+ed.dest);
        }
        return null;

    }
}
