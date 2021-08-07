package effort_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxNumberOfVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) {
                count++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        // handle edge cases
        List<Double> temp = new ArrayList<>(angles);
        for (double d : angles) {
            temp.add(d + 360);
        }
        int res = count;
        for (int i = 0, j = 0; i < temp.size(); i++) {
            while (temp.get(i) - temp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }
}
