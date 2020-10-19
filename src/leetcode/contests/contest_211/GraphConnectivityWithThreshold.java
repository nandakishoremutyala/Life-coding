package leetcode.contests.contest_211;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphConnectivityWithThreshold {
    ArrayList[] g;
    GraphConnectivityWithThreshold graphConnectivityWithThreshold;

    @BeforeEach
    public void init() {
        graphConnectivityWithThreshold = new GraphConnectivityWithThreshold();
    }

    @Test
    public void firstTest() {
        int n = 6;
        int threshold = 2;
        int[][] queries = new int[][]{{1, 4}, {2, 5}, {3, 6}};
        graphConnectivityWithThreshold.areConnected(n, threshold, queries);
    }

    @Test
    public void secondTest() {
        int n = 6;
        int threshold = 1;
        int[][] queries = new int[][]{{4, 5}, {3, 4}, {3, 2}, {2, 6}, {1, 3}};
        graphConnectivityWithThreshold.areConnected(n, threshold, queries);
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        g=new ArrayList[n+1];
        List<Boolean> result=new ArrayList<>(n);
        for (int i = 0; i <n+1 ; i++) {
            g[i]=new ArrayList<>();
        }
        if(threshold==0) {
            for (int i = 0; i <queries.length; i++) {
                result.add(true);
            }
            return result;
        }
        buildGraph(n,threshold,g);
        // connected components
        HashSet<Integer> visited = new HashSet();
        int[] cc = new int[n+1];
        for(int i=1; i<=n; i++){
            if(visited.contains(i)) continue;
            dfs(g, visited, cc, i, i);
        }

        for(int[] q: queries){
            int src = q[0];
            int des = q[1];
            if(src==des && src > threshold) result.add(true);
            else if(cc[src] == cc[des]) result.add(true);
            else{
                result.add(false);
            }
        }
        System.out.println(visited);
        return result;
    }

    private void dfs(List<Integer>[] g,
                     HashSet<Integer> visited,
                     int[] cc,
                     int group,
                     int cur) {
        if(visited.contains(cur))return;
        cc[cur]=group; //add element for specific group
        visited.add(cur); // mark as visited
        for(int ne:g[cur]){
            if(visited.contains(ne)) continue;
            cc[ne] = group;
            dfs(g, visited, cc, group, ne);
        }
    }


    private void buildGraph(int n, int threshold, List<Integer>[] g) {
        int t=n/2;
        for(int i=threshold+1;i<t+1;i++){
            //g.add(i,new HashSet<>());

            int increment=1;
            int product=i;
            while (product<=n){
                //g[i].add(product);
                g[product].add(i);
                increment++;
                product=i*increment;
            }
        }
    }

}

