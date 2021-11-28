package leetcode.contests.contest_269;

import java.util.Arrays;

public class KRadiusAverages {
    public static void main(String[] args) {
        int[] input=new int[]{40527,53696,10730,66491,62141,83909,78635,18560};
        int k=2;
        KRadiusAverages kRadiusAverages=new KRadiusAverages();
        kRadiusAverages.getAverages(input,k);
    }
    public int[] getAverages(int[] nums, int k) {
        int[] result=new int[nums.length];
        Arrays.fill(result,-1);
        if(nums.length<=2*k){
            return result;
        }
        if(k==0){
            return nums;
        }
        int[] temp=new int[nums.length];
        temp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            temp[i]=temp[i-1]+nums[i];
        }
        int start=0;
        while(start<nums.length){
            if(start-k<0 ||start+k>=nums.length){
                result[start]=-1;
            }else{
                if(start-k==0){
                    result[start]=temp[start+k]/(2*k+1);
                }else{
                    result[start]=(temp[start+k]-temp[start-k-1])/(2*k+1);
                }
            }
            start++;
        }
        return result;
    }
}
