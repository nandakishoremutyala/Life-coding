package leetcode.contests.contest_173;

public class RemovePalindromicSubsequence {
    public static void main(String[] args) {

        RemovePalindromicSubsequence removePalindromicSubsequence=new RemovePalindromicSubsequence();
        int res= removePalindromicSubsequence.removePalindromeSub("ababb");
        System.out.println(res);
    }

    public int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 : (s.equals(new StringBuilder(s).reverse().toString()) ? 1:2);
    }
}
