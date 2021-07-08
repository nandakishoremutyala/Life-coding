package prep_2021;

import java.sql.Array;
import java.util.*;

public class CourseScheduleII {
    /**
     * [a,b] means b has to be taken first. b will child
     */
    public static void main(String[] args) {
        findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        findOrder(2,new int[][]{{1,0}});
        findOrder(2,new int[][]{{0,1}});
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] course : prerequisites) {
            int b = course[1];
            int a = course[0];
            graph[a].add(b);
        }
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> visited=new HashSet<>();
        Deque<Integer> stack= new ArrayDeque<>() ;
        for (int i = 0; i <graph.length ; i++) {
            List<Integer> node = graph[i];
            if (node.size() == 0 && !visited.contains(i)) {
                result.add(i);
                visited.add(i);
            } else if (!visited.contains(i)) {
                stack.push(i);
                doDfs(graph,i,visited,stack,result);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        for (int x : result)
            res[i++] = x;
        return res;
    }

    private static void doDfs(ArrayList<Integer>[] graph,
                              int node,
                              HashSet<Integer> visited,
                              Deque<Integer> stack,
                              List<Integer> result) {
        while (!stack.isEmpty()){
            Integer root=stack.pop();
            List<Integer> children=graph[root];
            for (int c : children) {
                if(!visited.contains(c)){
                    stack.push(c);
                    doDfs(graph,c,visited,stack,result);
                }
            }
            visited.add(root);
            result.add(root);
        }
    }
}
