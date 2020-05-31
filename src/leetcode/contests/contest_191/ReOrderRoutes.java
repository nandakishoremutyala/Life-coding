package leetcode.contests.contest_191;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ReOrderRoutes {
    ReOrderRoutes reOrderRoutes;
    static int change=0;

    @BeforeEach
    public void init(){
        reOrderRoutes=new ReOrderRoutes();
    }

    @Test
    public void firstTest(){
        int[][] connections=new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n=6;
        int res= reOrderRoutes.minReorder(n,connections);
        System.out.println(res);

    }

    @Test
    public void secondTest(){
        int[][] connections=new int[][]{{1,0},{1,2},{3,2},{3,4}};
        int n=5;
        int res= reOrderRoutes.minReorder(n,connections);
        System.out.println(res);

    }

    @Test
    public void thirdTest(){
        int[][] connections=new int[][]{{1,0},{2,0}};
        int n=3;
        int res= reOrderRoutes.minReorder(n,connections);
        System.out.println(res);

    }

    public int minReorder(int n, int[][] connections) {
        Set<String> pathsOrder=new HashSet<>();
        for(int[] p:connections){
            int a=p[0];
            int b=p[1];
            pathsOrder.add(String.valueOf(a)+"#"+String.valueOf(b));
        }

        List<Integer>[] graph=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }
        buildGraph(graph,connections);
        boolean[] visited=new boolean[n];

        dfs(graph,visited,pathsOrder);
        //System.out.println(change);
        return connections.length-change;
    }

    private void dfs(List<Integer>[] graph, boolean[] visited,Set<String> paths) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        //visited[0]=true;

        while (!queue.isEmpty()){
            int v=queue.poll();
            if(!visited[v]){
                List<Integer> childs=graph[v];
                for(int child:childs){
                    if(!visited[child]){
                        String str=String.valueOf(v)+"#"+String.valueOf(child);
                        if(!paths.contains(str))
                            change++;
                        queue.add(child);
                    }

                }
                visited[v]=true;
            }
        }

    }

    private void buildGraph(List<Integer>[] graph,int[][] con) {
        for(int[] v:con){
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
    }
}
