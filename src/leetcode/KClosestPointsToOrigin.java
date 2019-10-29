package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] output = kClosestPointsToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        HashMap<Double, List<Integer>> map = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            Double distance = Math.sqrt((p[1] - 0) * (p[1] - 0) + (p[0] - 0) * (p[0] - 0));
            map.compute(distance, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
            pq.add(distance);
        }
        System.out.println(map);
        int[][] result = new int[K][2];
        int i = 0;
        while (!pq.isEmpty() && i < K) {
            List<Integer> pos = map.get(pq.poll());
            for (int j : pos) {
                result[i++] = points[j];
            }
        }
        return result;
    }
}
