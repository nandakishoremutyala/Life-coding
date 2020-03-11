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

    @Test
    public void fourthTest() {
        int target = 2;
        int n = 3;
        int[][] edges = new int[][]{
                {2, 1},
                {3, 2}
        };
        int t = 1;
        double pro = frogPositionAfterTJumps.frogPosition(n, edges, t, target);
        System.out.println(pro);
        Assertions.assertEquals(1.0,pro);
    }

    List<Integer>[] v;
    double[] pro;
    boolean[] visited;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
            graph[e[1] - 1].add(e[0] - 1);
        }
        boolean[] visited = new boolean[n]; visited[0] = true;
        double[] prob = new double[n]; prob[0] = 1f;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        while (!q.isEmpty() && t-- > 0) {
            for (int size = q.size(); size > 0; size--) {
                int u = q.poll(), nextVerticesCount = 0;
                for (int v : graph[u]) if (!visited[v]) nextVerticesCount++;
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                        prob[v] = prob[u] / nextVerticesCount;
                    }
                }
                if (nextVerticesCount > 0) prob[u] = 0; // frog don't stay vertex u, he keeps going to the next vertex
            }
        }
        return prob[target - 1];
    }
}
