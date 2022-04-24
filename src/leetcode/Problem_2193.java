package leetcode;

class Problem_2193 {
    public int minMovesToMakePalindrome(String s) {
        
        int res=0;
        
        while(s.length()>0){
            int i=s.indexOf(s.charAt(s.length()-1));// you are looking for a position where last character matches. 
            if(i==s.length()-1){ // it it matches with only last position that means it is a unique character, needs to move in the middle. it requires i/2 moves
                res+=i/2;
            }else{
                s=s.substring(0,i)+s.substring(i+1); // just drop the match charater
                res+=i;
            }
            s=s.substring(0,s.length()-1); // drop the last character
        }
        return res;
    }
}
