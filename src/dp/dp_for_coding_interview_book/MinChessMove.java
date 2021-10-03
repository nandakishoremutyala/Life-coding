package dp.dp_for_coding_interview_book;

import java.util.LinkedList;
import java.util.Queue;

public class MinChessMove {
    public static void main(String[] args) {
        MinChessMove mcm=new MinChessMove();
        int res= mcm.minKnightMoves(2,1);
        System.out.println(res);
    }
    public int minKnightMoves(int x, int y) {
        int R=x<<2;
        int C=y<<2;
        int[][] dirs=new int[][]{
                {2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}
        };
        int[][] matrix=new int[R][C];
        boolean[][] visited=new boolean[R][C];

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                matrix[i][j]=999;
            }
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        matrix[0][0]=0;
        visited[0][0]=true;

        while(!queue.isEmpty()){
            int[] curr= queue.poll();
            for(int[] dir:dirs){
                int cx=curr[0];
                int cy=curr[1];

                int nx=cx+dir[0];
                int ny=cy+dir[1];

                if(nx>=0 && ny>=0 && nx<R && ny<C && !visited[nx][ny]){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny]=true;
                    matrix[nx][ny]=Math.min(matrix[cx][cy]+1,matrix[nx][ny]);
                }
            }
        }

        return matrix[x][y];
    }
}
