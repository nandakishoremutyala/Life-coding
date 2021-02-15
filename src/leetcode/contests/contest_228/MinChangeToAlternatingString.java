package leetcode.contests.contest_228;

public class MinChangeToAlternatingString {
    public int minOperations(String s) {
        StringBuilder sb=new StringBuilder(s);
        int count1=forwardPass(sb,0);
        sb.setLength(0);
        sb=new StringBuilder(s);
        char firstCharChange=sb.charAt(0)=='0'?'1':'0';
        sb.setCharAt(0,firstCharChange);
        int count2=forwardPass(sb,1);
        int forwardMin=Math.min(count1,count2);

        sb=new StringBuilder(s);
        int count3=backwardPass(sb,0);
        sb.setLength(0);
        sb=new StringBuilder(s);
        char lastCharChange=sb.charAt(sb.length()-1)=='0'?'1':'0';
        sb.setCharAt(sb.length()-1,lastCharChange);
        int count4=backwardPass(sb,1);
        int backwardMin=Math.min(count3,count4);


        return Math.min(forwardMin,
                backwardMin);
    }

    private int backwardPass(StringBuilder sb, int count) {
        for(int i=sb.length()-2;i>=0;i--){
            if(sb.charAt(i)==sb.charAt(i+1)){
                char c=sb.charAt(i)=='0'?'1':'0';
                sb.setCharAt(i,c);
                count++;
            }
        }
        return count;
    }

    private int forwardPass(StringBuilder sb, int count) {
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i)==sb.charAt(i-1)){
                char c=sb.charAt(i)=='0'?'1':'0';
                sb.setCharAt(i,c);
                count++;
            }
        }
        return count;
    }
}
