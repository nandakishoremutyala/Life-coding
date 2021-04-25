package leetcode.contests.contest_238;

public class SumBase {
    public static int sumBase(int n, int k) {
        StringBuilder s=new StringBuilder();
        while (n>=k){
            int rem=n%k;
            n=n/k;
            s.append(rem);
        }
        s.append(n);
        int r=0;
        for(char c:s.toString().toCharArray())
            r+=Integer.parseInt(String.valueOf(c));
        return r;
    }
}
