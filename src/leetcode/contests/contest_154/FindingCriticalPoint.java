package leetcode.contests.contest_154;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FindingCriticalPoint {
    class Graph {
        int v;
        /**
         * This set will be working as adjacency list.
         */
        HashSet<Integer>[] connections;

        /**
         * Create a data_structure.graph data structure
         */
        Graph(int v) {
            this.v = v;
            connections = new HashSet[v];
            for (int i = 0; i < v; i++) {
                connections[i] = new HashSet<>();
            }
        }

        void addConnection(int u, int v) {
            connections[u].add(v);
            connections[v].add(u);
        }

        void removeConnection(int u, int v) {
            connections[u].remove(v);
            connections[v].remove(u);
        }
    }

    private FindingCriticalPoint findingCriticalPoint;

    private List<List<Integer>> connections;

    @BeforeEach
    public void init() {
        findingCriticalPoint = new FindingCriticalPoint();
        connections=createDummyData();
    }

    private List<List<Integer>> createDummyData() {
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> con1 = new ArrayList<>();
        con1.add(0);
        con1.add(1);
        connections.add(con1);

        List<Integer> con2 = new ArrayList<>();
        con2.add(1);
        con2.add(2);
        connections.add(con2);

        List<Integer> con3 = new ArrayList<>();
        con3.add(2);
        con3.add(0);
        connections.add(con3);

        List<Integer> con4 = new ArrayList<>();
        con4.add(1);
        con4.add(3);
        connections.add(con4);
        return connections;

    }

    @Test
    public void firstTest() {
        Assertions.assertEquals(1,findingCriticalPoint.criticalConnections(4, connections).size());
    }

    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Graph graph = new Graph(n);
        for (List<Integer> connection : connections) {
            graph.addConnection(connection.get(0), connection.get(1));
        }
        System.out.println(graph.connections);
        for (List<Integer> connection : connections) {
            graph.removeConnection(connection.get(0), connection.get(1));
            int numberOfConnectedComponents = getConnectedComponents(graph, n);
            System.out.println("Number of components: "+numberOfConnectedComponents);
            if (numberOfConnectedComponents > 1)
                result.add(connection);
            graph.addConnection(connection.get(0), connection.get(1));
        }
        return result;

    }

    private int getConnectedComponents(Graph graph, int n) {
        int numComponents = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                queue.add(i);
                numComponents++;
            }
            while (!queue.isEmpty()){
                Integer node=queue.poll();
                if(!visited[node]){
                    HashSet<Integer> sets = graph.connections[node];
                    Iterator it = sets.iterator();
                    while (it.hasNext()) {
                        int data= (int) it.next();
                        if(!visited[data])
                            queue.add(data);
                    }
                }
                visited[node]=true;
            }
        }
        return numComponents;
    }
}
