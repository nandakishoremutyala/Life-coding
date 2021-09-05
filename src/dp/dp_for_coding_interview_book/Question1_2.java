package dp.dp_for_coding_interview_book;

import others.MasterPrinter;

public class Question1_2 {
    static int[] res;
    public static void main(String[] args) {
        res=new int[6];
        int[] in= new int[]{1,2,3,4,5,6};
        int start=0;
        doSum(in,start,res);
        MasterPrinter.printArray(res);
    }

    private static int[] doSum(int[] in, int start, int[] res) {
        if(start>=res.length)
            return res;
        if(start==0)
            res[start]=in[start];
        else
            res[start]=res[start-1]+in[start];
        return doSum(in,start+1,res);
    }
}
