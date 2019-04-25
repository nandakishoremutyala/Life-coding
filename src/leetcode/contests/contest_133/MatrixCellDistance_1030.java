package leetcode.contests.contest_133;

import java.util.*;

public class MatrixCellDistance_1030 {
    public static void main(String[] args) {
        allCellsDistOrder(2, 3, 1, 2);
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        TreeMap<Integer, List<Integer[]>> map = new TreeMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dis = Math.abs(i - r0) + Math.abs(j - c0);
                map.computeIfAbsent(dis, val -> new ArrayList<>()).add(new Integer[]{i, j});
            }
        }
        int p = 0;
        Iterator<Map.Entry<Integer, List<Integer[]>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Integer[]>> e = it.next();
            List<Integer[]> value = e.getValue();
            for (int i = 0; i < value.size(); i++) {
                result[p] = new int[]{value.get(i)[0], value.get(i)[1]};
                p++;
            }
        }
        return result;
    }
}
