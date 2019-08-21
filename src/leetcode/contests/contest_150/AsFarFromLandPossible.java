package leetcode.contests.contest_150;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AsFarFromLandPossible {
    AsFarFromLandPossible asFarFromLandPossible;

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @BeforeEach
    public void init() {
        asFarFromLandPossible = new AsFarFromLandPossible();
    }

    @Test
    public void firstTest() {
        int[][] input = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        Assertions.assertEquals(2, asFarFromLandPossible.maxDistance(input));
    }

    @Test
    public void secondTest() {
        int[][] input = new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Assertions.assertEquals(4, asFarFromLandPossible.maxDistance(input));
    }

    public int distance(Point p, Point q) {
        return (Math.abs(p.x - q.x) + Math.abs(p.y - q.y));
    }

    public int maxDistance(int[][] grid) {
        int maxDistance = -1;
        List<Point> lands = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    lands.add(new Point(i, j));
            }
        }

        if (lands.size() == 0) return maxDistance;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int nearestLandDistance = nearestLand(lands, new Point(i, j));
                    if (nearestLandDistance > maxDistance)
                        maxDistance = nearestLandDistance;
                }
            }
        }
        return maxDistance;
    }

    private int nearestLand(List<Point> lands, Point point) {
        int nearest = Integer.MAX_VALUE;
        for (Point land : lands) {
            int dist = distance(land, point);
            if (dist < nearest)
                nearest = dist;
        }
        return nearest;
    }
}
