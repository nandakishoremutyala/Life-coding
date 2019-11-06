package leetcode;

public class ValidPalindrome {
    public static void main(String[] args) {
        String input="A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome=new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(input));
    }
    public boolean isPalindrome(String s) {
        char[] chars=s.toCharArray();
        StringBuilder sb=new StringBuilder("");
        for(char c:chars){
            if(Character.isDigit(c) || Character.isLetter(c))
                sb.append(c);
        }
        System.out.println(sb.toString());
        return (sb.toString().equalsIgnoreCase(sb.reverse().toString()));
    }
}
