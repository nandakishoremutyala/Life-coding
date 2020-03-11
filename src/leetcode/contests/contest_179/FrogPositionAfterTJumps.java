package leetcode.contests.contest_179;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FrogPositionAfterTJumps {
    FrogPositionAfterTJumps frogPositionAfterTJumps;

    @BeforeEach
    public void init() {
        frogPositionAfterTJumps = new FrogPositionAfterTJumps();
    }

    @Test
    public void firstTest() {
        int target = 4;
        int n = 7;
        int[][] edges = new int[][]{
                {1, 2},
                {1, 3},
                {1, 7},
                {2, 4},
                {2, 6},
                {3, 5}
        };
        int t = 2;
        double pro = frogPositionAfterTJumps.frogPosition(n, edges, t, target);
        System.out.println(pro);
        Assertions.assertEquals(0.16666666666666666,pro);

    }

    @Test
    public void secondTest() {
        int target = 7;
        int n = 7;
        int[][] edges = new int[][]{
                {1, 2},
                {1, 3},
                {1, 7},
                {2, 4},
                {2, 6},
                {3, 5}
        };
        int t = 2;
        double pro = frogPositionAfterTJumps.frogPosition(n, edges, t, target);
        System.out.println(pro);
        Assertions.assertEquals(0.3333333333333333,pro);
    }

    @Test
    public void thirdTest() {
        int target = 6;
        int n = 7;
        int[][] edges = new int[][]{
                {1, 2},
                {1, 3},
                {1, 7},
                {2, 4},
                {2, 6},
                {3, 5}
        };
        int t = 2;
        double pro = frogPositionAfterTJumps.frogPosition(n, edges, t, target);
        System.out.println(pro);
        Assertions.assertEquals(0.16666666666666666,pro);
    }

    List<Integer>[] v;
    double[] pro;
    boolean[] visited;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        v = new ArrayList[n + 1];
        pro = new double[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(pro, Double.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            v[edge[0]].add(edge[1]);
        }

        pro[1] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        bfs(pro, visited, target, queue);
        return pro[target];
    }

    public void bfs(double[] pro, boolean[] visited, int target, LinkedList<Integer> queue) {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]) continue;
            for (Integer child : v[node]) {
                if (!visited[child]) {
                    queue.add(child);
                    int size = v[node].size();
                    double p = pro[node];
                    double newP = (p / size);
                    System.out.println(newP);
                    pro[child] = newP;
                    if (child == target) return;
                }
            }
            visited[node] = true;
        }

    }

}
