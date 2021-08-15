package effort_2021;

import java.util.*;

public class KclosestPointToOrigin {
    public static void main(String[] args) {
        KclosestPointToOrigin kclosestPointToOrigin = new KclosestPointToOrigin();
        kclosestPointToOrigin.kClosest(new int[][]{
                {1, 3}, {-2, 2}
        }, 1);
    }

    public int[][] kClosest(int[][] points, int k) {
        TreeMap<Double, List<int[]>> map = new TreeMap<>();

        for (int point = 0; point < points.length; point++) {
            int[] coordinates = points[point];
            double distance = distanceBetweenOriginAndPoint(coordinates);
            map.compute(distance, (key, val) -> val == null ? new ArrayList<>() : val).add(coordinates);
        }

        int[][] result = new int[k][2];
        Iterator<Map.Entry<Double, List<int[]>>> itr = map.entrySet().iterator();
        int count = 0;
        while (itr.hasNext() && count < k) {
            Map.Entry<Double, List<int[]>> entry = itr.next();
            List<int[]> data = entry.getValue();
            for (int[] coord : data) {
                result[count++] = coord;
                if (count == k) break;
            }
        }
        return result;
    }

    private double distanceBetweenOriginAndPoint(int[] p) {
        int x1 = 0;
        int y1 = 0;

        int x2 = p[0];
        int y2 = p[1];
        double res = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
        return Math.sqrt(res);
    }
}
