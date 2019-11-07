package practice.backtracking;

public class PrintPermutation {
    public static void main(String[] args) {
        PrintPermutation printPermutation=new PrintPermutation();
        printPermutation.permute("ABC",0);
    }

    private void permute(String str,int start) {
        if(start==str.length()-1)
            System.out.println(str);
        for (int i=start;i<str.length();i++){
            str= swap(str,start,i);
            permute(str,start+1);
            str= swap(str,i,start);
        }
    }

    private String swap(String str,int i, int j){
        StringBuilder sb=new StringBuilder(str);
        char c=sb.charAt(j);
        sb.setCharAt(j,sb.charAt(i));
        sb.setCharAt(i,c);
        return sb.toString();

    }
}
