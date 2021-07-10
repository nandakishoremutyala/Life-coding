package prep_2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
    /**
     * ["X","X","X","X","X","X"],
     * ["X","*","O","O","O","X"],
     * ["X","O","O","#","O","X"],
     * ["X","X","X","X","X","X"]]
     */
    static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
      /*  int res=getFood(new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        });
        System.out.println(res);*/

        int res=getFood(new char[][]{
                {'O', '*'},
                {'#', 'O'}
        });
        System.out.println(res);
    }

    public static int getFood(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];

        //Arrays.fill(visited, false);
        int[] src = null, dst = null;
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (grid[i][j] == '*') {
                    src = new int[]{i, j};
                    q.add(src);
                    break;
                }
            }
            System.out.println("hello");
        }
        return bfs(grid, q, visited);
    }

    private static int bfs(char[][] grid, LinkedList<int[]> queue, boolean[][] visited) {
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] data = queue.poll();
                visited[data[0]][data[1]] = true;
                if (grid[data[0]][data[1]] == '#') {
                    return res;
                }
                for (int[] d : directions) {
                    int x = d[0] + data[0];
                    int y = d[1] + data[1];
                    System.out.println(x+","+y);
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                        if (grid[x][y] != 'X' && !visited[x][y]) {
                            queue.add(new int[]{x, y});
                            visited[x][y] = true;
                        }

                    }
                }


            }
            res += 1;
        }
        return -1;
    }

}
