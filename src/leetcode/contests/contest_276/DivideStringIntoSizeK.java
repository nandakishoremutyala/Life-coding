package leetcode.contests.contest_276;

public class DivideStringIntoSizeK {
    public static void main(String[] args) {
        DivideStringIntoSizeK ds= new DivideStringIntoSizeK();
        ds.divideString("abcdefghij",3,'x');
    }
    public String[] divideString(String s, int k, char fill) {
        int len=s.length();
        int numberOfGroup= len/k;
        int rem=len%k;
        if(rem!=0) {
            numberOfGroup += 1;
        }

        String[] result=new String[numberOfGroup];
        int start=0;
        int index=0;
        while (start<len){
            int end=len;
            if(start+k<=len)
                end=start+k;
            result[index++]=s.substring(start,end);
            start+=k;
        }
        if(result[result.length-1].length()<k){
            String temp=result[result.length-1];
            int diff=k-temp.length();
            StringBuilder sb=new StringBuilder(temp);
            while (diff>0){
                sb.append(fill);
                diff--;
            }
            result[result.length-1]=sb.toString();
        }
        return result;

    }
}
