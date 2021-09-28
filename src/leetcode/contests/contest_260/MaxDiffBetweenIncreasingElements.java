package leetcode.contests.contest_260;

public class MaxDiffBetweenIncreasingElements {
    public static void main(String[] args) {
        MaxDiffBetweenIncreasingElements md=new MaxDiffBetweenIncreasingElements();
        int res= md.maximumDifference(new int[]{999,997,980,976,948,940,938,928,924,917,907,907,881,878,864,862,
                859,857,848,840,824,824,824,805,802,798,788,777,775,766,755,748,735,732,727,705,700,697,
                693,679,676,644,634,624,599,596,588,583,562,558,553,539,537,536,509,491,485,483,454,449,438,
                425,403,368,345,327,287,285,270,263,255,248,235,234,224,221,201,189,187,183,179,
                168,155,153,150,144,107,102,102,87,80,57,55,49,48,45,26,26,23,15});
        System.out.println(res);
    }
    public int maximumDifference(int[] nums) {
        int len=nums.length;
        if(len==1) return 0;
        int max=-1;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j <len ; j++) {
                int tmp=nums[j]-nums[i];
                if(tmp<=0) continue;
                max=Math.max(tmp,max);
            }
        }
        return max;
    }
}
