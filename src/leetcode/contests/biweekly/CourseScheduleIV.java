package leetcode.contests.biweekly;

import leetcode.CourseSchedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleIV {
    CourseScheduleIV courseScheduleIV;
    static boolean r;
    static List<Set<Integer>> cache=new ArrayList<>();
    @BeforeEach
    public void init(){
        courseScheduleIV=new CourseScheduleIV();
    }

    @Test
    public void firstTest(){
        int n=2;
        int[][] pre=new int[][]{{1,0}};
        int[][] queries=new int[][]{{0,1},{1,0}};
        List<Boolean> result = courseScheduleIV.checkIfPrerequisite(n,pre,queries);
        MasterPrinter.printList(result);
    }

    @Test
    public void fifthTest(){
        int n=5;
        int[][] pre=new int[][]{{0,1},{1,2},{2,3},{3,4}};
        int[][] queries=new int[][]{{0,4},{4,0},{1,3},{3,0}};
        List<Boolean> result = courseScheduleIV.checkIfPrerequisite(n,pre,queries);
        MasterPrinter.printList(result);
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph=new ArrayList[n];
        buildGraph(graph,prerequisites);
        System.out.println(graph);

        for (int i = 0; i <n ; i++) {
            cache.add(new HashSet<>());
        }
        List<Boolean> result =new ArrayList<>();

        for(int[] query:queries){
            int p=query[0];
            int c=query[1];

            if(cache.get(p).contains(c))
                result.add(true);
            else{
                r=false;
                updateCache(cache,graph,p,c);
                System.out.println(r);
                result.add(r);
            }

        }

        return result;
    }

    private void updateCache(List<Set<Integer>> cache, List<Integer>[] graph, int p, int c) {
        for(Integer arr:graph[p]){
            if(arr==c){
                cache.get(p).add(c);
                r=true;
            }else{
                cache.get(p).add(arr);
                updateCache(cache,graph,arr,c);
            }

        }
        cache.get(p).addAll(cache.get(c));

    }

    public void buildGraph(List<Integer>[] g, int[][] pre){
        for(int i=0;i<g.length;i++){
            g[i]=new ArrayList<>();
        }

        for(int[] c:pre){
            int parent=c[0];
            int child=c[1];
            g[parent].add(child);
        }

    }
}
