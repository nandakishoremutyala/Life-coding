package leetcode.contests.contest_197;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PathWithMaxProbability {

    PathWithMaxProbability pathWithMaxProbability;

    @BeforeEach
    public void init() {
        pathWithMaxProbability = new PathWithMaxProbability();
    }

    @Test
    public void firstTest() {
        pathWithMaxProbability = new PathWithMaxProbability();
        double res = pathWithMaxProbability.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2);
        System.out.println(res);
    }

    @Test
    public void secondTest() {
        pathWithMaxProbability = new PathWithMaxProbability();
        double res = pathWithMaxProbability.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.3}, 0, 2);
        System.out.println(res);
    }

    class Vertex {
        int v;

        double prob;

        public Vertex(int v, double value) {
            this.v = v;
            this.prob = value;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        Map<Integer, List<double[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];

            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(new double[]{edge[1], succProb[i]});
            map.get(edge[1]).add(new double[]{edge[0], succProb[i]});
        }

        double[] probs = new double[n];  // best prob so far for each node
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(start, 1.0));

        while (!queue.isEmpty()){
            Vertex v=queue.poll();
            int c=v.v;
            double prob=v.prob;

            for(double[] child:map.getOrDefault(c,new ArrayList<>())){
                if(probs[(int)child[0]]>=prob*child[1]) continue;
                queue.add(new Vertex((int) child[0], prob * child[1]));
                probs[(int) child[0]] = prob * child[1];
            }
        }

        return probs[end];
    }
}
