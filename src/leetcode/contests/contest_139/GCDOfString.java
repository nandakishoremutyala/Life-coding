package leetcode.contests.contest_139;

public class GCDOfString {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC","ABC"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        StringBuilder sb=new StringBuilder(str1);
        while (sb.length()>str2.length()){
            if(sb.substring(0,str2.length()).equals(str2))
                sb.delete(0,str2.length());
        }

        if(sb.length()>=str2.length())return "";
        return sb.toString();
    }

}
