package data_structure.graph.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseScheduleII {
    List<Integer>[] g;

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        courseScheduleII.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        g = new ArrayList[numCourses];
        buildGraph(numCourses, g, prerequisites);
        boolean[] visited = new boolean[numCourses+1];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[numCourses])
                dfs(i, g, visited, stack);
        }
        int[] res=new int[numCourses];
        int i=0;
        while (!stack.isEmpty())
            res[i++]=stack.pop();
        return res;

    }

    private void dfs(int root, List<Integer>[] g, boolean[] visited, Deque<Integer> stack) {
        if (visited[root]) return;
        visited[root] = true;
        List<Integer> childs = g[root];
        for (int child : childs) {
            if (!visited[child])
                dfs(child, g, visited, stack);
        }
        stack.add(root);
    }

    private void buildGraph(int degree, List<Integer>[] g, int[][] edges) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
        }
    }
}
