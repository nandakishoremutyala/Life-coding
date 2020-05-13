package leetcode.contests.contest_188;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinTimeToCollectApples {
    MinTimeToCollectApples minTimeToCollectApples;
    static boolean[] visited;

    @BeforeEach
    public void init() {
        minTimeToCollectApples = new MinTimeToCollectApples();
    }

    @Test
    public void firstTest() {
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
        };
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        int n = 7;
        visited = new boolean[n];
        int minTime = minTimeToCollectApples.minTime(n, edges, hasApple);
        System.out.println(minTime);
    }

    @Test
    public void secondTest() {
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
        };
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, false, true, false);
        int n = 7;
        visited = new boolean[n];
        int minTime = minTimeToCollectApples.minTime(n, edges, hasApple);
        System.out.println(minTime);
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int appleCount = 0;
        for (Boolean b : hasApple) {
            if (b) appleCount++;
        }

        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            tree[start].add(end);
            tree[end].add(start);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        return doBfs(tree, 0, 0, hasApple);

    }

    private int doBfs(List<Integer>[] tree,
                      int cost,
                      int start,
                      List<Boolean> hasApple) {
        int localStep = 0;
        if (visited[start]) return 0;
        visited[start] = true;
        for (int i = 0; i < tree[start].size(); i++) {
            int node = tree[start].get(i);
            localStep += doBfs(tree, 2, node, hasApple);
        }
        if (!hasApple.get(start) && localStep == 0) {
            return 0;
        }
        return cost + localStep;
    }
}
