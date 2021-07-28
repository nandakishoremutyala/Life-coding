package prep_2021.random;
/**
 * Incorrect implementation
 *
 * */
public class NumMatrix {

    int[][] matrix;
    int[][] rowSum;
    int r,c;
    public NumMatrix(int[][] M) {
        r=M.length;
        c=M[0].length;
        matrix=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j]=M[i][j];
            }
        }

        rowSum=new int[r][c];

        for(int j=0;j<c;j++){
            for(int i=0;i<r;i++){
                if(i==0){
                    rowSum[i][j]=matrix[i][j];
                }else{
                    rowSum[i][j]=rowSum[i-1][j]+matrix[i][j];
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        int prev=matrix[row][col];
        matrix[row][col]=val;
        int diff=val-prev;

        // update row
        for(int i=row;i<r;i++){
            if(i==0){
                rowSum[i][col]=val;
            }else if(i==row){
                rowSum[i][col]=rowSum[i][col]+val;
            }else{
                rowSum[i][col]=rowSum[i][col]+diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int j=col1;j<=col2;j++){
            if(row1==0){
                sum+=rowSum[row2][j];
            }else{
                sum+=rowSum[row2][j]-rowSum[row1-1][j];
            }
        }
        return sum;
    }
}


