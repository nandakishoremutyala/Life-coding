package leetcode;

public class SingleNumberIII {
    public static void main(String[] args) {
        SingleNumberIII singleNumberIII = new SingleNumberIII();
        singleNumberIII.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
    }

    public int[] singleNumber(int[] nums) {
        int diff=0;
        for (int val:nums)
            diff^=val;
        System.out.println("xor of two numbers: "+diff);
        diff&=-diff;
        System.out.println(diff);
        int[] res=new int[2];
        for (int val:nums){
            if((val&diff)==0)
                res[0]^=val;
            else
                res[1]^=val;
        }
        return res;
    }
}



/*
3->011
5->101

xor result : 110*/
