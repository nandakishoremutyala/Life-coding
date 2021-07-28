package prep_2021.random;

public class Search2DMatrix {
    public static void main(String[] args) {
        boolean result= searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        },3);
        System.out.println(result);

        boolean res= searchMatrix(new int[][]{
                {1},
                {3}
        },1);
        System.out.println(res);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row =matrix.length;
        int col=matrix[0].length;

        int l=0;
        int r=row;
        int tr=-1;
        while(l<r){
            int mid=l+(r+l)/2;

            if(matrix[mid][0]>target){
                r=mid;
            }else if(matrix[mid][0]<target){
                l=mid+1;
                if(mid+1<row && matrix[mid+1][0]>target){
                    tr=mid;
                    break;
                }

            }else{
                tr=mid;
            }
        }
        System.out.println(tr);

        int[] tRow=matrix[tr];
        l=0;
        r=col;

        while (l<r){
            int mid=(r-l)/2+l;
            if(tRow[mid]==target) return true;
            if(tRow[mid]>target){
                r=mid;
            }else if(tRow[mid]<target){
                l=mid+1;
            }
        }
        return false;

    }
}
