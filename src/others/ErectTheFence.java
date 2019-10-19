package others;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ErectTheFence {
    ErectTheFence erectTheFence;

    @BeforeEach
    public void init() {
        erectTheFence = new ErectTheFence();
    }

    @Test
    public void firstTest() {
        int[][] input = new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
        int[][] result= erectTheFence.outerTrees(input);
    }

    public int[][] outerTrees(int[][] points) {
        Point[] pnts = new Point[points.length];
        PriorityQueue<Point> pqTop = new PriorityQueue<>((p1, p2) -> {
            if (p2.y > p1.y)
                return 1;
            else if (p2.y < p1.y)
                return -1;
            else return 0;
        });

        PriorityQueue<Point> pqDown = new PriorityQueue<>((p1, p2) -> {
            if (p2.y > p1.y)
                return -1;
            else if (p2.y < p1.y)
                return 1;
            else return 0;
        });

        PriorityQueue<Point> pqRight = new PriorityQueue<>((p1, p2) -> {
            if (p2.x > p1.x)
                return 1;
            else if (p2.x < p1.x)
                return -1;
            else return 0;
        });

        PriorityQueue<Point> pqLeft = new PriorityQueue<>((p1, p2) -> {
            if (p2.x > p1.x)
                return -1;
            else if (p2.x < p1.x)
                return 1;
            else return 0;
        });

        for (int i = 0; i < points.length; i++) {
            pnts[i] = new Point(points[i][0], points[i][1]);
        }

        for (Point point : pnts) {
            pqTop.add(point);
            pqDown.add(point);
            pqRight.add(point);
            pqLeft.add(point);
        }

        Point pTop = pqTop.poll();
        Point pRight = pqRight.poll();
        Point pDown = pqDown.poll();
        Point pLeft = pqLeft.poll();

        double slopeTopRight = dist(pTop, pRight);
        double slopeRightDown = dist(pRight, pDown);
        double slopeDownLeft = dist(pDown, pLeft);
        double slopeLeftTop = dist(pLeft, pTop);

        ArrayList<Point> resList = new ArrayList<>();

        for (Point p : pnts) {
            double s1 = dist(p, pTop) + dist(p, pRight);
            double s2 = dist(p, pRight) + dist(p, pDown);
            double s3 = dist(p, pDown) + dist(p, pLeft);
            double s4 = dist(p, pLeft) + dist(p, pTop);

            if (s1 == slopeTopRight || s2 == slopeRightDown || s3 == slopeDownLeft || s4 == slopeLeftTop)
                resList.add(p);
        }

        System.out.println(resList);
        int[][] result = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = new int[]{resList.get(i).x, resList.get(i).y};
        }
        return result;
    }

    private double dist(Point p1, Point p2) {
        double dis = Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
        return dis;
    }
}
