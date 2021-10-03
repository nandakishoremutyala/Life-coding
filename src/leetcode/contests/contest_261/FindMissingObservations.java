package leetcode.contests.contest_261;

import java.util.Arrays;

public class FindMissingObservations {
    public static void main(String[] args) {
        FindMissingObservations fmov=new FindMissingObservations();
        //fmov.missingRolls(new int[]{1,2,3,4},6,4);

        fmov.missingRolls(new int[]{6,3,4,3,5,3},
        1,6);
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
            int m=rolls.length;
            int sum= Arrays.stream(rolls).sum();
            int total=mean*(m+n);
            int left=total-sum;
            if(left<=0 || left<n) return new int[]{};
            int initial=left/n;
            int rem=left%n;
            if(initial>6) return new int[]{};
            if(initial==6 && rem>0) return new int[]{};
            int[] result=new int[n];
            Arrays.fill(result,initial);
            int i=0;
            while (i<n && rem>0){
                result[i]+=1;
                i++;
                rem--;
            }
            return result;
    }
}
