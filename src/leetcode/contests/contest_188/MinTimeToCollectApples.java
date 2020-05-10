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
    private static int cost = 0;
    static boolean[] visited;
    int found=0;

    @BeforeEach
    public void init() {
        minTimeToCollectApples = new MinTimeToCollectApples();
        found=0;
    }

    @Test
    public void firstTest() {
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
        };
        List<Boolean> hasApple =Arrays.asList(false,false,true,false,true,true,false);
        int n=7;
        visited=new boolean[n];
        int minTime = minTimeToCollectApples.minTime(n,edges,hasApple);
        System.out.println(minTime);
    }

    @Test
    public void secondTest() {
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
        };
        List<Boolean> hasApple =Arrays.asList(false,false,true,false,false,true,false);
        int n=7;
        visited=new boolean[n];
        int minTime = minTimeToCollectApples.minTime(n,edges,hasApple);
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

        ArrayDeque stack=new ArrayDeque();
        stack.add(0);
        doBfs(0, tree, appleCount, hasApple, stack);
        return cost;
    }

    private void doBfs(int start,
                       List<Integer>[] tree,
                       int appleCount,
                       List<Boolean> hasApple,
                       ArrayDeque<Integer> stack) {
        if (!stack.isEmpty() && appleCount != found) {
            int data = stack.poll();
            if (hasApple.get(data)) found++;
            if (!visited[data] && appleCount != found) {
                visited[data]=true;

                for (int i = 0; i <tree[data].size() ; i++) {
                    int node=tree[data].get(i);
                    if(!visited[node]){
                        stack.add(tree[data].get(i));
                        cost++;
                        doBfs(start,tree,appleCount,hasApple,stack);
                        cost++;
                    }
                }
            }

        }

    }
}
