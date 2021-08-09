package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    MinCostToConnectAllPoints minCostToConnectAllPoints;
    @BeforeEach
    public void init(){
        minCostToConnectAllPoints=new MinCostToConnectAllPoints();
    }
    @Test
    public void firstTest(){
        minCostToConnectAllPoints.minCostConnectPoints(new int[][]{
                {0,0},{2,2},{3,10},{5,2},{7,0}
        });
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n-1;++i)
            for(int j=i+1;j<n;++j){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                pq.offer(new int[]{dist,i,j});
            }
        int res=0;
        Union un = new Union(n);
        while (!un.united() && !pq.isEmpty()){
            int[] edge=pq.poll();
            if(un.union(edge[1],edge[2]))
                res+=edge[0];
        }

       return res;
    }
    private class Union{
        int components;
        int[] component;
        Union(int n){
            components=n;
            component=new int[n];
            for (int i = 0; i <n ; i++) {
                component[i]=i;
            }
        }
        int find(int a){
            if(component[a]!=a){
                component[a]= find(component[a]);
            }
            return component[a];
        }
        boolean union(int a, int b){
            int x=find(a);
            int y=find(b);
            if(x==y) return false;
            components--;
            component[x]=b;
            return true;
        }
        boolean united(){
            return components==1;
        }
    }
}
