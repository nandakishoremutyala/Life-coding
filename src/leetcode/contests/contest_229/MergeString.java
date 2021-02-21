package leetcode.contests.contest_229;

public class MergeString {
    public String mergeAlternately(String word1, String word2) {

        int len1=0;
        int len2=0;

        StringBuilder sb=new StringBuilder();
        while (len1<word1.length() && len2<word2.length()){
            sb.append(word1.charAt(len1));
            sb.append(word2.charAt(len2));
            len1++;len2++;
        }
        if(len1<word1.length()){
            sb.append(word1.substring(len1));
        }

        if(len2<word2.length()){
            sb.append(word2.substring(len1));
        }

        return sb.toString();
    }

}
