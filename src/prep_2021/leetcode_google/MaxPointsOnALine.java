package prep_2021.leetcode_google;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    /**
     * Alternate solution: https://www.youtube.com/watch?v=KqZV0XfKQks
     * */
    public static void main(String[] args) {
        maxPoints(new int[][]{{1,1},{2,2},{3,3}});
    }
    public static int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int sameP = 0, max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    sameP++;
                    continue;
                }
                // divide by gcd to reduce the factor in slope
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = y + "/" + x;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            // +1 to include original point
            res = Math.max(res, max + sameP + 1);
        }
        return res;
    }

    private static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
