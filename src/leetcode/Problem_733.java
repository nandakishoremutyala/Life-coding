class Solution {
    int[][] dirs=new int[][]{
            {0,-1},{0,1},{-1,0},{1,0}
    };
    boolean[][] visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited=new boolean[image.length][image[0].length];
        dfs(image,sr,sc,newColor);
        //MasterPrinter.printArray(image);
        return image;

    }

    private void dfs(int[][] image,int sr, int sc, int nc){
        int prevColor=image[sr][sc];
        visited[sr][sc]=true;
        image[sr][sc]=nc;

        for(int i=0;i<4;i++){
            int dx=dirs[i][0];
            int dy=dirs[i][1];
            if(sr+dx<0 || sr+dx >=image.length || sc+dy<0 || sc+dy>=image[0].length){
                continue;
            }
            int nx=sr+dx;
            int ny=sc+dy;
            if(image[nx][ny]==prevColor){
                // setup the new color
                if(!visited[nx][ny])
                    dfs(image,nx,ny,nc);
            }

        }

    }
}
