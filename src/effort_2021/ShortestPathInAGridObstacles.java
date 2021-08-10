package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridObstacles {

    ShortestPathInAGridObstacles shortestPathInAGridObstacles;

    @BeforeEach
    public void init() {
        shortestPathInAGridObstacles = new ShortestPathInAGridObstacles();
    }

    @Test
    public void firstTest() {
        int res= shortestPathInAGridObstacles.shortestPath(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        },1);
        System.out.println(res);
    }

    public int shortestPath(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //int[] p=new int[4];// x, y, steps, obstacles
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 0, k});
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            grid[p[0]][p[1]] = 2;
            if (p[0] == r-1 && p[1] == c-1)
                min = Math.min(p[2], min);

            int remObs = p[3];
            int step = p[2];

            for (int[] dir : dirs) {
                int nx = p[0] + dir[0];
                int ny = p[1] + dir[1];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {

                    if (grid[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny, step + 1, remObs});
                    } else if (grid[nx][ny] == 1) {
                        if (remObs >= 1) {
                            queue.add(new int[]{nx, ny, step + 1, remObs - 1});
                        }

                    } else continue;
                }
            }
        }
        return min;
    }
}
