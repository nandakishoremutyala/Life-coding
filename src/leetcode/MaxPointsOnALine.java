package leetcode;

import javafx.util.Pair;

import java.awt.*;
import java.util.HashMap;

public class MaxPointsOnALine {
    Point [] points;
    int n;
    HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
    int horisontal_lines;

    public Pair<Integer, Integer> add_line(int i, int j, int count, int duplicates) {
    /*
    Add a line passing through i and j points.
    Update max number of points on a line containing point i.
    Update a number of duplicates of i point.
    */
        // rewrite points as coordinates
        int x1 = points[i].x;
        int y1 = points[i].y;
        int x2 = points[j].x;
        int y2 = points[j].y;
        // add a duplicate point
        if ((x1 == x2) && (y1 == y2))
            duplicates++;
            // add a horisontal line : y = const
        else if (y1 == y2) {
            horisontal_lines += 1;
            count = Math.max(horisontal_lines, count);
        }
        // add a line : x = slope * y + c
        // only slope is needed for a hash-map
        // since we always start from the same point
        else {
            double slope = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(lines.get(slope), count);
        }
        return new Pair(count, duplicates);
    }

    public int max_points_on_a_line_containing_point_i(int i) {
    /*
    Compute the max number of points
    for a line containing point i.
    */
        // init lines passing through point i
        lines.clear();
        horisontal_lines = 1;
        // One starts with just one point on a line : point i.
        int count = 1;
        // There is no duplicates of a point i so far.
        int duplicates = 0;

        // Compute lines passing through point i (fixed)
        // and point j (interation).
        // Update in a loop the number of points on a line
        // and the number of duplicates of point i.
        for (int j = i + 1; j < n; j++) {
            Pair<Integer, Integer> p = add_line(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }
        return count + duplicates;
    }

    public int maxPoints(Point[] points) {
        this.points = points;
        // If the number of points is less than 3
        // they are all on the same line.
        n = points.length;
        if (n < 3)
            return n;

        int max_count = 1;
        // Compute in a loop a max number of points
        // on a line containing point i.
        for (int i = 0; i < n - 1; i++)
            max_count = Math.max(max_points_on_a_line_containing_point_i(i), max_count);
        return max_count;
    }
}
