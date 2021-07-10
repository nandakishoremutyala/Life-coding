package prep_2021;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        longestPalindrome("babad");
        longestPalindrome("cbbd");
        longestPalindrome("a");
        longestPalindrome("ac");
    }
    public static String longestPalindrome(String s) {
         if(s.length()==0)return "";
         if(s.length()==1) return s;
         StringBuilder sb=new StringBuilder() ;
        for (int i = 0; i <s.length() ; i++) {
            int l=i,r =i;
            // odd
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(s.substring(l,r+1).length()>sb.length()){
                    sb=new StringBuilder(s.substring(l,r+1));
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(s.substring(l,r+1).length()>sb.length()){
                    sb=new StringBuilder(s.substring(l,r+1));
                }
                l--;
                r++;
            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
