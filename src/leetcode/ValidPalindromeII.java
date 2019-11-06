package leetcode;

public class ValidPalindromeII {
    public static void main(String[] args) {
        ValidPalindromeII validPalindromeII=new ValidPalindromeII();
        validPalindromeII.validPalindrome("bececabbacecb");
    }
    public boolean validPalindrome(String s) {
        char[] arr=s.toCharArray();
        boolean isDeleted=false;
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            if(arr[left]==arr[right]){
                left++;
                right--;
            }else{
                if(isDeleted) return false;
                if(right-1>=left && arr[right-1]==arr[left]){
                    right-=1;
                }else if(left+1<=right && arr[left+1]==arr[right]){
                    left+=1;
                }
                isDeleted=true;
            }
        }
        return true;
    }
}
