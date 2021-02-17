package leetcode.contests.contest_228;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinDegreeOfConnectedTrio {
    MinDegreeOfConnectedTrio minDegreeOfConnectedTrio;

    @BeforeEach
    public void init() {
        minDegreeOfConnectedTrio = new MinDegreeOfConnectedTrio();
    }

    @Test
    public void firstTest() {
        int[][] input = new int[][]{{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}};
        int n = 6;
        minDegreeOfConnectedTrio.minTrioDegree(n, input);
    }

    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.compute(u, (k, val) -> val == null ? new HashSet<>() : val).add(v);
            graph.compute(v, (k, val) -> val == null ? new HashSet<>() : val).add(u);
        }

        int degree = Integer.MAX_VALUE;
        for (int[] e : edges) {
            HashSet<Integer> x = graph.get(e[0]);
            HashSet<Integer> y = graph.get(e[1]);
            // check if there is a trio
            for (Integer num : x) {
                if (y.contains(num)) { //it is a trio
                    int total = x.size() + y.size() + graph.get(num).size() - 6;
                    degree = Math.min(total, degree);
                }
            }
        }
        if (degree == Integer.MAX_VALUE) return -1;
        return degree;
    }
}
