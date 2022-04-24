package leetcode.contests.contest_290;

import java.util.HashSet;
import java.util.Set;

public class CountLatticePoints {
    public static void main(String[] args) {
        CountLatticePoints cp = new CountLatticePoints();
        int count= cp.countLatticePoints(new int[][]{{2, 2, 2}, {3, 4, 1}});
        System.out.println(count);
    }

    public int countLatticePoints(int[][] circles) {
        Set<String> points = new HashSet<String>();
        for (int[] circle : circles) {

            int x = circle[0];
            int y = circle[1];
            int r = circle[2];

            int lx = x - r; //Left x
            int rx = x + r; // right x
            int by = y - r; // bottom y
            int uy = y + r; // top y

            for (int m = lx; m <= rx; m++) {
                for (int n = uy; n >= by; n--) {
                    if (insideCircle(m, n, circle)) {
                        points.add(m + "-" + n);
                    }
                }
            }
        }
        return points.size();
    }

    public boolean insideCircle(int x, int y, int[] circle) {
        int xCenter = circle[0];
        int yCenter = circle[1];
        int r = circle[2];
        return dist((double) x, (double) y, (double) xCenter, (double) yCenter) <= r * r;
    }

    public double dist(double x1, double y1, double x2, double y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
