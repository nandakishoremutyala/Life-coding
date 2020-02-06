package leetcode.contests.contest_173;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestNumberNeighborsThresholdDistance {
    SmallestNumberNeighborsThresholdDistance smallestNumberNeighborsThresholdDistance;

    private class Edge {
        int src;
        int des;
        int dist;

        public Edge(int src, int des, int dist) {
            this.src = src;
            this.des = des;
            this.dist = dist;
        }
    }

    @BeforeEach
    public void init() {
        smallestNumberNeighborsThresholdDistance = new SmallestNumberNeighborsThresholdDistance();
    }

    @Test
    public void firstTest() {
        int[][] edges = new int[][]{
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };
        int threshold = 4;
        int n = 4;
        int result =smallestNumberNeighborsThresholdDistance.findTheCity(n,edges,threshold);
        Assertions.assertEquals(3,result);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Edge>[] edgeList = new List[n];

        for (int i = 0; i < edges.length; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int src = e[0];
            int des = e[1];
            int dist = e[2];
            Edge edge = new Edge(src, des, dist);
            Edge edge1 = new Edge(des, src, dist);
            edgeList[src].add(edge);
            edgeList[des].add(edge1);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited=new boolean[n];
            visited[i]=true;
            int node= dfs(edgeList,i,0,distanceThreshold,new LinkedList<>(),visited);
            System.out.println(node);
        }
        return 0;
    }

    public int dfs(List<Edge>[] edges,
                   int start,
                   int distance,
                   int threshold,
                   Queue<Integer> queue,
                   boolean[] visited) {
        if (distance == threshold)
            return queue.size();
        if (distance > threshold) return queue.size() - 1;

        queue.add(start);
        for(Edge e:edges[start]){
            if(!visited[e.des]){
                visited[e.des]=true;
                dfs(edges,e.des,distance+e.dist,threshold,queue,visited);
            }
        }
        queue.remove();
        return queue.size();
    }
}
