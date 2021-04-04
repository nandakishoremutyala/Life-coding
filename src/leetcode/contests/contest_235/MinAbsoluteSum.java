package leetcode.contests.contest_235;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

public class MinAbsoluteSum {
    MinAbsoluteSum minAbsoluteSum;
    @BeforeEach
    public void init(){
        minAbsoluteSum=new MinAbsoluteSum();
    }
    @Test
    public void firstTest(){
        int res=minAbsoluteSum.minAbsoluteSumDiff(new int[]{1,7,5},new int[]{2,3,5});
        System.out.println(res);
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD=1000000007;
        int maxDiff=Integer.MIN_VALUE;
        int pos=-1;

        for (int i = 0; i <nums1.length ; i++) {
            if(Math.abs(nums1[i]-nums2[i])>maxDiff){
                maxDiff=Math.abs(nums1[i]-nums2[i]);
                pos=i;
            }
        }
        System.out.println("target location: "+pos);

        int minDiff=Integer.MAX_VALUE;
        int minPos=-1;

        int lookCloseTo=nums2[pos];

        for (int i = 0; i <nums1.length ; i++) {
            if(Math.abs(nums1[i]-lookCloseTo)<minDiff){
                minDiff=Math.abs(nums1[i]-lookCloseTo);
                minPos=i;
            }
        }
        System.out.println("replace: "+minPos);

        nums1[pos]=nums1[minPos];
        MasterPrinter.printArray(nums1);

        int res=0;
        for (int i = 0; i < nums1.length; i++) {
            int temp=(Math.abs(nums1[i]-nums2[i]))%MOD;
            res=(res+temp)%MOD;
        }
        return res;

    }
}
