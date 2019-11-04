package leetcode;

import java.util.*;

public class MaximumPathMinimumValue {
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public static void main(String[] args) {
        int[][] input = new int[][]{{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        MaximumPathMinimumValue maximumPathMinimumValue = new MaximumPathMinimumValue();
        System.out.println(maximumPathMinimumValue.maximumMinimumPath(input));
    }

    public int maximumMinimumPath(int[][] A) {
        this.m = A.length;
        this.n = A[0].length;
        this.visited = new boolean[m][n];

        int res = 0;
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (b[2] - a[2]));

        pq.add(new int[]{0, 0, A[0][0]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int val = cur[2];
            if (i == m - 1 && j == n - 1)
                return val;

            if (visited[i][j]) continue;
            visited[i][j] = true;

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (!isValid(ni, nj) || visited[ni][nj]) continue;
                int nVal = A[ni][nj];
                pq.add(new int[]{ni, nj, Math.min(val, nVal)});
            }
        }
        return -1;
    }

    private boolean isValid(int u, int v) {
        if (u < 0 || u >= m || v < 0 || v >= n)
            return false;
        return true;
    }
}
