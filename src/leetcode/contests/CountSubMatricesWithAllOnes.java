package leetcode.contests.contest_196;

public class CountSubMatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int count=0;
        int R=mat.length;
        int C=mat[0].length;
        for (int r = 0; r <R ; r++) {
            for (int c = 0; c <C ; c++) {
                count=count+compute(mat,R,C,r,c);
            }

        }
        return count;

    }

    private int compute(int[][] mat, int r, int c,int pr,int pc) {
        int count=0;
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){

            }
        }
        return 0;
    }
}
