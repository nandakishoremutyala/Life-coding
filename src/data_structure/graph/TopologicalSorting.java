package data_structure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class TopologicalSorting {
    static class Graph {
        int V;
        ArrayList<Integer>[] adjList;

        Graph(int V) {
            this.V = V;
            adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjList[source].add(destination);
        }

        public void topologicalSorting() {
            boolean[] visited=new boolean[V];
            ArrayDeque<Integer> stack=new ArrayDeque<>();
            for (int i = 0; i <V ; i++) {
                if(!visited[i]){
                    ArrayList<Integer> childs=adjList[i];
                    dfs(visited,stack,childs,i);
                    stack.push(i);
                }
            }
            while (!stack.isEmpty()){
                System.out.print(stack.poll()+"->");
            }
        }

        public void dfs(boolean[] visited,ArrayDeque<Integer> stack,ArrayList<Integer> childs,int parent){
            visited[parent]=true;
            for (Integer i:childs){
                if(!visited[i]){
                    dfs(visited,stack,adjList[i],i);
                    stack.push(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEdge(7, 6);
        graph.addEdge(7, 5);
        graph.addEdge(6, 4);
        graph.addEdge(6, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 2);
        graph.addEdge(3, 1);
        graph.addEdge(2, 1);
        graph.addEdge(1, 0);
        graph.topologicalSorting();
    }
}
