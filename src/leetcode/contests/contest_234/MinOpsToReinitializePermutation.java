package leetcode.contests.contest_234;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinOpsToReinitializePermutation {
    MinOpsToReinitializePermutation minOpsToReinitializePermutation;
    @BeforeEach
    public void init(){
        minOpsToReinitializePermutation=new MinOpsToReinitializePermutation();
    }
    @Test
    public void firstTest(){
        int res=minOpsToReinitializePermutation.reinitializePermutation(4);
        System.out.println(res);
    }

    public int reinitializePermutation(int n) {
        int[] perm=new int[n];
        int[] orginal=new int[n];
        for (int i = 0; i <n ; i++) {
            perm[i]=i;
            orginal[i]=i;
        }
        int count=0;
        int[] arr=new int[n];
        while(Arrays.hashCode(arr) != Arrays.hashCode(orginal)){
            for (int i = 0; i < n; i++) {
                if(i%2==0){
                    arr[i]=perm[i/2];
                }else{
                    arr[i]=perm[n / 2 + (i - 1) / 2];
                }
            }
            System.arraycopy(arr, 0, perm, 0, n);
            count++;
        }
        return count;
    }
}
