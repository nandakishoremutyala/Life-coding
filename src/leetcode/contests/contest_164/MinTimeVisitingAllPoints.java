package leetcode.contests.contest_164;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinTimeVisitingAllPoints {
    MinTimeVisitingAllPoints minTimeVisitingAllPoints;

    @BeforeEach
    public void init() {
        minTimeVisitingAllPoints = new MinTimeVisitingAllPoints();
    }

    @Test
    public void firstTest() {
        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        int minDistance= minTimeVisitingAllPoints.minTimeToVisitAllPoints(points);
        Assertions.assertEquals(7,minDistance);
    }

    @Test
    public void secondTest() {
        int[][] points = new int[][]{ {3, 2}, {-2, 2}};
        int minDistance= minTimeVisitingAllPoints.minTimeToVisitAllPoints(points);
        Assertions.assertEquals(5,minDistance);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int min = 0;
        int[] cur = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            min += findDistance(cur, point);
            cur = point;
        }
        return min;
    }

    private int findDistance(int[] cur, int[] point) {
        int min = 0;
        int x1 = cur[0];
        int x2 = point[0];
        int y1 = cur[1];
        int y2 = point[1];
        // compute diagonal
        int hor = Math.abs(x2 - x1);
        int ver = Math.abs(y2 - y1);
        int dist = Math.min(hor, ver);
        if (hor > ver)
            min +=(hor-dist);
        else
            min+=(ver-dist);
        return (min+=dist);
    }
}
