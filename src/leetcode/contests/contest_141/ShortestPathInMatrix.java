package leetcode.contests.contest_141;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMatrix {
    ShortestPathInMatrix shortestPathInMatrix;
    int[] x;
    int[] y;
    int ROW;
    int COL;

    class Node {
        int r;
        int c;
        int dist;

        Node(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dist = dis;
        }
    }

    @BeforeEach
    public void init() {

    }

    @Test
    public void firstTest() {
        int[][] input = new int[][]{{0, 1}, {1, 0}};
        int result = shortestPathBinaryMatrix(input);
        System.out.println(result);
    }

    boolean isValid(int row, int col) {
        // return true if row number and column number
        // is in range
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }

    Queue<Node> queue;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return 0;
        x = new int[]{-1, 0, 0, 1, 1, -1, -1, 1};
        y = new int[]{0, -1, 1, 0, 1, -1, 1, -1};
        int dy = grid.length;
        COL = dy;
        int dx = grid[0].length;
        ROW = dx;
        boolean[][] visited = new boolean[dx][dy];
        queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        return bfs(grid, visited);
    }

    int bfs(int[][] grid,
            boolean[][] visited) {
        while (!queue.isEmpty()) {
            Node item = queue.poll();
            if (item.r == ROW - 1 && item.c == COL - 1)
                return item.dist;

            for (int i = 0; i < 8; i++) {
                int nr = item.r + x[i];
                int nc = item.c + y[i];
                if (isValid(nr, nc) && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.add(new Node(nr, nc, item.dist + 1));
                }
            }
        }
        return -1;
    }
}
