package data_structure.graph.bfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

public class MinimumHeightTree {
    MinimumHeightTree mht;
    List<Integer>[] g;

    @BeforeEach
    public void init() {
        mht = new MinimumHeightTree();
    }


    @Test
    public void firstTest() {
        int[][] edges = new int[][]{
                {1, 0}, {1, 2}, {1, 3}
        };
        int n = 4;
        mht.findMinHeightTrees(n,edges);
        System.out.println(g);
        Assertions.assertEquals(2, 2);
    }

    @Test
    public void secondTest() {
        int[][] edges = new int[][]{
                {3,0},{3,1},{3,2},{3,4},{5,4}
        };
        int n = 6;
        mht.findMinHeightTrees(n,edges);
        System.out.println(g);
        Assertions.assertEquals(2, 2);
    }


    @Test
    public void thirdTest() {
        int[][] edges = new int[][]{
        };
        int n = 1;
        mht.findMinHeightTrees(n,edges);
        System.out.println(g);
        Assertions.assertEquals(2, 2);
    }

    @Test
    public void fourthTest() {
        int[][] edges = new int[][]{
                {0,1}
        };
        int n = 2;
        mht.findMinHeightTrees(n,edges);
        System.out.println(g);
        Assertions.assertEquals(2, 2);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        g = new ArrayList[n];
        g = buildGraph(g, edges, n);
        int[] height = new int[n];

        Queue<Integer> q;
        for (int i = 0; i < n; i++) {
            q = new LinkedList<>();
            q.add(i);
            int h = findMinHeight(i, q,0,new boolean[n],height);
            System.out.println("node: "+i);
            System.out.println("height: "+h);
            height[i]=h;
        }

        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap();
        for(int i=0;i<height.length;i++){
            map.compute(height[i],(k,v)->v==null?new ArrayList<>():v).add(i);
        }
        List<Integer> res=map.entrySet().iterator().next().getValue();
        return res;
    }

    private int findMinHeight(int root, Queue<Integer> q, int len, boolean[] visited, int[] height) {
        while (!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int r=q.poll();
                visited[r]=true;
                for(int node:g[r]){
                    if(!visited[node])
                        q.add(node);
                }
            }
            len+=1;
        }
        return len-1;
    }


    private List<Integer>[] buildGraph(List<Integer>[] g, int[][] edges, int n) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        return g;
    }

}
